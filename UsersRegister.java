package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
import java.io.*;
import java.util.*;
public class UsersRegister extends JFrame implements ActionListener 
{
	JLabel label1=new JLabel("欢迎注册汽车管理系统");
	JLabel label2=new JLabel("PassengerName:");
	JLabel label3=new JLabel("PassengerPassword:");
	JTextField text1=new JTextField();
	JPasswordField text2=new JPasswordField();
	JButton button0=new JButton("注册");
	JButton button1=new JButton("返回");
	JButton button2=new JButton("退出");
	static Connection Con=null;
	Statement stmt=null;
	UserLogin Userlogin;
	public  UsersRegister()
	{
		this.setSize(500,440);
		this.setLocationRelativeTo(null);
		this.setTitle("乘客注册界面");
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
		text2.setEchoChar('●');
		this.add(button0);
		this.add(button1);
		this.add(button2);
		ButtonGroup button=new ButtonGroup();
		button.add(button1);
		button.add(button2);
		label1.setBounds(160,40,200,40);
		label2.setBounds(40,120,100,40);
		label3.setBounds(20,200,100,40);
		text1.setBounds(150,120,200,40);
		text2.setBounds(150,200,200,40);
		button0.setBounds(200,280,100,30);
		button1.setBounds(130,350,100,30);
		button2.setBounds(260,350,100,30);
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
				String str2=text1.getText();
				String str3=text2.getText();
				String SQLsquary="select * from passenger";
				stmt=Con.createStatement();
				ResultSet result1=stmt.executeQuery(SQLsquary);
				if(!result1.next())
				{
					stmt=Con.createStatement();//创建命令
					String str4="insert into passenger values('"+str2+"','"+str3+"');";
					stmt.executeUpdate(str4);
					JOptionPane.showMessageDialog(null, "注册成功");
					dispose();
					new UserLogin();
				}
				else
				{
					stmt=Con.createStatement();
					String SQLquary="select * from passenger where passenger.PassengerName='"+str2+"'";
					ResultSet result2=stmt.executeQuery(SQLquary);
				    if(result2.next())
					{
						JOptionPane.showMessageDialog(null, "该用户名和密码已经被注册过,请重注册一个用户名");
					}
					else
					{
						stmt=Con.createStatement();//创建命令
						String str5="insert into passenger values('"+str2+"','"+str3+"');";
						stmt.executeUpdate(str5);
						JOptionPane.showMessageDialog(null, "注册成功");
						dispose();
						new UserLogin();
					}
				}
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(object.equals(button1))
		{
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
