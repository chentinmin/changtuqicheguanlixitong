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
	JButton button1=new JButton("��½");
	JButton button2=new JButton("����");
	JButton button3=new JButton("�˳�");
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
		this.setTitle("�û���½");
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
		text2.setEchoChar('��');
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
		   JOptionPane.showMessageDialog(null, "���غ�ע�᲻�ɹ�");
		}
		try
		{
		   Con=DriverManager.getConnection(conURL,"11","1");
		}
		catch(Exception ee)
		{
		   JOptionPane.showMessageDialog(null, "�������ݿ�ʧ��");
		}
		if(object.equals(button1))
		{
			//�����ݿ��ж�ȡ�û�ע������������룬������Ӧ����֤
			try 
			{
				String str0=text1.getText();
			    String str1=text2.getText();
			    String SQLsquary="select * from passenger where passenger.PassengerName='"+str0+"' and passenger.PassengerPassword='"+str1+"'";
			    stmt=Con.createStatement();//��������
			    ResultSet result=stmt.executeQuery(SQLsquary);
			  
			   if(result.next())
			   {
			       dispose();
			       new Quary();//��½�ɹ�����ת���û�ѡ���ѯ����;
			   } 
			   else
			   {
			       dispose();
			       JOptionPane.showMessageDialog(null, "����˺���û��ע��,��ע������˺�");
			       new Welcome();
			   }
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, "��½ʧ��");
			}
		}
		if(object.equals(button2))
		{
			dispose();
			new UsersRegister();//���ص���ʼע�����
		}
		if(object.equals(button3))
		{
		    int j=JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���?","�˳�",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
			if(j==JOptionPane.YES_NO_OPTION)
			{
			   System.exit(0);
			}
		}
	}
}

