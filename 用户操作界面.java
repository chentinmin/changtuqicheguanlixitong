package ��;��������ϵͳ;
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
public class �û��������� extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p1,p2,p3;
	JTabbedPane jtb;
	//��ѯ�ĸ��ֿؼ�
	JLabel jlb1,jlb2,jlb3;
	JTextField txt1,txt2,txt3;//���ǩ��Ӧ���ı���
	JButton jbn1,jbn2,jbn3;
	JTextArea tx1=new JTextArea(7,20);
	JScrollPane jsc1;
	//��Ʊ�õ��ĸ��ֿؼ�
	JLabel jlb11,jlb21,jlb31;
	JTextField txt11,txt21,txt31;//���ǩ��Ӧ���ı���
	JButton jbn11,jbn21,jbn31;
	JTextArea tx2=new JTextArea(7,20);
	JScrollPane jsc2;
	//��Ʊ�õ��ĸ��ֿؼ�
	JLabel jlb12,jlb22,jlb32;
	JTextField txt12,txt22,txt32;//���ǩ��Ӧ���ı���
	JButton jbn12,jbn22,jbn32;
	JTextArea tx3=new JTextArea(7,20);
	JScrollPane jsc3;
	Image img;
	String name;
	�û���������(String name1)
	{
		name=name1;
		setSize(960,720);
		int b=this.getSize().height;
		int a=this.getSize().width;
		setVisible(true);
		setTitle("��;��������ϵͳ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 int windowWidth = this.getWidth(); //��ô��ڿ�
		 int windowHeight = this.getHeight(); //��ô��ڸ�
		Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
		Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
		 int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
		this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
		setLayout(null);//new FlowLayout());
		jtb=new JTabbedPane();
		jtb.setBounds(0, 0, a, b);
		p1=new ImagePanel();
	    p1.setBounds(0, 0, a, b);
	    p1.setLayout(null);         //�����趨��������ڲ��Ľ��沼��Ϊ�ղſ����Լ�������һ���ؼ���λ�úʹ�С
		p2=new ImagePanel();
		p2.setBounds(0,0, a, b);
		p2.setLayout(null);
		p3=new ImagePanel();
		p3.setBounds(0, 0, a, b);
		p3.setLayout(null);
		jtb.addTab("��ѯ", p1);
		jtb.addTab("��Ʊ", p2);
		jtb.addTab("��Ʊ", p3);
	    this.getContentPane().add(jtb);
		��ѯ();
		��Ʊ();
		��Ʊ();
		validate();
		
	}
	public void actionPerformed(ActionEvent e)  //��ť�Ļص�����
	{
		if(e.getSource()==jbn1)
		{
			��ѯ1();
			
		}
		
		if(e.getSource()==jbn11)
		{
			
			��Ʊ1();
			//JOptionPane.showMessageDialog(null,"���ӳɹ���123");
		}
		
		if(e.getSource()==jbn21)
		{
			
			��Ʊ2();
			//JOptionPane.showMessageDialog(null,"���ӳɹ���123");
		}
		if(e.getSource()==jbn12)
		{
			
			��Ʊ2();
			//JOptionPane.showMessageDialog(null,"���ӳɹ���123");
		}
		
	}
	
	public void ��ѯ()
	{
		jlb1=new JLabel("��������㣺");
		jlb1.setBounds(100, 10, 200, 30);
		jlb2=new JLabel("�������յ㣺");
		jlb2.setBounds(100, 50, 200, 30);
		txt1=new JTextField(10);
		txt1.setBounds(220, 10, 200, 30);
		txt2=new JTextField(10);
		txt2.setBounds(220, 50, 200, 30);
		jbn1=new JButton("��ʼ��ѯ");
		jbn1.addActionListener(this);
		jbn1.setBounds(200, 100, 100, 40);
		p1.add(jlb1);
		p1.add(jlb2);
		p1.add(txt1);
		p1.add(txt2);
		p1.add(jbn1);
		//tx1.setBounds(10, 160, 500, 300);
		jsc1=new JScrollPane(tx1);          //�����������ı���
		jsc1.setBounds(10, 160, 500, 300);
		p1.add(jsc1);
	}
	
	public void ��ѯ1()
	{

		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=��;��������ϵͳ���ݿ�";
		
		try {
			Class.forName(JDriver);          //ע��
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			Connection con=DriverManager.getConnection(url,"admin","1");   //����
			JOptionPane.showMessageDialog(null,"���ӳɹ���");
			Statement s=con.createStatement();
			String yy1=txt1.getText().trim();
			String yy2=txt2.getText().trim();
			
			String aq1="'"+yy1+"'";
			String aq2="'"+yy2+"'";
			String asd=null;
		
		
			//JOptionPane.showMessageDialog(null,"���Ͽ�ʼ��ѯ���ݿ⣺");
			String sdd="select * from ·�߱�";
			ResultSet rs=s.executeQuery(sdd);
			
			boolean bh1=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs.next())
			{
				if(yy1.equals(rs.getString("���").trim()))
				{
					if(yy2.equals(rs.getString("�յ�").trim()))
					{
							bh1=true;
							asd=rs.getString("·�߱��").trim();
					}
				}
			}
			
			if(bh1)
			{
				String sdd1="select * from ������";
				ResultSet rs1=s.executeQuery(sdd1);
				//boolean bh2=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
				while(rs1.next())
				{
					//JOptionPane.showMessageDialog(null,"��ʼ����������"+asd+rs1.getString("·�߱��").trim().equals(asd)+rs1.getString("·�߱��").trim());
					if(rs1.getString("·�߱��").trim().equals(asd))
					{
						String haha="�������          "+"·�߱��          "+"����ʱ��          "+"�������          "+"ʣ������           "+"�۸�";
						tx1.append(haha+"\n");
						String haha1=rs1.getString("�������").trim()+"          "+rs1.getString("·�߱��").trim()+"          "
								+rs1.getString("����ʱ��").trim()+"          "+rs1.getString("�������").trim()+"          "+
								rs1.getString("ʣ������").trim()+"          "+rs1.getString("�۸�").trim();
						tx1.append(haha1);
						
						
						
					}
				}
				
				
			}
			
			
			JOptionPane.showMessageDialog(null,"��ӳɹ���");
			//JOptionPane.showMessageDialog(null,"�û�����"+str);
			
			    s.close();
			    con.close();      //�ر������ݿ���ص�����
				  txt1.setText(null);
				  txt2.setText(null);
				 
				
		
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"�������ݿ�ʧ�ܣ�");
		    
		    
		    }
		
	}
	
	
	 
	public void ��Ʊ()
	{
		jlb11=new JLabel("��������㣺");
		jlb11.setBounds(100, 10, 200, 30);
		jlb21=new JLabel("�������յ㣺");
		jlb21.setBounds(100, 50, 200, 30);
		txt11=new JTextField(10);
		txt11.setBounds(220, 10, 200, 30);
		txt21=new JTextField(10);
		txt21.setBounds(220, 50, 200, 30);
		jbn11=new JButton("��ʼ��ѯ");
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
		
		jlb31=new JLabel("������Ҫ�������������");
		jlb31.setBounds(600, 250, 200, 30);
		txt31=new JTextField(10);
		txt31.setBounds(600, 300, 200, 30);
		jbn21=new JButton("ȷ�Ϲ���");
		jbn21.setBounds(650, 350, 100, 50);
		jbn21.addActionListener(this);
		p2.add(jlb31);
		p2.add(txt31);
		p2.add(jbn21);
		
	}
	
	public void ��Ʊ1()
	{
		//JOptionPane.showMessageDialog(null,"���ӳɹ���123444");

		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=��;��������ϵͳ���ݿ�";
		
		try {
			Class.forName(JDriver);          //ע��
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			Connection con=DriverManager.getConnection(url,"admin","1");   //����
			//JOptionPane.showMessageDialog(null,"���ӳɹ���");
			Statement s=con.createStatement();
			String yy1=txt11.getText().trim();
			String yy2=txt21.getText().trim();
			
			String aq1="'"+yy1+"'";
			String aq2="'"+yy2+"'";
			String asd=null;
		
		
			//JOptionPane.showMessageDialog(null,"���Ͽ�ʼ��ѯ���ݿ⣺");
			String sdd="select * from ·�߱�";
			ResultSet rs=s.executeQuery(sdd);
			
			boolean bh1=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs.next())
			{
				if(yy1.equals(rs.getString("���").trim()))
				{
					if(yy2.equals(rs.getString("�յ�").trim()))
					{
							bh1=true;
							asd=rs.getString("·�߱��").trim();
					}
				}
			}
			
			if(bh1)
			{
				tx2.setText(null);
				String sdd1="select * from ������";
				ResultSet rs1=s.executeQuery(sdd1);
				//boolean bh2=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
				String haha="�������          "+"·�߱��          "+"����ʱ��          "+"�������          "+"ʣ������           "+"�۸�";
				tx2.append(haha+"\n");
				while(rs1.next())
				{
				//	JOptionPane.showMessageDialog(null,"��ʼ����������"+asd+rs1.getString("·�߱��").trim().equals(asd)+rs1.getString("·�߱��").trim());
					if(rs1.getString("·�߱��").trim().equals(asd))
					{
						String haha1=rs1.getString("�������").trim()+"          "+rs1.getString("·�߱��").trim()+"          "
								+rs1.getString("����ʱ��").trim()+"          "+rs1.getString("�������").trim()+"          "+
								rs1.getString("ʣ������").trim()+"          "+rs1.getString("�۸�").trim();
						tx2.append(haha1);
					}
				}
			}
			//JOptionPane.showMessageDialog(null,"��ӳɹ���");
			    s.close();
			    con.close();      //�ر������ݿ���ص�����
				  txt11.setText(null);
				  txt21.setText(null);
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"�������ݿ�ʧ�ܣ�");
		    }
	}
	
	public void ��Ʊ2()
	{
		int ll=0;
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=��;��������ϵͳ���ݿ�";
		
		try {
			Class.forName(JDriver);          //ע��
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		try {
			Connection con=DriverManager.getConnection(url,"admin","1");   //����
			//JOptionPane.showMessageDialog(null,"���ӳɹ���");
			Statement s=con.createStatement();
			 String aqq1=txt31.getText().trim();
			 String aqq2="'"+aqq1+"'";
			String sdd1="select * from ������ where �������="+aqq2;
			ResultSet rs0=s.executeQuery(sdd1);
			boolean bh0=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs0.next())//�鿴��ǰ�ж��ٸ��û���ʼֵΪ0
			{
				//JOptionPane.showMessageDialog(null,"�������");
				int qq1=rs0.getInt("ʣ������");
				if(qq1>0)
				{
					bh0=true;
					qq1--;
					ll=qq1;
				}
			}
			
			
			
			if(bh0)
			{
			//JOptionPane.showMessageDialog(null,"���Ͽ�ʼ��ѯ���ݿ⣺");
			String sdd="select * from ��Ʊ��";
			ResultSet rs=s.executeQuery(sdd);
			int aas=0;
			//boolean bh1=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs.next())//�鿴��ǰ�ж��ٸ��û���ʼֵΪ0
			{
				aas++;
			}
			aas++;
			String str1=String.valueOf(aas);
             String aq1=txt31.getText().trim();
			String str2="'"+aq1+"'";
			String str3="'"+name+"'";
			String str4="'"+"��"+"'";
			//JOptionPane.showMessageDialog(null,"��Ʊ�ɹ���1238");
			String stt="insert into ��Ʊ�� values("+str1+","+str2+","+str3+","+str4+")";
			s.executeUpdate(stt);
			JOptionPane.showMessageDialog(null,"��Ʊ�ɹ�!");
			//JOptionPane.showMessageDialog(null,"��ʼ�޸�������");
			String sc=String.valueOf(ll);
			String stt1="UPDATE ������ SET ʣ������="+sc+" where �������="+aqq2;
			s.executeUpdate(stt1);
			//JOptionPane.showMessageDialog(null,"�޸ĳɹ���4444");
			    s.close();
			    con.close();      //�ر������ݿ���ص�����
			    ��Ʊ1();
				 
			}
			
			
			else
			{
				JOptionPane.showMessageDialog(null,"�����������Ų����ڣ������ԣ�");
			    s.close();
			    con.close();      //�ر������ݿ���ص�����
				  txt11.setText(null);
				  txt21.setText(null);
			}
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,e2.toString());
		    }
	}

	public void ��Ʊ()
	{
		jsc3=new JScrollPane(tx3);
		jsc3.setBounds(10, 10, 500, 300);
		p3.add(jsc3);
		jlb12=new JLabel("������Ҫ��Ʊ������");
		jlb12.setBounds(10, 350, 200, 30);
		txt12=new JTextField(10);
		txt12.setBounds(10, 400, 200, 30);
		jbn12=new JButton("ȷ����Ʊ");
		jbn12.addActionListener(this);
		jbn12.setBounds(100, 450, 100, 50);
		p3.add(jlb12);
		p3.add(txt12);
		p3.add(jbn12);
		��Ʊ1();
	}
	public void ��Ʊ1()
	{
		tx3.setText(null);
		//JOptionPane.showMessageDialog(null,"���ӳɹ���123444");

		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=��;��������ϵͳ���ݿ�";
		
		try {
			Class.forName(JDriver);          //ע��
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			Connection con=DriverManager.getConnection(url,"admin","1");   //����
			//JOptionPane.showMessageDialog(null,"���ӳɹ���");
			Statement s=con.createStatement();
			String yy1=txt12.getText().trim();
			String aq1="'"+yy1+"'";
			String asd=null;
			String sss="'"+name+"'";
			//JOptionPane.showMessageDialog(null,"���Ͽ�ʼ��ѯ���ݿ⣺");
			String sdd="select * from ��Ʊ�� where �û���="+sss;
			ResultSet rs=s.executeQuery(sdd);
			String haha="������          "+"�������          "+"�û���          "+"�Ƿ���Ʊ";
			tx3.append(haha+"\n");
			boolean bh1=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs.next())
			{
				String aaa=rs.getString("������")+"          "+rs.getString("�������")+"          "+rs.getString("�û���")
						+"         "+rs.getString("�Ƿ���Ʊ");
				tx3.append(aaa);
				tx3.append("\n");
			}
			    s.close();
			    con.close();      //�ر������ݿ���ص�����
		     }
		    catch(SQLException e2)
		    {
		    	JOptionPane.showMessageDialog(null,"�������ݿ�ʧ�ܣ�");
		    }
	}
	
	
	public void ��Ʊ2()
	{
		String aqq2=null;
		//JOptionPane.showMessageDialog(null,"���ӳɹ���123444");

		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=��;��������ϵͳ���ݿ�";
		
		try {
			Class.forName(JDriver);          //ע��
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			Connection con=DriverManager.getConnection(url,"admin","1");   //����
			//JOptionPane.showMessageDialog(null,"���ӳɹ���lll");
			Statement s=con.createStatement();
			String yy1=txt12.getText().trim();
			String aq1="'"+yy1+"'";
			String asd=null;
			String sss="'"+name+"'";
		
		
			//JOptionPane.showMessageDialog(null,"���Ͽ�ʼ��ѯ���ݿ⣺123");
			String sdd="select * from ��Ʊ�� where �û���="+sss;
			ResultSet rs=s.executeQuery(sdd);
			boolean bh1=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs.next())
			{
				//JOptionPane.showMessageDialog(null,"�õ���ţ�"+yy1.equals(rs.getString("������"))+yy1+rs.getString("������"));
				if(yy1.equals(rs.getString("������").trim()))
				{
					bh1=true;
					aqq2="'"+rs.getString("�������").trim()+"'";
					//JOptionPane.showMessageDialog(null,"�õ���ţ�");
					
				}
			}
			if(bh1)
			{
			String stt1="UPDATE ��Ʊ�� SET �Ƿ���Ʊ="+"'"+"��"+"'"+" where ������="+aq1;
			s.executeUpdate(stt1);
			JOptionPane.showMessageDialog(null,"��Ʊ�ɹ���");
			
			//��ʼ�޸��������е�ʣ������
			int ll=0;
			String sdd1="select * from ������ where �������="+aqq2;
			ResultSet rs0=s.executeQuery(sdd1);
			boolean bh0=false;      //������֤����������յ������ݿ����Ƿ��Ѿ����ڣ�false��ʾ������
			while(rs0.next())//�鿴��ǰ�ж��ٸ��û���ʼֵΪ0
			{
				//JOptionPane.showMessageDialog(null,"�������"+rs0.getInt("ʣ������"));
				int qq1=rs0.getInt("ʣ������");
				qq1++;
				ll=qq1;
			}
			
			//JOptionPane.showMessageDialog(null,"llllk"+ll);
			String stt2="UPDATE ������ SET ʣ������="+ll+" where �������="+aqq2;
			s.executeUpdate(stt2);
			
			}
			
			 s.close();
			  con.close();      //�ر������ݿ���ص�����
		}catch(Exception e1)
			{
				 
			
			}
			
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new �û���������("name1");

		
		
		
	}

}
