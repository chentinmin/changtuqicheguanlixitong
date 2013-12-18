package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
public class Aoperate extends JFrame implements ActionListener
{
     JLabel label1=new JLabel("查询操作:");
     JButton box1;
     JButton box2;
     JButton box3;
     JLabel label2=new JLabel("增删操作：");
     JButton button4;
     JButton button5;
     JButton button6;
     JButton button7;
     JButton button8;
     JButton button9;
     JButton button10=new JButton("返回");
     JButton button11=new JButton("退出");
     public Aoperate()
     {
    	this.setSize(600,500);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    	this.setTitle("管理员操作界面");
    	this.setLayout(null);
    	box1=new JButton("汽车查询");
    	box1.addActionListener(this);
    	this.add(box1);
    	box2=new JButton("线路查询");
     	box2.addActionListener(this);
    	this.add(box2);
    	box3=new JButton("车票查询");
    	box3.addActionListener(this);;
    	this.add(box3);
    	this.add(label1);
    	this.add(label2);
    	button4=new JButton("汽车删除");
    	button4.addActionListener(this);
    	this.add(button4);
        button5=new JButton("线路删除");
        button5.addActionListener(this);
    	this.add(button5);
        button6=new JButton("班次增加");
        button6.addActionListener(this);
    	this.add(button6);
        button7=new JButton("路线增加");
        button7.addActionListener(this);
    	this.add(button7);
        button8=new JButton("汽车更新");
        button8.addActionListener(this);
    	this.add(button8);
        button9=new JButton("线路更新");
        button9.addActionListener(this);
    	this.add(button9);
        this.add(button10);
        this.add(button11);
    	label1.setBounds(50,80,100,30);
    	box1.setBounds(150,80,100, 30);
    	box2.setBounds(275,80,100, 30);
    	box3.setBounds(400,80,100, 30);
    	label2.setBounds(50,260,100,30);
    	button4.setBounds(150,160,100, 30);
    	button5.setBounds(250,160,100, 30);
    	button6.setBounds(150,240,100, 30);
    	button7.setBounds(250,240,100, 30);
    	button8.setBounds(150,320,100, 30);
    	button9.setBounds(250,320,100, 30);
    	button10.setBounds(400,160,100,30);
    	button11.setBounds(400,320,100,30);
    	button10.addActionListener(this);
    	button11.addActionListener(this);
    	this.validate();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public void actionPerformed(ActionEvent e)
	{
		Object object=e.getSource();
		if(object.equals(button4))
		{
			
		}
		if(object.equals(button5))
		{
			
		}
		if(object.equals(button6))
		{
			
		}
		if(object.equals(button7))
		{
			
		}
		if(object.equals(button8))
		{
			
		}
		if(object.equals(button9))
		{
			
		}
		if(object.equals(button10))
		{
			//返回到登陆界面
			new AdministratorLogin();
			dispose();
		}
		if(object.equals(button11))
		{
			int j=JOptionPane.showConfirmDialog(null,"确定要退出吗?","退出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
			if(j==JOptionPane.YES_NO_OPTION)
			{
			   System.exit(0);
			}
		}
	}
	public static void main(String args[])
	{
	   Aoperate operate=new Aoperate();
	}
	
}
