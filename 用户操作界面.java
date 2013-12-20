package 长途汽车管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;


class ImagePanel extends JPanel {

	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    ImageIcon icon = new ImageIcon("1.jpg");
	    g.drawImage(icon.getImage(), 0, 0, null);

	}
	}
public class 用户操作界面 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p1,p2,p3;
	JTabbedPane jtb;
	//查询的各种控件
	JLabel jlb1,jlb2,jlb3;
	JTextField txt1,txt2,txt3;//与标签对应的文本框
	JButton jbn1,jbn2,jbn3;
	JTextArea tx1=new JTextArea(7,20);
	JScrollPane jsc1;
	//订票用到的各种控件
	JLabel jlb11,jlb21,jlb31;
	JTextField txt11,txt21,txt31;//与标签对应的文本框
	JButton jbn11,jbn21,jbn31;
	JTextArea tx2=new JTextArea(7,20);
	JScrollPane jsc2;
	//退票用到的各种控件
	JLabel jlb12,jlb22,jlb32;
	JTextField txt12,txt22,txt32;//与标签对应的文本框
	JButton jbn12,jbn22,jbn32;
	JTextArea tx3=new JTextArea(7,20);
	JScrollPane jsc3;
	Image img;
	String name;
	用户操作界面(String name1)
	{
		name=name1;
		setSize(960,720);
		int b=this.getSize().height;
		int a=this.getSize().width;
		setVisible(true);
		setTitle("长途汽车管理系统");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 int windowWidth = this.getWidth(); //获得窗口宽
		 int windowHeight = this.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		 int screenHeight = screenSize.height; //获取屏幕的高
		this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		setLayout(null);//new FlowLayout());
		jtb=new JTabbedPane();
		jtb.setBounds(0, 0, a, b);
		p1=new ImagePanel();
	    p1.setBounds(0, 0, a, b);
	    p1.setLayout(null);         //必须设定面板容器内部的界面布局为空才可以自己定义那一个控件的位置和大小
		p2=new ImagePanel();
		p2.setBounds(0,0, a, b);
		p2.setLayout(null);
		p3=new ImagePanel();
		p3.setBounds(0, 0, a, b);
		p3.setLayout(null);
		jtb.addTab("查询", p1);
		jtb.addTab("订票", p2);
		jtb.addTab("退票", p3);
	    this.getContentPane().add(jtb);
		查询();
		订票();
		退票();
		validate();
		
	}
	public void actionPerformed(ActionEvent e)  //按钮的回调函数
	{
		if(e.getSource()==jbn1)
		{
			查询1();
			
		}
		
		if(e.getSource()==jbn11)
		{
			
			订票1();
			//JOptionPane.showMessageDialog(null,"连接成功：123");
		}
		
		if(e.getSource()==jbn21)
		{
			
			订票2();
			//JOptionPane.showMessageDialog(null,"连接成功：123");
		}
		if(e.getSource()==jbn12)
		{
			
			退票2();
			//JOptionPane.showMessageDialog(null,"连接成功：123");
		}
		
	}
	
	public void 查询()
	{
		jlb1=new JLabel("请输入起点：");
		jlb1.setBounds(100, 10, 200, 30);
		jlb2=new JLabel("请输入终点：");
		jlb2.setBounds(100, 50, 200, 30);
		txt1=new JTextField(10);
		txt1.setBounds(220, 10, 200, 30);
		txt2=new JTextField(10);
		txt2.setBounds(220, 50, 200, 30);
		jbn1=new JButton("开始查询");
		jbn1.addActionListener(this);
		jbn1.setBounds(200, 100, 100, 40);
		p1.add(jlb1);
		p1.add(jlb2);
		p1.add(txt1);
		p1.add(txt2);
		p1.add(jbn1);
		//tx1.setBounds(10, 160, 500, 300);
		jsc1=new JScrollPane(tx1);          //带滚动条的文本区
		jsc1.setBounds(10, 160, 500, 300);
		p1.add(jsc1);
	}
	
	public void 查询1()
	{

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
			JOptionPane.showMessageDialog(null,"连接成功：");
			Statement s=con.createStatement();
			String yy1=txt1.getText().trim();
			String yy2=txt2.getText().trim();
			
			String aq1="'"+yy1+"'";
			String aq2="'"+yy2+"'";
			String asd=null;
		
		
			//JOptionPane.showMessageDialog(null,"马上开始查询数据库：");
			String sdd="select * from 路线表";
			ResultSet rs=s.executeQuery(sdd);
			
			boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs.next())
			{
				if(yy1.equals(rs.getString("起点").trim()))
				{
					if(yy2.equals(rs.getString("终点").trim()))
					{
							bh1=true;
							asd=rs.getString("路线编号").trim();
					}
				}
			}
			
			if(bh1)
			{
				String sdd1="select * from 汽车表";
				ResultSet rs1=s.executeQuery(sdd1);
				//boolean bh2=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				while(rs1.next())
				{
					//JOptionPane.showMessageDialog(null,"开始查找汽车表！"+asd+rs1.getString("路线编号").trim().equals(asd)+rs1.getString("路线编号").trim());
					if(rs1.getString("路线编号").trim().equals(asd))
					{
						String haha="汽车编号          "+"路线编号          "+"发车时间          "+"最大容量          "+"剩余容量           "+"价格";
						tx1.append(haha+"\n");
						String haha1=rs1.getString("汽车编号").trim()+"          "+rs1.getString("路线编号").trim()+"          "
								+rs1.getString("发车时间").trim()+"          "+rs1.getString("最大容量").trim()+"          "+
								rs1.getString("剩余容量").trim()+"          "+rs1.getString("价格").trim();
						tx1.append(haha1);
						
						
						
					}
				}
				
				
			}
			
			
			JOptionPane.showMessageDialog(null,"添加成功！");
			//JOptionPane.showMessageDialog(null,"用户名："+str);
			
			    s.close();
			    con.close();      //关闭与数据库相关的连接
				  txt1.setText(null);
				  txt2.setText(null);
				 
				
		
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
		    
		    
		    }
		
	}
	
	
	 
	public void 订票()
	{
		jlb11=new JLabel("请输入起点：");
		jlb11.setBounds(100, 10, 200, 30);
		jlb21=new JLabel("请输入终点：");
		jlb21.setBounds(100, 50, 200, 30);
		txt11=new JTextField(10);
		txt11.setBounds(220, 10, 200, 30);
		txt21=new JTextField(10);
		txt21.setBounds(220, 50, 200, 30);
		jbn11=new JButton("开始查询");
		jbn11.setBounds(200, 100, 100, 40);
		jbn11.addActionListener(this);
		p2.add(jlb11);
		p2.add(jlb21);
		p2.add(txt11);
		p2.add(txt21);
		p2.add(jbn11);
		jsc2=new JScrollPane(tx2);
		jsc2.setBounds(10, 160, 500, 300);
		p2.add(jsc2);
		
		jlb31=new JLabel("请输入要乘坐的汽车编号");
		jlb31.setBounds(600, 250, 200, 30);
		txt31=new JTextField(10);
		txt31.setBounds(600, 300, 200, 30);
		jbn21=new JButton("确认购买");
		jbn21.setBounds(650, 350, 100, 50);
		jbn21.addActionListener(this);
		p2.add(jlb31);
		p2.add(txt31);
		p2.add(jbn21);
		
	}
	
	public void 订票1()
	{
		//JOptionPane.showMessageDialog(null,"连接成功：123444");

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
			//JOptionPane.showMessageDialog(null,"连接成功：");
			Statement s=con.createStatement();
			String yy1=txt11.getText().trim();
			String yy2=txt21.getText().trim();
			
			String aq1="'"+yy1+"'";
			String aq2="'"+yy2+"'";
			String asd=null;
		
		
			//JOptionPane.showMessageDialog(null,"马上开始查询数据库：");
			String sdd="select * from 路线表";
			ResultSet rs=s.executeQuery(sdd);
			
			boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs.next())
			{
				if(yy1.equals(rs.getString("起点").trim()))
				{
					if(yy2.equals(rs.getString("终点").trim()))
					{
							bh1=true;
							asd=rs.getString("路线编号").trim();
					}
				}
			}
			
			if(bh1)
			{
				tx2.setText(null);
				String sdd1="select * from 汽车表";
				ResultSet rs1=s.executeQuery(sdd1);
				//boolean bh2=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				String haha="汽车编号          "+"路线编号          "+"发车时间          "+"最大容量          "+"剩余容量           "+"价格";
				tx2.append(haha+"\n");
				while(rs1.next())
				{
				//	JOptionPane.showMessageDialog(null,"开始查找汽车表！"+asd+rs1.getString("路线编号").trim().equals(asd)+rs1.getString("路线编号").trim());
					if(rs1.getString("路线编号").trim().equals(asd))
					{
						String haha1=rs1.getString("汽车编号").trim()+"          "+rs1.getString("路线编号").trim()+"          "
								+rs1.getString("发车时间").trim()+"          "+rs1.getString("最大容量").trim()+"          "+
								rs1.getString("剩余容量").trim()+"          "+rs1.getString("价格").trim();
						tx2.append(haha1);
					}
				}
			}
			//JOptionPane.showMessageDialog(null,"添加成功！");
			    s.close();
			    con.close();      //关闭与数据库相关的连接
				  txt11.setText(null);
				  txt21.setText(null);
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
		    }
	}
	
	public void 订票2()
	{
		int ll=0;
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
			//JOptionPane.showMessageDialog(null,"连接成功：");
			Statement s=con.createStatement();
			 String aqq1=txt31.getText().trim();
			 String aqq2="'"+aqq1+"'";
			String sdd1="select * from 汽车表 where 汽车编号="+aqq2;
			ResultSet rs0=s.executeQuery(sdd1);
			boolean bh0=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs0.next())//查看当前有多少个用户初始值为0
			{
				//JOptionPane.showMessageDialog(null,"有这个车");
				int qq1=rs0.getInt("剩余容量");
				if(qq1>0)
				{
					bh0=true;
					qq1--;
					ll=qq1;
				}
			}
			
			
			
			if(bh0)
			{
			//JOptionPane.showMessageDialog(null,"马上开始查询数据库：");
			String sdd="select * from 订票表";
			ResultSet rs=s.executeQuery(sdd);
			int aas=0;
			//boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs.next())//查看当前有多少个用户初始值为0
			{
				aas++;
			}
			aas++;
			String str1=String.valueOf(aas);
             String aq1=txt31.getText().trim();
			String str2="'"+aq1+"'";
			String str3="'"+name+"'";
			String str4="'"+"否"+"'";
			//JOptionPane.showMessageDialog(null,"订票成功！1238");
			String stt="insert into 订票表 values("+str1+","+str2+","+str3+","+str4+")";
			s.executeUpdate(stt);
			JOptionPane.showMessageDialog(null,"订票成功!");
			//JOptionPane.showMessageDialog(null,"开始修改汽车表：");
			String sc=String.valueOf(ll);
			String stt1="UPDATE 汽车表 SET 剩余容量="+sc+" where 汽车编号="+aqq2;
			s.executeUpdate(stt1);
			//JOptionPane.showMessageDialog(null,"修改成功！4444");
			    s.close();
			    con.close();      //关闭与数据库相关的连接
			    退票1();
				 
			}
			
			
			else
			{
				JOptionPane.showMessageDialog(null,"输入的汽车编号不存在，请重试！");
			    s.close();
			    con.close();      //关闭与数据库相关的连接
				  txt11.setText(null);
				  txt21.setText(null);
			}
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,e2.toString());
		    }
	}

	public void 退票()
	{
		jsc3=new JScrollPane(tx3);
		jsc3.setBounds(10, 10, 500, 300);
		p3.add(jsc3);
		jlb12=new JLabel("请输入要退票订单号");
		jlb12.setBounds(10, 350, 200, 30);
		txt12=new JTextField(10);
		txt12.setBounds(10, 400, 200, 30);
		jbn12=new JButton("确认退票");
		jbn12.addActionListener(this);
		jbn12.setBounds(100, 450, 100, 50);
		p3.add(jlb12);
		p3.add(txt12);
		p3.add(jbn12);
		退票1();
	}
	public void 退票1()
	{
		tx3.setText(null);
		//JOptionPane.showMessageDialog(null,"连接成功：123444");

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
			//JOptionPane.showMessageDialog(null,"连接成功：");
			Statement s=con.createStatement();
			String yy1=txt12.getText().trim();
			String aq1="'"+yy1+"'";
			String asd=null;
			String sss="'"+name+"'";
			//JOptionPane.showMessageDialog(null,"马上开始查询数据库：");
			String sdd="select * from 订票表 where 用户名="+sss;
			ResultSet rs=s.executeQuery(sdd);
			String haha="订单号          "+"汽车编号          "+"用户名          "+"是否退票";
			tx3.append(haha+"\n");
			boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs.next())
			{
				String aaa=rs.getString("订单号")+"          "+rs.getString("汽车编号")+"          "+rs.getString("用户名")
						+"         "+rs.getString("是否退票");
				tx3.append(aaa);
				tx3.append("\n");
			}
			    s.close();
			    con.close();      //关闭与数据库相关的连接
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
		    }
	}
	
	
	public void 退票2()
	{
		String aqq2=null;
		//JOptionPane.showMessageDialog(null,"连接成功：123444");

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
			//JOptionPane.showMessageDialog(null,"连接成功：lll");
			Statement s=con.createStatement();
			String yy1=txt12.getText().trim();
			String aq1="'"+yy1+"'";
			String asd=null;
			String sss="'"+name+"'";
		
		
			//JOptionPane.showMessageDialog(null,"马上开始查询数据库：123");
			String sdd="select * from 订票表 where 用户名="+sss;
			ResultSet rs=s.executeQuery(sdd);
			boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs.next())
			{
				//JOptionPane.showMessageDialog(null,"得到编号！"+yy1.equals(rs.getString("订单号"))+yy1+rs.getString("订单号"));
				if(yy1.equals(rs.getString("订单号").trim()))
				{
					bh1=true;
					aqq2="'"+rs.getString("汽车编号").trim()+"'";
					//JOptionPane.showMessageDialog(null,"得到编号！");
					
				}
			}
			if(bh1)
			{
			String stt1="UPDATE 订票表 SET 是否退票="+"'"+"是"+"'"+" where 订单号="+aq1;
			s.executeUpdate(stt1);
			JOptionPane.showMessageDialog(null,"退票成功！");
			
			//开始修改汽车表中的剩余容量
			int ll=0;
			String sdd1="select * from 汽车表 where 汽车编号="+aqq2;
			ResultSet rs0=s.executeQuery(sdd1);
			boolean bh0=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
			while(rs0.next())//查看当前有多少个用户初始值为0
			{
				//JOptionPane.showMessageDialog(null,"有这个车"+rs0.getInt("剩余容量"));
				int qq1=rs0.getInt("剩余容量");
				qq1++;
				ll=qq1;
			}
			
			//JOptionPane.showMessageDialog(null,"llllk"+ll);
			String stt2="UPDATE 汽车表 SET 剩余容量="+ll+" where 汽车编号="+aqq2;
			s.executeUpdate(stt2);
			
			}
			
			 s.close();
			  con.close();      //关闭与数据库相关的连接
		}catch(Exception e1)
			{
				 
			
			}
			
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new 用户操作界面("name1");

		
		
		
	}

}
