package ��;��������ϵͳ;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class ��½���� extends JFrame implements ActionListener
{
    JLabel la1;
    JLabel la2;
	JButton btn1;
	JButton btn2;
	Panel p,p1,p2;
	JTextField txt;
	JPasswordField jpw;
	��½����()
	{
		setSize(500,300);
		setVisible(true);
		setTitle("��½");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		 int windowWidth = this.getWidth(); //��ô��ڿ�
		 int windowHeight = this.getHeight(); //��ô��ڸ�
		Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
		Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
		 int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
		this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
		JLabel lab=new JLabel("��ӭ��½��;��������ϵͳ");
		int size=30;
		lab.setFont(new Font("Serif",Font.PLAIN,size));
		lab.setBounds(50, 5, 400,50);
		la1=new JLabel("�������û�����");
		la1.setBounds(50, 50, 150, 30);
		la2=new JLabel("���������룺");
		la2.setBounds(50, 100, 150, 30);
		p=new Panel();
		p.setBounds(0, 0,500, 300);
		p.setLayout(null);
		txt=new JTextField(10);
		txt.setBounds(210, 50, 200, 30);
		jpw=new JPasswordField(20);
		jpw.setBounds(210, 100, 200, 30);
		btn1=new JButton("��½");
		btn1.setBounds(150, 150, 70, 30);
		btn2=new JButton("ע��");
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
			if(str1.equals("�Ԫ��"))
			{
				if(str2.equals("123"))
				{
					new ����Ա��������();
					bi1=true;
				}
			}
			if(!bi1)
			{
			//��½ǰ�������û�����������ȷ
			String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url="jdbc:sqlserver://localhost:1433;DatabaseName=��;��������ϵͳ���ݿ�";
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
				String str3="select * from �û���";
				ResultSet rs=s.executeQuery(str3);
				boolean b1=false;//�����ж��Ƿ��û��������붼��ȷ
				//JOptionPane.showMessageDialog(null,"��������û������룺");
				JOptionPane.showMessageDialog(null,"�û�����"+str1);
				while(rs.next())
				{
					
					String ss1=rs.getString("�û���").trim();
					//JOptionPane.showMessageDialog(null,"��������û����û�����"+ss1+str1);
					String ss2=rs.getString("����").trim();
					//JOptionPane.showMessageDialog(null,"��������û������룺"+str2+ss2+str1.equals(ss1));
					if(str1.equals(ss1))
					{
						//JOptionPane.showMessageDialog(null,"��������û������룺"+ss2);
						if(str2.equals(ss2))
						{ 
							b1=true;
							JOptionPane.showMessageDialog(null,"���Ե�¼�ˣ�");
							new �û���������(ss1);
						}
					}
				}
				if(!b1)     //����ȷ��ִ��
				{
					JOptionPane.showMessageDialog(null,"��������û����������벻�ԣ������ԣ�");
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
		if(e.getSource()==btn2)      //ע����ֱ�ӹص���ǰ���棬����ע�����
		{
			JOptionPane.showMessageDialog(null,"���Ͻ���ע������ˣ�");
			this.dispose();
			new ע�����();
		}	
	} 
	public static void main(String[] args)
	{
		new ��½����();
	}
}
