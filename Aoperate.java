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
	 JTextField text=new JTextField("����Աѡ�������");
     JLabel label1=new JLabel("��ѯ����:");
     JButton button1=new JButton("������ѯ");
     JButton button2=new JButton("��·��ѯ");
     JButton button3=new JButton("��Ʊ��ѯ");
     JLabel label2=new JLabel("ɾ��������");
     JButton button4=new JButton("����ɾ��");
     JButton button5=new JButton("��·ɾ��");
     JLabel label3=new JLabel("��Ӳ�����");
     JButton button6=new JButton("�������");
     JButton button7=new JButton("·������");
     JLabel label4=new JLabel("���²�����");
     JButton button8=new JButton("��������");
     JButton button9=new JButton("��·����");
     JButton button10=new JButton("����");
     JButton button11=new JButton("�˳�");
     JPanel panel=new JPanel();
     public Aoperate()
     {
    	this.setSize(600,500);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	this.validate();
    	this.setTitle("����Ա��������");
    	this.setLayout(null);
    	this.add(panel);
    	this.add(text);
    	this.add(label1);
    	this.add(label2);
    	this.add(label3);
    	this.add(label4);
    	this.add(button1);
    	this.add(button2);
    	this.add(button3);
    	this.add(button4);
    	this.add(button5);
    	this.add(button6);
    	this.add(button7);
    	this.add(button8);
    	this.add(button9);
    	this.add(button10);
    	this.add(button11);
    	text.setBounds(200,10,100,30);
    	label1.setBounds(50,80,100,30);
    	button1.setBounds(150,80,100, 30);
    	button2.setBounds(250,80,100, 30);
    	button3.setBounds(350,80,100, 30);
    	label2.setBounds(50,160,100,30);
    	button4.setBounds(150,160,100, 30);
    	button5.setBounds(250,160,100, 30);
    	label3.setBounds(50,240,100,30);
    	button6.setBounds(150,240,100, 30);
    	button7.setBounds(250,240,100, 30);
    	label4.setBounds(50,320,100,30);
    	button8.setBounds(150,320,100, 30);
    	button9.setBounds(250,320,100, 30);
    	button10.setBounds(150,420,100,30);
    	button11.setBounds(350,420,100,30);
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	button4.addActionListener(this);
    	button5.addActionListener(this);
    	button6.addActionListener(this);
    	button7.addActionListener(this);
    	button8.addActionListener(this);
    	button9.addActionListener(this);
    	button10.addActionListener(this);
    	button11.addActionListener(this);
    }
	public void actionPerformed(ActionEvent e)
	{
		Object object=e.getSource();
		if(object.equals(button1))
		{
			
		}
		if(object.equals(button2))
		{
			
		}
		if(object.equals(button3))
		{
			
		}
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
			//���ص���½����
			Login login=new Login();
			dispose();
		}
		if(object.equals(button11))
		{
			int j=JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���?","�˳�",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);     
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
