package ctqcgl;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class CarQuary extends JFrame implements ActionListener
{
	JButton button0;
	JButton button1;
	JButton button2;
	JScrollPane p1 = new JScrollPane();
	CarQuary()
	{
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		validate();
		add(p1);
		p1.setBounds(200,100,350,300);
		button0=new JButton("��ѯ");
		button1=new JButton("����");
		button2=new JButton("�˳�");
		add(button0);
		add(button1);
		add(button2);
		button0.setBounds(40,100,100,30);
		button0.addActionListener(this);
		button1.setBounds(40,200,100,30);
		button1.addActionListener(this);
		button2.setBounds(40,300,100,30);
		button2.addActionListener(this);
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
		        {
					setVisible(false);
					JOptionPane.showMessageDialog(null,"��ѯ����!");
				}
			}
		);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button0)
		{
			try
			{
				Carquary();
			}
			catch(SQLException ee)
			{
				System.out.println(ee.getMessage());
			}
		}
		if(e.getSource()==button1)
		{
			dispose();
			new Quary();
		}
		if(e.getSource()==button2)
		{
			int j=JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���?","�˳�",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
			if(j==JOptionPane.YES_NO_OPTION)
			{
			   System.exit(0);
			}
		}	
	}
	public void Carquary() throws SQLException
	{
		Connection Con = null;
		Statement Stmt = null;
		String conURL = "jdbc:sqlserver://localhost:1433;databaseName=CTQCGLXT";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(ClassNotFoundException ee)
		{
			System.out.println("����1");
		}
		try
		{
			//System.out.println("����");
			Con = DriverManager.getConnection(conURL,"11","1");
			Stmt = Con.createStatement();
		}
		catch(SQLException ee) {System.out.println("����2");}
		Stmt = Con.createStatement();
		String quary="select * from Car";
		ResultSet rs = Stmt.executeQuery(quary);
		Vector columnNames = new Vector();
		columnNames.add("CoachNumber");
		columnNames.add("LineNumber");
		columnNames.add("Departuretime");
		columnNames.add("Maxmum");
		columnNames.add("ResidualCapacity");
		Vector rowData = new Vector();
		while(rs.next())
		{
		   Vector hang = new Vector();
		   hang.add(rs.getInt(1));
	       hang.add(rs.getInt(2));
		   hang.add(rs.getString(3));
		   hang.add(rs.getInt(4));
		   hang.add(rs.getInt(5));
		   rowData.add(hang);
		}
		JTable jt = new JTable(rowData,columnNames);//����������JTable��
		p1.getViewport().add(jt);//��JTable�Ķ������p1�ؼ���
		JOptionPane.showMessageDialog(null,"��ѯ����!");
		JOptionPane.showMessageDialog(null,"���������ѯ����������");
		Con.close();//�ر���������
	}
}