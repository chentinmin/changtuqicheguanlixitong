package ��;��������ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class ע�����  extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -4973689437504179656L;
	JLabel la1;
    JLabel la2;
    JLabel la3;
	JButton btn1;
	JButton btn2;
	Panel p,p1,p2,p3;
	JTextField txt;       //��������û���
	JPasswordField jpw1;   //����
	JPasswordField jpw2;
	ע�����()
	{
		
		setSize(400,300);
		setVisible(true);
		setTitle("ע��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 int windowWidth = this.getWidth(); //��ô��ڿ�
		 int windowHeight = this.getHeight(); //��ô��ڸ�
		Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
		Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
		 int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
		this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
		setLayout(null);
		JLabel lab=new JLabel("��ӭע�᳤;��������ϵͳ");
		int size=30;
		lab.setFont(new Font("Serif",Font.PLAIN,size));
		lab.setBounds(10, 5, 380,50);
		la1=new JLabel("�������û�����");
		la1.setBounds(30, 70, 150, 30);
		la2=new JLabel("���������룺");
		la2.setBounds(30, 110, 150, 30);
		la3=new JLabel("�������������룺");
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
		btn1=new JButton("���ص�½����");
		btn1.setBounds(50, 200, 130, 50);
		btn2=new JButton("ע��");
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
		
		
		
		if(e.getSource()==btn1)     //���ص�½����
		{
			JOptionPane.showMessageDialog(null,"���Ϸ��ص�¼�����ˣ�");
			new ��½����();
			this.dispose();
			
			
		}
		if(e.getSource()==btn2)      //ע��
		{
			String str=txt.getText();
			String strr="'"+txt.getText().trim()+"'";
			String str1=jpw1.getText();
			String str1r="'"+jpw1.getText().trim()+"'";
			String str2=jpw2.getText();
			
			boolean bh=false;          //�жϵ�ǰ�û����ǲ��ǹ���Ա���û���
			if(str.equals("�Ԫ��"))
			{
				bh=true;
				JOptionPane.showMessageDialog(null,"��������û����ǹ���Ա�û��������������룡");
				txt.setText(null);
				jpw1.setText(null);
				jpw2.setText(null);
			}
			
			if(!bh)      //���ǹ���Ա�û���ʱ�ſ���ע��
			{
			
			//JOptionPane.showMessageDialog(null,str1+str2);
			if(!str1.equals(str2))    //�����������벻һ����ִ��
			{
				//System.out.println("������������벻һ�������������룡");
				JOptionPane.showMessageDialog(null,"������������벻һ�������������룡");
				jpw1.setText(null);
				jpw2.setText(null);
			}
			
			else   //��ʼ�����ݿ��м��뵱ǰע����û�����Ϣ�������ǰ�û��������ݿ����Ѿ����ڣ������û�����ע��
			{
				
				//�����Ƿ������ݿ������

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
					Statement s=con.createStatement();
					String str3="select �û��� from �û���";
					//PreparedStatement ps=con.prepareStatement(str3);
					ResultSet rs=s.executeQuery(str3);
					boolean b1=false;       //�����ж��Ƿ��û��������붼��ȷ
					//JOptionPane.showMessageDialog(null,"��������û������룺");
					//JOptionPane.showMessageDialog(null,"�û�����"+str);
					while(rs.next())
					{
						
						String ss1=rs.getString("�û���").trim();
						//JOptionPane.showMessageDialog(null,"��������û����û�����"+ss1+str);
						
						
						if(str.equals(ss1))   //��������û�������ע��
						{
							b1=true;
							JOptionPane.showMessageDialog(null,"��������û����Ѿ���ע�ᣬ�����ԣ�");
						}
					}
					if(!b1)     //����������û�ʱִ�������ݿ���д���û���Ϣ
					{
						String stt="insert into �û���(�û���,����) values("+strr+","+str1r+")";
						JOptionPane.showMessageDialog(null,"��ɽ��ʼע�ᣡ");
						s.executeUpdate(stt);              ////����stt�е���䴴����
						JOptionPane.showMessageDialog(null,"�Ѿ��ɹ�ע�ᣬ���ڵ�½���������û����������½��");
						s.close();
					    con.close();     //�ر������ݿ���ص�����
					    this.dispose();
					    new ��½����();
						
					}
					else     //��������û�ʱ�ر����ӣ���������ע����Ϣ
					{
						s.close();
					    con.close();      //�ر������ݿ���ص�����
					    txt.setText(null);
						jpw1.setText(null);
						jpw2.setText(null);
						
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"�������ݿ�����쳣��");
					e1.printStackTrace();
				}
				
			}
			
			}
		}
		
		
	}
	
	
	public static void main(String[] args)
	{
		
		new ע�����();
		
		
	}
	
	
}
