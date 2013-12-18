package 长途汽车管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class 注册界面  extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -4973689437504179656L;
	JLabel la1;
    JLabel la2;
    JLabel la3;
	JButton btn1;
	JButton btn2;
	Panel p,p1,p2,p3;
	JTextField txt;       //用来存放用户名
	JPasswordField jpw1;   //密码
	JPasswordField jpw2;
	注册界面()
	{
		
		setSize(400,300);
		setVisible(true);
		setTitle("注册");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 int windowWidth = this.getWidth(); //获得窗口宽
		 int windowHeight = this.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		 int screenHeight = screenSize.height; //获取屏幕的高
		this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		setLayout(null);
		JLabel lab=new JLabel("欢迎注册长途汽车管理系统");
		int size=30;
		lab.setFont(new Font("Serif",Font.PLAIN,size));
		lab.setBounds(10, 5, 380,50);
		la1=new JLabel("请输入用户名：");
		la1.setBounds(30, 70, 150, 30);
		la2=new JLabel("请输入密码：");
		la2.setBounds(30, 110, 150, 30);
		la3=new JLabel("请重新输入密码：");
		la3.setBounds(30, 150, 150, 30);
		p=new Panel();
		p.setBounds(0, 0, 400, 300);
		p.setLayout(null);
		txt=new JTextField(20);
		txt.setBounds(200, 70, 150, 30);
		jpw1=new JPasswordField(20);
		jpw1.setBounds(200, 110, 150, 30);
		jpw2=new JPasswordField(20);
		jpw2.setBounds(200, 150, 150, 30);;
		btn1=new JButton("返回登陆界面");
		btn1.setBounds(50, 200, 130, 50);
		btn2=new JButton("注册");
		btn2.setBounds(200, 200, 130, 50);
		add(p);
		p.add(lab);
		p.add(la1);
		p.add(txt);
		p.add(la2);
		p.add(jpw1);
		p.add(la3);
		p.add(jpw2);
		p.add(btn1);
		p.add(btn2);
		validate();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		
		
		
		if(e.getSource()==btn1)     //返回登陆界面
		{
			JOptionPane.showMessageDialog(null,"马上返回登录界面了！");
			new 登陆界面();
			this.dispose();
			
			
		}
		if(e.getSource()==btn2)      //注册
		{
			String str=txt.getText();
			String strr="'"+txt.getText().trim()+"'";
			String str1=jpw1.getText();
			String str1r="'"+jpw1.getText().trim()+"'";
			String str2=jpw2.getText();
			
			boolean bh=false;          //判断当前用户名是不是管理员的用户名
			if(str.equals("窦元国"))
			{
				bh=true;
				JOptionPane.showMessageDialog(null,"你输入的用户名是管理员用户名，请重新输入！");
				txt.setText(null);
				jpw1.setText(null);
				jpw2.setText(null);
			}
			
			if(!bh)      //不是管理员用户名时才可以注册
			{
			
			//JOptionPane.showMessageDialog(null,str1+str2);
			if(!str1.equals(str2))    //两次输入密码不一样是执行
			{
				//System.out.println("两次输入的密码不一样，请重新输入！");
				JOptionPane.showMessageDialog(null,"两次输入的密码不一样，请重新输入！");
				jpw1.setText(null);
				jpw2.setText(null);
			}
			
			else   //开始向数据库中加入当前注册的用户的信息，如果当前用户名在数据库中已经存在，则让用户重新注册
			{
				
				//以下是访问数据库的内容

				String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String url="jdbc:sqlserver://localhost:1433;DatabaseName=长途汽车管理系统数据库";
				
				try {
					Class.forName(JDriver);          //注册
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 
				try {
					Connection con=DriverManager.getConnection(url,"admin","1");   //连接
					Statement s=con.createStatement();
					String str3="select 用户名 from 用户表";
					//PreparedStatement ps=con.prepareStatement(str3);
					ResultSet rs=s.executeQuery(str3);
					boolean b1=false;       //用来判断是否用户名和密码都正确
					//JOptionPane.showMessageDialog(null,"存在这个用户！密码：");
					//JOptionPane.showMessageDialog(null,"用户名："+str);
					while(rs.next())
					{
						
						String ss1=rs.getString("用户名").trim();
						//JOptionPane.showMessageDialog(null,"存在这个用户！用户名："+ss1+str);
						
						
						if(str.equals(ss1))   //存在这个用户，重新注册
						{
							b1=true;
							JOptionPane.showMessageDialog(null,"你输入的用户名已经被注册，请重试！");
						}
					}
					if(!b1)     //不存在这个用户时执行想数据库中写入用户信息
					{
						String stt="insert into 用户表(用户名,密码) values("+strr+","+str1r+")";
						JOptionPane.showMessageDialog(null,"马山开始注册！");
						s.executeUpdate(stt);              ////根据stt中的语句创建表
						JOptionPane.showMessageDialog(null,"已经成功注册，请在登陆界面输入用户名和密码登陆！");
						s.close();
					    con.close();     //关闭与数据库相关的连接
					    this.dispose();
					    new 登陆界面();
						
					}
					else     //存在这个用户时关闭连接，重新输入注册信息
					{
						s.close();
					    con.close();      //关闭与数据库相关的连接
					    txt.setText(null);
						jpw1.setText(null);
						jpw2.setText(null);
						
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"访问数据库出现异常！");
					e1.printStackTrace();
				}
				
			}
			
			}
		}
		
		
	}
	
	
	public static void main(String[] args)
	{
		
		new 注册界面();
		
		
	}
	
	
}
