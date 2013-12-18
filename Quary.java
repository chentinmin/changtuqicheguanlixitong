package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
public class Quary extends JFrame implements ActionListener
{
	JButton button1=new JButton("汽车查询");
	JButton button2=new JButton("车票查询");
	JButton button3=new JButton("线路查询");
	JButton button4=new JButton("返回");
	JButton button5=new JButton("退出");
	CarQuary carquary=null;
	TicketQuary ticketquary=null;
	LineQuary linequary=null;
	public Quary()
	{
		this.setSize(550,400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.validate();
		this.setTitle("用户查询");
		this.setLayout(null);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		button1.setBounds(100,100,100,30);
		button2.setBounds(220,100,100,30);
		button3.setBounds(340,100,100,30);
		button4.setBounds(150,240,80,30);
		button5.setBounds(300,240,60,30);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object object=e.getSource();
		if(object.equals(button1))
		{
			dispose();//关闭界面，跳转到汽车查询界面
			new CarQuary();
		}
		if(object.equals(button2))
		{
			dispose();
		    new TicketQuary();
		}
		if(object.equals(button3))
		{
			dispose();
			new LineQuary();
		}
		if(object.equals(button4))
		{
			dispose();//关闭界面
			new UserLogin();//返回到用户登陆界面
		}
		if(object.equals(button5))
		{
			int j=JOptionPane.showConfirmDialog(null,"确定要退出吗?","退出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
			if(j==JOptionPane.YES_NO_OPTION)
			{
			   System.exit(0);
			}
		}
	}
} 

