package 长途汽车管理系统;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class 登陆界面 extends JFrame implements ActionListener
{
    JLabel la1;
    JLabel la2;
	JButton btn1;
	JButton btn2;
	Panel p,p1,p2;
	JTextField txt;
	JPasswordField jpw;
	登陆界面()
	{
		setSize(500,300);
		setVisible(true);
		setTitle("登陆");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		 int windowWidth = this.getWidth(); //获得窗口宽
		 int windowHeight = this.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		 int screenHeight = screenSize.height; //获取屏幕的高
		this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		JLabel lab=new JLabel("欢迎登陆长途汽车管理系统");
		int size=30;
		lab.setFont(new Font("Serif",Font.PLAIN,size));
		lab.setBounds(50, 5, 400,50);
		la1=new JLabel("请输入用户名：");
		la1.setBounds(50, 50, 150, 30);
		la2=new JLabel("请输入密码：");
		la2.setBounds(50, 100, 150, 30);
		p=new Panel();
		p.setBounds(0, 0,500, 300);
		p.setLayout(null);
		txt=new JTextField(10);
		txt.setBounds(210, 50, 200, 30);
		jpw=new JPasswordField(20);
		jpw.setBounds(210, 100, 200, 30);
		btn1=new JButton("登陆");
		btn1.setBounds(150, 150, 70, 30);
		btn2=new JButton("注册");
		btn2.setBounds(250, 150, 70, 30);
		//btn1.setBounds(300, 300, 50, 30);
		//p2.setBounds(300, 300, 100, 50);
		add(p);
		p.add(lab);
		p.add(la1);
		p.add(txt);
		p.add(la2);
		p.add(jpw);
		p.add(btn1);
		p.add(btn2);
		validate();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
    }
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)     
		{
			String str1=txt.getText();
			String str2=jpw.getText();
			boolean bi1=false;
			if(str1.equals("窦元国"))
			{
				if(str2.equals("123"))
				{
					new 管理员操作界面();
					bi1=true;
				}
			}
			if(!bi1)
			{
			//登陆前提是有用户名且密码正确
			String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url="jdbc:sqlserver://localhost:1433;DatabaseName=长途汽车管理系统数据库";
			try 
			{
				Class.forName(JDriver);
			} 
		    catch (ClassNotFoundException e1) 
		    {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try 
			{
				Connection con=DriverManager.getConnection(url,"admin","1");
				Statement s=con.createStatement();
				String str3="select * from 用户表";
				ResultSet rs=s.executeQuery(str3);
				boolean b1=false;//用来判断是否用户名和密码都正确
				//JOptionPane.showMessageDialog(null,"存在这个用户！密码：");
				JOptionPane.showMessageDialog(null,"用户名："+str1);
				while(rs.next())
				{
					
					String ss1=rs.getString("用户名").trim();
					//JOptionPane.showMessageDialog(null,"存在这个用户！用户名："+ss1+str1);
					String ss2=rs.getString("密码").trim();
					//JOptionPane.showMessageDialog(null,"存在这个用户！密码："+str2+ss2+str1.equals(ss1));
					if(str1.equals(ss1))
					{
						//JOptionPane.showMessageDialog(null,"存在这个用户！密码："+ss2);
						if(str2.equals(ss2))
						{ 
							b1=true;
							JOptionPane.showMessageDialog(null,"可以登录了！");
							new 用户操作界面(ss1);
						}
					}
				}
				if(!b1)     //不正确则执行
				{
					JOptionPane.showMessageDialog(null,"你输入的用户名或者密码不对，请重试！");
					jpw.setText(null);
					
				}
				else
				{
					s.close();
				    con.close();
				    this.dispose();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
		if(e.getSource()==btn2)      //注册是直接关掉当前界面，进入注册界面
		{
			JOptionPane.showMessageDialog(null,"马上进入注册界面了！");
			this.dispose();
			new 注册界面();
		}	
	} 
	public static void main(String[] args)
	{
		new 登陆界面();
	}
}
