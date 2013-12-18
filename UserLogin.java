package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
public class UserLogin extends JFrame implements ActionListener
{
	JLabel label1=new JLabel("Uname:");
	JLabel label2=new JLabel("Upassword:");
	JButton button1=new JButton("登陆");
	JButton button2=new JButton("返回");
	JButton button3=new JButton("退出");
	JTextField text1=new JTextField();
	JPasswordField text2=new JPasswordField();
	Quary quary;
	static Connection Con=null;
	Statement stmt=null;
	public UserLogin()
	{
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.validate();
		this.setTitle("用户登陆");
		this.setLayout(null);
		this.add(label1);
		this.add(label2);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(text1);
		this.add(text2);
		label1.setBounds(180,60,200,100);
		text1.setBounds(250,100,150,30);
		label2.setBounds(160,160,200,100);
		text2.setBounds(250,200,150,30);
		button1.setBounds(280,270,100,30);
		button2.setBounds(200,350,100,30);
		button3.setBounds(340,350,100,30);
		text1.setText("");
		text2.setEchoChar('●');
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
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
			//从数据库中读取用户注册的姓名和密码，并做相应的验证
			try 
			{
				String str0=text1.getText();
			    String str1=text2.getText();
			    String SQLsquary="select * from passenger where passenger.PassengerName='"+str0+"' and passenger.PassengerPassword='"+str1+"'";
			    stmt=Con.createStatement();//创建命令
			    ResultSet result=stmt.executeQuery(SQLsquary);
			  
			   if(result.next())
			   {
			       dispose();
			       new Quary();//登陆成功则跳转到用户选择查询界面;
			   } 
			   else
			   {
			       dispose();
			       JOptionPane.showMessageDialog(null, "这个账号你没有注册,先注册这个账号");
			       new Welcome();
			   }
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, "登陆失败");
			}
		}
		if(object.equals(button2))
		{
			dispose();
			new UsersRegister();//返回到初始注册界面
		}
		if(object.equals(button3))
		{
		    int j=JOptionPane.showConfirmDialog(null,"确定要退出吗?","退出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
			if(j==JOptionPane.YES_NO_OPTION)
			{
			   System.exit(0);
			}
		}
	}
}

