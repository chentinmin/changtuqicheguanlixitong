package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
public class Login extends JFrame implements ActionListener
{
	JLabel label1=new JLabel("欢迎登陆汽车管理系统");
	JLabel label2=new JLabel("Aname:");
	JLabel label3=new JLabel("Apassword:");
	JLabel label4=new JLabel("Uname");//
	JLabel label5=new JLabel("Upassword");
	JButton button1=new JButton("管理员登陆");
	JButton button2=new JButton("用户注册");
	JButton button3=new JButton("退出");
	JButton button4=new JButton("退出");
	JTextField text1=new JTextField();
	JTextField text2=new JTextField();
	JTextField text3=new JTextField();
	JTextField text4=new JTextField();
	JPanel panel=new JPanel();
	static Connection Con=null;
	Statement stmt=null;
	Aoperate operate;
	UserLogin userlogin=null;
	public Login()
	{
		//this.setSize(600,600);
		this.setTitle("长途汽车管理系统管理员登陆界面");
		this.setVisible(true);
		this.setLayout(null);
		this.validate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setForeground(Color.blue);
		this.add(panel);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(text1);
		this.add(text2);
		this.add(text3);
		this.add(text4);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		label1.setBounds(230,40,200,40);
		label2.setBounds(140,120,100,40);
		label3.setBounds(120,200,100,40);
		button1.setBounds(200,260,100,30);
		button3.setBounds(320,260,60,30);
		text1.setBounds(200,120,200,40);
		text2.setBounds(200,200,200,40);
		label4.setBounds(140,350,100,40);
		label5.setBounds(120,420,100,40);
		text3.setBounds(200,350,200,40);
		text4.setBounds(200,420,200,40);
		button2.setBounds(200,480,100,30);
		button4.setBounds(320,480,60,30);
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
	}
	public static void main(String args[])
	{
		Login login=new Login();
	}
	public void actionPerformed(ActionEvent e)
	{
		Object object=e.getSource();
		String conURL="jdbc:sqlserver://localhost:1433;databaseName=CTQCGLXT";
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try
		{
		   Class.forName(JDriver);
		}
		catch(ClassNotFoundException ee)
		{
		   JOptionPane.showMessageDialog(null, "加载和注册不成功");
		}
		try
		{
		   Con=DriverManager.getConnection(conURL,"11","1");
		}
		catch(Exception ee)
		{
		   JOptionPane.showMessageDialog(null, "连接数据库失败");
		}
		if(object.equals(button1))
		{
			try 
			{
			   String SQLsquary="select Aname,password from administrator";
			   stmt=Con.createStatement();//创建命令
			   ResultSet result=stmt.executeQuery(SQLsquary);
			   while(result.next())
			   {
			      String str0=result.getString("Aname");
		          String str1=result.getString("password");
			      if(str0.equals(text1.getText())&&str1.equals(text2.getText()))
			      {
			    	  
			    	  dispose();
			    	  new Aoperate();//跳转到管理员操作界面;
			      }
			   }
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, "验证失败");
			}
		}
		if(object.equals(button2))
		{
			try
			{
				String str2=text3.getText();
				String str3=text4.getText();
				stmt=Con.createStatement();//创建命令
				String str4="insert into passenger values('"+str2+"','"+str3+"');";
				stmt.executeUpdate(str4);
				JOptionPane.showMessageDialog(null, "注册成功");
				dispose();
				new UserLogin();//跳转到用户登陆界面
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, "注册不成功");
			}
			
		}
		if(object.equals(button3)||object.equals(button4))
		{
		   int j=JOptionPane.showConfirmDialog(null,"确定要退出吗?","退出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
		   if(j==JOptionPane.YES_NO_OPTION)
		   {
		      System.exit(0);
		   }
		}
	}
}
