package 长途汽车管理系统;
//import java.awt.FlowLayout
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class 管理员操作界面 extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -6307624427471656520L;
	JLabel la1; 
    JLabel la2;
    JLabel la3;
	JButton btn1;
	JButton btn2;
	JButton btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	Panel p,p1,p2,p3;
	JTabbedPane jtb;
	//以下的boolean型都是用来控制9个人内部窗体的
	boolean bb1=false,bb2=false,bb3=false,bb4=false,bb5=false,bb6=false,bb7=false,bb8=false,bb9=false;
	boolean bn,bn1,bn2;      //这个是用来检验 在修改时填写的要修改的哪一项输入是否正确正确为false
	JInternalFrame jfr,jfr1,jfr2,jfr3,jfr4,jfr5,jfr6,jfr7,jfr8;    //这是那9个内部窗体变量
	JTextField txt1,txt2,txt3;//这个是在添加路线里面的3个文本框
	JButton jbn;         // 这个是在添加路线里面的确定按钮
	JTextField txta1,txta2;//  这个是在删除路线里面的2个文本框
	JButton jbn1;         // 这个是在删除路线里面的确定按钮
	JTextField txtb0,txtb1,txtb2,txtb3;//这个是在修改路线里面的4个文本框
	JButton jbn2;         // 这个是在修改路线里面的确定按钮
	
	JTextField txt11,txt12,txt13,txt14,txt15;//这个是在添加汽车里面的5个文本框
	JButton jbna;         // 这个是在添加汽车里面的确定按钮
	JTextField txta11,txta12;//这个是在删除汽车里面的2个文本框
	JButton jbna1;         // 这个是在添加汽车里面的确定按钮
	JTextField txtb10,txtb11,txtb12,txtb13,txtb14,txtb15;//这个是在修改汽车里面的5个文本框
	JButton jbna2;         // 这个是在修改汽车里面的确定按钮
	
	JTextField txt21,txt22,txt23;//这个是在添加汽车里面的3个文本框
	JButton jbnb;         // 这个是在添加汽车里面的确定按钮
	JTextField txta21,txta22;//这个是在删除汽车里面的2个文本框
	JButton jbnb1;         // 这个是在添加汽车里面的确定按钮
	JTextField txtb21,txtb22,txtb23,txtb20;//这个是在修改汽车里面的2个文本框
	JButton jbnb2;         // 这个是在修改汽车里面的确定按钮
	
	
	管理员操作界面()
	{
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
		p=new Panel();
		p1=new Panel();
	    p1.setBounds(0, 0, a, b);
	    p1.setLayout(null);         //必须设定面板容器内部的界面布局为空才可以自己定义那一个控件的位置和大小
		p2=new Panel();
		p2.setBounds(0,0, a, b);
		 p2.setLayout(null);
		p3=new Panel();
		p3.setBounds(0, 0, a, b);
		 p3.setLayout(null);
		btn1=new JButton("添加");
		btn1.setBounds(a/7, b-100, 100, 30);
		btn2=new JButton("删除");
		btn2.setBounds(a/2-50, b-100, 100, 30);
		btn3=new JButton("修改");
		btn3.setBounds(a-150, b-100, 100, 30);
		btn4=new JButton("添加");
		btn4.setBounds(a/7, b-100, 100, 30);
		btn5=new JButton("删除");
		btn5.setBounds(a/2-50, b-100, 100, 30);
		btn6=new JButton("修改");
		btn6.setBounds(a-150, b-100, 100, 30);
		btn7=new JButton("添加");
		btn7.setBounds(a/7, b-100, 100, 30);
		btn8=new JButton("删除");
		btn8.setBounds(a/2-50, b-100, 100, 30);
		btn9=new JButton("修改");
		btn9.setBounds(a-150, b-100, 100, 30);
		jtb.addTab("路线目录", p1);
		jtb.addTab("汽车目录", p2);
		jtb.addTab("订票情况", p3);
	    this.getContentPane().add(jtb);
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		p2.add(btn6);
		p3.add(btn7);
		p3.add(btn8);
		p3.add(btn9);
		validate();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)  //按钮的回调函数
	{
		if(e.getSource()==btn1)     //添加线路
		{
		  if(!bb1)
			{
			  bb1=true;
			  if(bb2)
			  {
				  
			  jfr1.dispose();
			  }
			  if(bb3)
			  {
			  jfr2.dispose();
			  }
			  bb2=false;
			  bb3=false;
			  
			  
			//JOptionPane.showMessageDialog(null,"添加线路的窗口出现了！");
			 jfr=new JInternalFrame("添加线路",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr.setSize(800, 600);
			jfr.setVisible(true);
			jfr.setLayout(null);
			jfr.setBounds(50, 50, 800, 500);
			jfr.add(pp);
			p1.add(jfr);
			JLabel jlb=new JLabel("请输入起点（默认为本车站：贵阳）:");
			jlb.setBounds(50, 10, 250, 30);
			 txt1=new JTextField(20);
			txt1.setBounds(50, 50, 200, 30);
			pp.add(txt1);
			pp.add(jlb);
			JLabel jlb1=new JLabel("请输入终点（地名）:");
			jlb1.setBounds(50, 80, 200, 30);
			 txt2=new JTextField(20);
			txt2.setBounds(50, 120, 200, 30);
			pp.add(txt2);
			pp.add(jlb1);
			JLabel jlb3=new JLabel("请输入耗时（如1个半小时输入1.5）:");
			jlb3.setBounds(50, 160, 250, 30);
			 txt3=new JTextField(20);
			txt3.setBounds(50, 200, 200, 30);
			pp.add(txt3);
			pp.add(jlb3);
			jbn=new JButton("确定添加");
			jbn.setBounds(270, 30, 100, 30);
			pp.add(jbn);
			jbn.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr.validate();
			
			}
		  
		  else
		  {
			  
			  jfr.dispose();
			  bb1=false;
			  
			  
		  }
		  
		  
		  
		  
			
		}
		if(e.getSource()==btn2)      //删除线路
		{
			if(!bb2)
			{
				  if(bb1)
				  {
					  
				  jfr.dispose();
				  }
				  if(bb3)
				  {
				  jfr2.dispose();
				  }
			  bb1=false;
			  bb2=true;
			  bb3=false;
			//JOptionPane.showMessageDialog(null,"删除线路的窗口出现了！");
			 jfr1=new JInternalFrame("删除线路",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr1.setSize(800, 600);
			jfr1.setVisible(true);
			jfr1.setLayout(null);
			jfr1.setBounds(50, 50, 800, 500);
			jfr1.add(pp);
			p1.add(jfr1);
			JLabel jlb=new JLabel("请输入起点（默认为本车站：贵阳）:");
			jlb.setBounds(50, 10, 250, 30);
			 txta1=new JTextField(20);
			txta1.setBounds(50, 50, 200, 30);
			pp.add(txta1);
			pp.add(jlb);
			//JOptionPane.showMessageDialog(null,"执行到这里了1！");
			JLabel jlb1=new JLabel("请输入终点（地名）:");
			jlb1.setBounds(50, 80, 200, 30);
			pp.add(jlb1);
			 txta2=new JTextField(20);
			txta2.setBounds(50, 120, 200, 30);
			pp.add(txta2);
			//pp.add(jlb1);
			//JOptionPane.showMessageDialog(null,"执行到这里了2！");
			jbn1=new JButton("确定删除");
			jbn1.setBounds(270, 30, 100, 30);
			pp.add(jbn1);
			jbn1.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr1.validate();
			}
		  else
		  {
			  jfr1.dispose();
			  bb2=false;
		  }
			
		}
		if(e.getSource()==btn3)        //修改线路
		{
			if(!bb3)
			{
				  if(bb1)
				  {jfr.dispose();}
				  if(bb2)
				  {jfr1.dispose();}
			  bb1=false;bb2=false;bb3=true;
			//JOptionPane.showMessageDialog(null,"修改线路的窗口出现了！");
			 jfr2=new JInternalFrame("修改线路",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr2.setSize(800, 600);
			jfr2.setVisible(true);
			jfr2.setLayout(null);
			jfr2.setBounds(50, 50, 800, 500);
			jfr2.add(pp);
			p1.add(jfr2);
			
			JTextArea tx1=new JTextArea(7,20);
			tx1.setBounds(5, 5, 380, 100);
			pp.add(tx1);
			JLabel jlb=new JLabel("起点:");
			jlb.setBounds(5, 145, 100, 30);
			 txtb1=new JTextField(20);
			txtb1.setBounds(115, 145, 100, 30);
			pp.add(txtb1);
			pp.add(jlb);
			//JOptionPane.showMessageDialog(null,"执行到这里了1！");
			JLabel jlb1=new JLabel("终点:");
			jlb1.setBounds(5, 180, 100, 30);
			pp.add(jlb1);
			 txtb2=new JTextField(20);
			txtb2.setBounds(115, 180, 100, 30);
			pp.add(txtb2);
			JLabel jlb3=new JLabel("请输入耗时（如1个半小时输入1.5）:");
			jlb3.setBounds(5, 220, 100, 30);
			 txtb3=new JTextField(20);
			txtb3.setBounds(115, 220, 100, 30);
			pp.add(txtb3);
			pp.add(jlb3);
			
			//pp.add(jlb1);
			//JOptionPane.showMessageDialog(null,"执行到这里了2！");
			jbn2=new JButton("确定修改");
			jbn2.setBounds(220, 220, 100, 30);
			pp.add(jbn2);
			jbn2.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr2.validate();
			
			//下面开始进行数据库的访问了
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
				String str3="select * from 路线表";
				//PreparedStatement ps=con.prepareStatement(str3);
				ResultSet rs=s.executeQuery(str3);
				while(rs.next())
				{
					String ss1=rs.getString("路线编号").trim()+rs.getString("起点").trim()+rs.getString("终点").trim()+rs.getString("耗时").trim();
					//JOptionPane.showMessageDialog(null,"存在这个用户！用户名："+ss1+str);
					tx1.append(ss1+"\n");
					
					
				}
				
			   
			
			
			JLabel jlb0=new JLabel("请输入要修改的路线号:");
			jlb0.setBounds(5, 105, 150, 30);
			pp.add(jlb0);
			txtb0=new JTextField(20);
			txtb0.setBounds(160, 105, 30, 30);
			pp.add(txtb0);
			bn=false;
			
			
			
			    s.close();
			    con.close();      //关闭与数据库相关的连接
			 }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
		    }
			}
		  
		  else
		  {
			  jfr2.dispose();
			  bb3=false;
		  }
		}
		
		if(e.getSource()==btn4)     //添加班次
		{
			if(!bb4)
			{
			  bb4=true;
			  if(bb5)
			  {
				  
			  jfr4.dispose();
			  }
			  if(bb6)
			  {
			  jfr5.dispose();
			  }
			  bb5=false;
			  bb6=false;
			//JOptionPane.showMessageDialog(null,"添加汽车表的窗口出现了！");
			 jfr3=new JInternalFrame("添加汽车",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr3.setSize(800, 600);
			jfr3.setVisible(true);
			jfr3.setLayout(null);
			jfr3.setBounds(50, 50, 800, 500);
			jfr3.add(pp);
			p2.add(jfr3);
			JLabel jlb=new JLabel("请输入路线编号（参考路线表）:");
			jlb.setBounds(50, 10, 250, 30);
			 txt11=new JTextField(20);
			txt11.setBounds(50, 50, 200, 30);
			pp.add(txt11);
			pp.add(jlb);
			JLabel jlb1=new JLabel("请输入发车时间（7点半输入7.5:）:");
			jlb1.setBounds(50, 80, 200, 30);
			 txt12=new JTextField(20);
			txt12.setBounds(50, 120, 200, 30);
			pp.add(txt12);
			pp.add(jlb1);
			JLabel jlb3=new JLabel("请输入汽车的最大载客量:");
			jlb3.setBounds(50, 160, 250, 30);
			 txt13=new JTextField(20);
			txt13.setBounds(50, 200, 200, 30);
			pp.add(txt13);
			pp.add(jlb3);
			JLabel jlb4=new JLabel("请输入汽车的当前载客量:");
			jlb4.setBounds(50, 240, 250, 30);
			 txt14=new JTextField(20);
			txt14.setBounds(50, 280, 200, 30);
			pp.add(txt14);
			pp.add(jlb4);
			JLabel jlb5=new JLabel("请输入汽车的票价:");
			jlb5.setBounds(50, 320, 250, 30);
			 txt15=new JTextField(20);
			txt15.setBounds(50, 360, 200, 30);
			pp.add(txt15);
			pp.add(jlb5);
			
			
			
			jbna=new JButton("确定添加");
			jbna.setBounds(400, 100, 100, 30);
			pp.add(jbna);
			jbna.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr3.validate();
			}
		  else
		  {
			  jfr3.dispose();
			  bb4=false;
		  }
		  
		}
		if(e.getSource()==btn5)      //删除班次
		{
			if(!bb5)
			{
				  if(bb4)
				  {
					  
				  jfr3.dispose();
				  }
				  if(bb6)
				  {
				  jfr5.dispose();
				  }
			  bb4=false;
			  bb5=true;
			  bb6=false;
			//JOptionPane.showMessageDialog(null,"删除汽车表的窗口出现了！");
			 jfr4=new JInternalFrame("删除汽车表",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr4.setSize(800, 600);
			jfr4.setVisible(true);
			jfr4.setLayout(null);
			jfr4.setBounds(50, 50, 800, 500);
			jfr4.add(pp);
			p2.add(jfr4);
			JLabel jlb=new JLabel("请输入汽车编号:");
			jlb.setBounds(50, 10, 250, 30);
			 txta11=new JTextField(20);
			txta11.setBounds(50, 50, 200, 30);
			pp.add(txta11);
			pp.add(jlb);
			jbna1=new JButton("确定删除");
			jbna1.setBounds(100, 100, 100, 30);
			pp.add(jbna1);
			jbna1.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr4.validate();
			}
		  else
		  {
			  jfr4.dispose();
			  bb5=false;
		  }
			
		}
		if(e.getSource()==btn6)        //修改汽车表
		{
			if(!bb6)
			{
				  if(bb4)
				  {jfr3.dispose();}
				  if(bb5)
				  {jfr4.dispose();}
			  bb4=false;bb5=false;bb6=true;
			//JOptionPane.showMessageDialog(null,"修改汽车表的窗口出现了！");
			 jfr5=new JInternalFrame("修改汽车表",true,true,true,true);
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr5.setSize(800, 600);
			jfr5.setVisible(true);
			jfr5.setLayout(null);
			jfr5.setBounds(50, 50, 800, 500);
			jfr5.add(pp);
			p2.add(jfr5);
			
			JTextArea tx1=new JTextArea(7,20);
			tx1.setBounds(5, 5, 500, 100);
			pp.add(tx1);
			JLabel jlb=new JLabel("路线编号:");
			jlb.setBounds(5, 145, 100, 30);
			 txtb11=new JTextField(20);
			txtb11.setBounds(115, 145, 100, 30);
			pp.add(txtb11);
			pp.add(jlb);
			JLabel jlb1=new JLabel("发车时间:");
			jlb1.setBounds(5, 180, 100, 30);
			pp.add(jlb1);
			 txtb12=new JTextField(20);
			txtb12.setBounds(115, 180, 100, 30);
			pp.add(txtb12);
			JLabel jlb3=new JLabel("最大载人量:");
			jlb3.setBounds(5, 220, 100, 30);
			 txtb13=new JTextField(20);
			txtb13.setBounds(115, 220, 100, 30);
			pp.add(txtb13);
			pp.add(jlb3);
			
			JLabel jlb4=new JLabel("当前载人量:");
			jlb4.setBounds(5, 260, 100, 30);
			 txtb14=new JTextField(20);
			txtb14.setBounds(115, 260, 100, 30);
			pp.add(txtb14);
			pp.add(jlb4);
			JLabel jlb5=new JLabel("价格:");
			jlb5.setBounds(5, 300, 100, 30);
			 txtb15=new JTextField(20);
			txtb15.setBounds(115, 300, 100, 30);
			pp.add(txtb15);
			pp.add(jlb5);
			
			//pp.add(jlb1);
			//JOptionPane.showMessageDialog(null,"执行到这里了2！");
			jbna2=new JButton("确定修改");
			jbna2.setBounds(220, 220, 100, 30);
			pp.add(jbna2);
			jbna2.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr5.validate();
			
			//下面开始进行数据库的访问了
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
				String str3="select * from 汽车表";
				//PreparedStatement ps=con.prepareStatement(str3);
				ResultSet rs=s.executeQuery(str3);
				String ss0="汽车编号     "+"路线编号     "+"发车时间     "+"最大容量     "+"剩余容量     "+"价格";
				tx1.append(ss0+"\n");
				while(rs.next())
				{
					String ss1=rs.getString("汽车编号").trim()+"     "+rs.getString("路线编号").trim()+"     "+rs.getString("发车时间").trim()+"     "+rs.getString("最大容量").trim()+"     "+rs.getString("剩余容量").trim()+"     "+rs.getString("价格").trim();
					//JOptionPane.showMessageDialog(null,"存在这个用户！用户名："+ss1+str);
					tx1.append(ss1+"\n");
				}
			JLabel jlb0=new JLabel("请输入要修改的汽车编号:");
			jlb0.setBounds(5, 105, 150, 30);
			pp.add(jlb0);
			txtb10=new JTextField(20);
			txtb10.setBounds(160, 105, 30, 30);
			pp.add(txtb10);
			bn1=false;
			    s.close();
			    con.close();      //关闭与数据库相关的连接
			 }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
		    }
			}
		  
		  else
		  {
			  jfr5.dispose();
			  bb6=false;
		  }
		}
		
		if(e.getSource()==btn7)     //添加订票
		{
			if(!bb7)
			{
			  bb7=true;
			  if(bb8)
			  {
				  
			  jfr7.dispose();
			  }
			  if(bb9)
			  {
			  jfr8.dispose();
			  }
			  bb8=false;
			  bb9=false;
			//JOptionPane.showMessageDialog(null,"添加订票信息的窗口出现了！");
			 jfr6=new JInternalFrame("添加线路",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr6.setSize(800, 600);
			jfr6.setVisible(true);
			jfr6.setLayout(null);
			jfr6.setBounds(50, 50, 800, 500);
			jfr6.add(pp);
			p3.add(jfr6);
			JLabel jlb=new JLabel("请输入汽车编号（参考汽车表）:");
			jlb.setBounds(50, 10, 250, 30);
			 txt21=new JTextField(20);
			txt21.setBounds(50, 50, 200, 30);
			pp.add(txt21);
			pp.add(jlb);
			JLabel jlb1=new JLabel("请输入用户名:");
			jlb1.setBounds(50, 80, 200, 30);
			 txt22=new JTextField(20);
			txt22.setBounds(50, 120, 200, 30);
			pp.add(txt22);
			pp.add(jlb1);
			JLabel jlb3=new JLabel("请输入是否退票（是或否）:");
			jlb3.setBounds(50, 160, 250, 30);
			 txt23=new JTextField(20);
			txt23.setBounds(50, 200, 200, 30);
			pp.add(txt23);
			pp.add(jlb3);
			jbnb=new JButton("确定添加");
			jbnb.setBounds(270, 30, 100, 30);
			pp.add(jbnb);
			jbnb.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr6.validate();
			
			}
		  
		  else
		  {
			  
			  jfr.dispose();
			  bb1=false;
			  
			  
		  }
		  
			
			
			
		}
		if(e.getSource()==btn8)      //删除订票
		{
			if(!bb8)
			{
				  if(bb7)
				  {
					  
				  jfr6.dispose();
				  }
				  if(bb9)
				  {
				  jfr8.dispose();
				  }
			  bb7=false;
			  bb8=true;
			  bb9=false;
			//JOptionPane.showMessageDialog(null,"删除订票的窗口出现了！");
			 jfr7=new JInternalFrame("删除订票",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr7.setSize(800, 600);
			jfr7.setVisible(true);
			jfr7.setLayout(null);
			jfr7.setBounds(50, 50, 800, 500);
			jfr7.add(pp);
			p3.add(jfr7);
			JLabel jlb=new JLabel("请输入订单号:");
			jlb.setBounds(50, 10, 250, 30);
			 txta21=new JTextField(20);
			txta21.setBounds(50, 50, 200, 30);
			pp.add(txta21);
			pp.add(jlb);
			jbnb1=new JButton("确定删除");
			jbnb1.setBounds(270, 30, 100, 30);
			pp.add(jbnb1);
			jbnb1.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr7.validate();
			}
		  else
		  {
			  jfr7.dispose();
			  bb8=false;
		  }
			
			
		}
		if(e.getSource()==btn9)        //修改容量
		{
			if(!bb9)
			{
				  if(bb7)
				  {jfr6.dispose();}
				  if(bb8)
				  {jfr7.dispose();}
			  bb7=false;bb8=false;bb9=true;
			//JOptionPane.showMessageDialog(null,"修改线路的窗口出现了！");
			 jfr8=new JInternalFrame("修改线路",true,true,true,true);
			//JFrame jfr=new JFrame("添加线路");
			JPanel pp=new JPanel();
			pp.setBounds(0, 0, 800, 600);
			pp.setLayout(null);
			jfr8.setSize(800, 600);
			jfr8.setVisible(true);
			jfr8.setLayout(null);
			jfr8.setBounds(50, 50, 800, 500);
			jfr8.add(pp);
			p3.add(jfr8);
			JTextArea tx1=new JTextArea(7,20);
			tx1.setBounds(5, 5, 600, 100);
			pp.add(tx1);
			JLabel jlb0=new JLabel("请输入要修改的订单号:");
			jlb0.setBounds(5, 105, 150, 30);
			pp.add(jlb0);
			txtb20=new JTextField(20);
			txtb20.setBounds(160, 105, 30, 30);
			pp.add(txtb20);
			JLabel jlb=new JLabel("汽车编号:");
			jlb.setBounds(5, 145, 100, 30);
			 txtb21=new JTextField(20);
			txtb21.setBounds(115, 145, 100, 30);
			pp.add(txtb21);
			pp.add(jlb);
			//JOptionPane.showMessageDialog(null,"执行到这里了1！");
			JLabel jlb1=new JLabel("用户名:");
			jlb1.setBounds(5, 180, 100, 30);
			pp.add(jlb1);
			 txtb22=new JTextField(20);
			txtb22.setBounds(115, 180, 100, 30);
			pp.add(txtb22);
			JLabel jlb3=new JLabel("是否退票:");
			jlb3.setBounds(5, 220, 100, 30);
			 txtb23=new JTextField(20);
			txtb23.setBounds(115, 220, 100, 30);
			pp.add(txtb23);
			pp.add(jlb3);
			
			
			jbnb2=new JButton("确定修改");
			jbnb2.setBounds(220, 220, 100, 30);
			pp.add(jbnb2);
			jbnb2.addActionListener(this);
			//jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jfr8.validate();
			
			//下面开始进行数据库的访问了
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
				String str3="select * from 订票表";
				//PreparedStatement ps=con.prepareStatement(str3);
				ResultSet rs=s.executeQuery(str3);
				String ss0="订单号     "+"汽车编号     "+"用户名     "+"是否退票";
				tx1.append(ss0+"\n");
				while(rs.next())
				{
					String ss1=rs.getString("订单号").trim()+"     "+rs.getString("汽车编号").trim()+"     "+rs.getString("用户名").trim()+"     "+rs.getString("是否退票").trim();
					tx1.append(ss1+"\n");
				}
			
			bn2=false;
			    s.close();
			    con.close();      //关闭与数据库相关的连接
			 }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
		    }
			}
		  
		  else
		  {
			  jfr8.dispose();
			  bb9=false;
		  }
		}
		if(e.getSource()==jbn)        //确认添加线路
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy=txt1.getText().trim();
				String yy1=txt2.getText().trim();
				String sdd="select * from 路线表";
				ResultSet rs=s.executeQuery(sdd);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				int ad=0;
				boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				while(rs.next())
				{
					ad=Integer.parseInt(rs.getString("路线编号"));
					if(yy.equals(rs.getString("起点")))
					{
						if(yy1.equals(rs.getString("终点")))
						{
							bh1=true;
						}
					}
				}
				ad++;      //将当前的最大编号加1
				if(!bh1)
				{
				//JOptionPane.showMessageDialog(null,"现在这个表中的元素个数为："+ad);
				String st1="'"+String.valueOf(ad)+"'";
				String st2="'"+txt1.getText().trim()+"'";
				String st3="'"+txt2.getText().trim()+"'";
				String st4="'"+txt3.getText().trim()+"'";
				//float aas=Float.valueOf(txt3.getText()).floatValue();
				//JOptionPane.showMessageDialog(null,"马上开始写入数据库："+st1);
				//String stt="insert into 用户表(用户名,密码) values("+strr+","+str1r+")";
				String stt="insert into 路线表(路线编号,起点,终点,耗时) values("+st1+","+st2+","+st3+
						","+st4+
						")";
				//PreparedStatement ps=con.prepareStatement(str3);
				s.executeUpdate(stt);
				//boolean b1=false;       //用来判断是否用户名和密码都正确
				//JOptionPane.showMessageDialog(null,"添加成功！");
				//JOptionPane.showMessageDialog(null,"用户名："+str);
				
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				 }
				    else
				    {
					  JOptionPane.showMessageDialog(null,"你输入的路线已经存在，请重新输入！");
					  txt1.setText(null);
					  txt2.setText(null);
					  txt3.setText(null);
				    }
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    
			    
			    }
				
			
			
			
		}
		if(e.getSource()==jbn1)        //确认删除线路
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy=txta1.getText().trim();
				String yy1=txta2.getText().trim();
				String sdd="select * from 路线表";
				ResultSet rs=s.executeQuery(sdd);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				String ad = null;                 //用来存放路线号
				boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				while(rs.next())
				{
					//ad++;
					if(yy.equals(rs.getString("起点").trim()))
					{
					//	JOptionPane.showMessageDialog(null,"dangqian"+rs.getString("起点").trim());

						if(yy1.equals(rs.getString("终点").trim()))
						{
						//	JOptionPane.showMessageDialog(null,"dangqian"+rs.getString("终点").trim());

							ad=rs.getString("路线编号").trim();
							bh1=true;
						}
					}
				}
				
				if(bh1)
				{
				//JOptionPane.showMessageDialog(null,"马上开始删除数据库：");
				String stt="delete from 路线表 where 路线编号="+ad;
				s.executeUpdate(stt);
				JOptionPane.showMessageDialog(null,"删除成功！");
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				    txta1.setText(null);
					  txta2.setText(null);
				 }
				    else
				    {
				    	 s.close();
						 con.close();      //关闭与数据库相关的连接
					  JOptionPane.showMessageDialog(null,"你输入的路线不存在，请重新输入！");
					  txta1.setText(null);
					  txta2.setText(null);
				    }
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    
			    
			    }
				
			
			
			
			
		}
		if(e.getSource()==jbn2 )        //确认修改线路
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
				String yy0=txtb0.getText().trim();
				String yy=txtb1.getText().trim();
				String yy1=txtb2.getText().trim();
				String yy2=txtb3.getText().trim();
			
				JOptionPane.showMessageDialog(null,"成功读取数据库：");
				//String ad = null;                 //用来存放路线号
				boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				boolean bh2=false;      //用来验证输入的路线号是否正确为true，
				try
				{
					//int az=Integer.parseInt(txtb0.getText());
					String az=txtb0.getText();
					String str0="select * from 路线表 where 路线编号="+az;
							s.executeQuery(str0);
							JOptionPane.showMessageDialog(null,"连接成功555");
							//bh2=true;
							bh2=true;
					
				}catch(Exception e3){
					
					JOptionPane.showMessageDialog(null,"线路编号输入错误，请重试：");
					//bh2=true;
				}
				
				if(bh2)
				{
					String sdd="select * from 路线表";
					ResultSet rs=s.executeQuery(sdd);
				while(rs.next())
				{
					//ad++;
					//JOptionPane.showMessageDialog(null,"喀什比较起点"+rs.getString("起点").trim());
					if(yy.equals(rs.getString("起点").trim()))
					{
						//JOptionPane.showMessageDialog(null,"dangqian"+rs.getString("起点").trim());

						if(yy1.equals(rs.getString("终点").trim()))
						{
							//JOptionPane.showMessageDialog(null,"dangqian"+rs.getString("终点").trim());

							//ad=rs.getString("路线编号").trim();
							bh1=true;
						}
					}
				}
				
				if(!bh1)
				{
				//JOptionPane.showMessageDialog(null,"马上开始修改数据库：");
				String  ayy="'"+yy+"'";
				String  ayy1="'"+yy1+"'";
				String  ayy2="'"+yy2+"'";
				String  ayy0="'"+yy0+"'";
				
				
				String stt="UPDATE 路线表 SET 起点="+ayy+",终点="+ayy1+",耗时="+ayy2+" where 路线编号="+ayy0;
				s.executeUpdate(stt);
				JOptionPane.showMessageDialog(null,"修改成功！");
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				 }
				    else
				    {
				    	  s.close();
						    con.close();      //关闭与数据库相关的连接
					  JOptionPane.showMessageDialog(null,"你输入的起点终点已存在，请重新输入！");
					  txtb1.setText(null);
					  txtb2.setText(null);
				    }
				}
				else
				{
					 s.close();
					    con.close();      //关闭与数据库相关的连接
					JOptionPane.showMessageDialog(null,"你输入的路线不存在，请重新输入！");
					txtb0.setText(null);
					txtb1.setText(null);
					  txtb2.setText(null);
				}
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    }
		}
		
		if(e.getSource()==jbna)          //汽车表的添加
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy1=txt11.getText().trim();
				String yy2=txt12.getText().trim();
				String yy3=txt13.getText().trim();
				String yy4=txt14.getText().trim();
				String yy5=txt15.getText().trim();
				int aq1=Integer.parseInt(yy1);
				int aq3=Integer.parseInt(yy3);
				int aq4=Integer.parseInt(yy4);
				int aq5=Integer.parseInt(yy5);
				String aq2="'"+yy2+"'";
				String sdd="select * from 路线表";
				ResultSet rs=s.executeQuery(sdd);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				int ad=0;
				boolean bh1=false;      //用来验证输入的路线号在数据库中是否已经存在，false表示不存在
				while(rs.next())
				{
					//ad++;
					if(yy1.equals(rs.getString("路线编号").trim()))
					{
					//	JOptionPane.showMessageDialog(null,"dangqian"+rs.getString("起点").trim());
							bh1=true;
					}
				}
				String sdd1="select * from 汽车表";
				ResultSet rs1=s.executeQuery(sdd1);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				while(rs1.next())
				{
					    ad=Integer.parseInt(rs1.getString("汽车编号").trim());
					//	JOptionPane.showMessageDialog(null,"dangqian"+rs.getString("起点").trim());
				}
				
				
				if(bh1)
				{
				ad++;      //将当前的最大编号加1
				//JOptionPane.showMessageDialog(null,"现在这个表中的元素个数为："+(ad-1));
				//float aas=Float.valueOf(txt3.getText()).floatValue();
				//JOptionPane.showMessageDialog(null,"马上开始写入数据库：");
				String aq0="'"+String.valueOf(ad)+"'";
				String stt="insert into 汽车表 values("+aq0+","+aq1+","+aq2+","+aq3+
						","+aq4+","+aq5+
						")";
				//PreparedStatement ps=con.prepareStatement(str3);
				s.executeUpdate(stt);
				//boolean b1=false;       //用来判断是否用户名和密码都正确
				JOptionPane.showMessageDialog(null,"添加成功！");
				//JOptionPane.showMessageDialog(null,"用户名："+str);
				
				    s.close();
				    con.close();      //关闭与数据库相关的连接
					  txt11.setText(null);
					  txt12.setText(null);
					  txt13.setText(null);
					  txt14.setText(null);
					  txt15.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"你输入的路线编号不存在，请重试！");
					  s.close();
					    con.close();      //关闭与数据库相关的连接
						  txt11.setText(null);
						  txt12.setText(null);
						  txt13.setText(null);
						  txt14.setText(null);
						  txt15.setText(null);
				}
				
				
				
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    
			    
			    }
			
		}
		if(e.getSource()==jbna1)         //汽车表的删除
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy=txta11.getText().trim();
				String sdd="select * from 汽车表";
				ResultSet rs=s.executeQuery(sdd);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				while(rs.next())
				{
					if(yy.equals(rs.getString("汽车编号").trim()))
					{
					//	JOptionPane.showMessageDialog(null,"汽车编号："+rs.getString("汽车编号").trim());
							bh1=true;
						
					}
				}
				
				if(bh1)
				{
					String yy1="'"+yy+"'";
				//JOptionPane.showMessageDialog(null,"马上开始删除数据库：");
				String stt="delete from 汽车表 where 汽车编号="+yy1;
				s.executeUpdate(stt);
				JOptionPane.showMessageDialog(null,"删除成功！");
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				    txta11.setText(null);
					 
				 }
				    else
				    {
				    	 s.close();
						 con.close();      //关闭与数据库相关的连接
					  JOptionPane.showMessageDialog(null,"你输入的汽车编号不存在，请重新输入！");
					  txta11.setText(null);
					  
				    }
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    
			    
			    }
			
			
		}
		if(e.getSource()==jbna2)         //汽车表的修改
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy0=txtb10.getText().trim();
				String yy1=txtb11.getText().trim();
				String yy2=txtb12.getText().trim();
				String yy3=txtb13.getText().trim();
				String yy4=txtb14.getText().trim();
				String yy5=txtb15.getText().trim();
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				//String ad = null;                 //用来存放路线号
				boolean bh2=false;      //用来验证输入的汽车编号是否正确为true，
				try
				{
					//int az=Integer.parseInt(txtb0.getText());
					String az=txtb10.getText().trim();
					String str0="select * from 汽车表 where 汽车编号="+az;
							s.executeQuery(str0);
					//		JOptionPane.showMessageDialog(null,"连接成功555");
							//bh2=true;
							bh2=true;
					
				}catch(Exception e3){
					
					JOptionPane.showMessageDialog(null,"汽车编号不存在，请重试：");
					//bh2=true;
				}
				
				
				
				if(bh2)
				{
				//JOptionPane.showMessageDialog(null,"马上开始修改数据库：");
				String  ayy2="'"+yy2+"'";
				String  ayy0="'"+yy0+"'";
				int ayy1=Integer.parseInt(yy1);
				int ayy3=Integer.parseInt(yy3);
				int ayy4=Integer.parseInt(yy4);
				int ayy5=Integer.parseInt(yy5);
				
				String stt="UPDATE 汽车表 SET 路线编号="+ayy1+",发车时间="+ayy2+",最大容量="+ayy3+",剩余容量="+ayy4+",价格="+ayy5+" where 汽车编号="+ayy0;
				s.executeUpdate(stt);
				JOptionPane.showMessageDialog(null,"修改成功！");
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				      txtb10.setText(null);
					  txtb11.setText(null);
					  txtb12.setText(null);
					  txtb13.setText(null);
					  txtb14.setText(null);
					  txtb15.setText(null);
				 }
				    else
				    {
				    	  s.close();
						    con.close();      //关闭与数据库相关的连接
					  JOptionPane.showMessageDialog(null,"你输入的汽车编号不存在，请重新输入！");
					  txtb10.setText(null);
					  txtb11.setText(null);
					  txtb12.setText(null);
					  txtb13.setText(null);
					  txtb14.setText(null);
					  txtb15.setText(null);
				    
				     }
			   }
			     
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    }
			
		}
		
		if(e.getSource()==jbnb)          //订单表的添加
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String sdd="select * from 订票表";
				ResultSet rs=s.executeQuery(sdd);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				int ad=0;
				//boolean bh1=false;      //用来验证输入的起点和终点在数据库中是否已经存在，false表示不存在
				while(rs.next())
				{
					ad=Integer.parseInt(rs.getString("订单号"));
					
				}
				ad++;      //将当前的最大编号加1
				
				//JOptionPane.showMessageDialog(null,"现在这个表中的元素个数为："+ad);
				String st1="'"+String.valueOf(ad)+"'";
				String st2="'"+txt21.getText().trim()+"'";
				String st3="'"+txt22.getText().trim()+"'";
				String st4="'"+txt23.getText().trim()+"'";
				//float aas=Float.valueOf(txt3.getText()).floatValue();
				//JOptionPane.showMessageDialog(null,"马上开始写入数据库："+st1);
				//String stt="insert into 用户表(用户名,密码) values("+strr+","+str1r+")";
				String stt="insert into 订票表 values("+st1+","+st2+","+st3+
						","+st4+
						")";
				//PreparedStatement ps=con.prepareStatement(str3);
				s.executeUpdate(stt);
				//boolean b1=false;       //用来判断是否用户名和密码都正确
				JOptionPane.showMessageDialog(null,"添加成功！");
				//JOptionPane.showMessageDialog(null,"用户名："+str);
				    s.close();
				    con.close();      //关闭与数据库相关的连接
					  txt21.setText(null);
					  txt22.setText(null);
					  txt23.setText(null);
				    
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    
			    
			    }
				
			
		}
		if(e.getSource()==jbnb1)         //订单表的删除
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy=txta21.getText().trim();
				String sdd="select * from 订票表";
				ResultSet rs=s.executeQuery(sdd);
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				boolean bh1=false;      //用来验证输入的订单号在数据库中是否已经存在，false表示不存在
				while(rs.next())
				{
					if(yy.equals(rs.getString("订单号").trim()))
					{bh1=true;
					}
				}
				if(bh1)
				{
					String yy1="'"+yy+"'";
				//JOptionPane.showMessageDialog(null,"马上开始删除数据库：");
				String stt="delete from 订票表 where 订单号="+yy1;
				s.executeUpdate(stt);
				JOptionPane.showMessageDialog(null,"删除成功！");
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				    txta21.setText(null);
				 }
				    else
				    {
				    	 s.close();
						 con.close();      //关闭与数据库相关的连接
					  JOptionPane.showMessageDialog(null,"你输入的订单号不存在，请重新输入！");
					  txta21.setText(null);
				    }
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    }
			
			
		}
		if(e.getSource()==jbnb2)         //订单表的修改
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
				//JOptionPane.showMessageDialog(null,"连接成功：");
				Statement s=con.createStatement();
				String yy0=txtb20.getText().trim();
				String yy=txtb21.getText().trim();
				String yy1=txtb22.getText().trim();
				String yy2=txtb23.getText().trim();
			
				//JOptionPane.showMessageDialog(null,"成功读取数据库：");
				//String ad = null;                 //用来存放路线号
				boolean bh1=false;           //验证汽车编号是否存在存在为true
				boolean bh2=false;      //用来验证输入的订单号是否正确为true，
				try
				{
					//int az=Integer.parseInt(txtb0.getText());
					String az=txtb20.getText();
					String str0="select * from 订票表 where 订单号="+az;
							s.executeQuery(str0);
					//		JOptionPane.showMessageDialog(null,"连接成功555");
							//bh2=true;
							bh2=true;
					
				}catch(Exception e3){
					
					JOptionPane.showMessageDialog(null,"线路编号输入错误，请重试：");
					//bh2=true;
				}
				
				if(bh2)
				{
					String sdd="select * from 汽车表";
					ResultSet rs=s.executeQuery(sdd);
				while(rs.next())
				{
					if(yy.equals(rs.getString("汽车编号").trim()))
					{
						bh1=true;
					}
				}
				
				if(!bh1)
				{
				//JOptionPane.showMessageDialog(null,"马上开始修改数据库：");
				String  ayy="'"+yy+"'";
				String  ayy1="'"+yy1+"'";
				String  ayy2="'"+yy2+"'";
				String  ayy0="'"+yy0+"'";
				
				
				String stt="UPDATE 订票表 SET 汽车编号="+ayy+",用户名="+ayy1+",是否退票="+ayy2+" where 订单号="+ayy0;
				s.executeUpdate(stt);
				JOptionPane.showMessageDialog(null,"修改成功！");
				    s.close();
				    con.close();      //关闭与数据库相关的连接
				 }
				    else
				    {
				    	  s.close();
						    con.close();      //关闭与数据库相关的连接
					  JOptionPane.showMessageDialog(null,"你输入的汽车编号不存在，请重新输入！");
					  txtb21.setText(null);
					  txtb22.setText(null);
					  txtb23.setText(null);
					  txtb20.setText(null);
				    }
				}
				else
				{
					 s.close();
					    con.close();      //关闭与数据库相关的连接
					JOptionPane.showMessageDialog(null,"你订单号不存在，请重新输入！");
					 txtb21.setText(null);
					  txtb22.setText(null);
					  txtb23.setText(null);
					  txtb20.setText(null);
				}
			     }
			    catch(SQLException e2)
			    {
			    	JOptionPane.showMessageDialog(null,"访问数据库失败！");
			    }
			
			
		}
		
		
	}
		public static void main(String[] args)
		{
			
			new 管理员操作界面();
			 
			
		}
	
}
