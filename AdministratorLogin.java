package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
public class AdministratorLogin extends JFrame implements ActionListener
{
	JLabel label1=new JLabel("欢迎登陆汽车管理系统");
	JLabel label2=new JLabel("Administratorname:");
	JLabel label3=new JLabel("Administratorpassword:");
	JCheckBox button0=new JCheckBox("登陆");
	JButton button1=new JButton("返回");
	JButton button2=new JButton("退出");
	JTextField text1=new JTextField();
	JPasswordField text2=new JPasswordField(10);
	static Connection Con=null;
	Statement stmt=null;
	Aoperate operate;
    public AdministratorLogin()
    {
    	this.setSize(500,400);
    	this.setLocationRelativeTo(null);
		this.setTitle("长途汽车管理系统管理员登陆界面");
		this.setVisible(true);
		this.setLayout(null);
		this.validate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setForeground(Color.blue);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(text1);
		this.add(text2);
		this.add(button0);
		this.add(button1);
		this.add(button2);
		label1.setBounds(160,40,200,40);
		label2.setBounds(40,120,100,40);
		label3.setBounds(20,200,100,40);
		text1.setBounds(150,120,200,40);
		text2.setBounds(150,200,200,40);
		button0.setBounds(230,250,100,30);
		button1.setBounds(130,280,100,30);
		button2.setBounds(260,280,100,30);
		text1.setText("");
		text2.setEchoChar('●');
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
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
    	if(object.equals(button0))
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
			    	  JOptionPane.showMessageDialog(null, "登陆成功");
			    	  dispose();
			    	  new Aoperate();//跳转到管理员操作界面;
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "用户名或密码不正确,请从新输入");
			      }
			   }
			}
    		catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, "验证失败");
			}
    	}
    	if(object.equals(button1))
    	{
    		//关闭界面,返回到初始登陆注册界面
    		dispose();
    		new Welcome();
    	}
    	if(object.equals(button2))
    	{
    		int j=JOptionPane.showConfirmDialog(null,"确定要退出吗?","退出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
			   if(j==JOptionPane.YES_NO_OPTION)
			   {
			      System.exit(0);
			   }
    	}
    }
}
