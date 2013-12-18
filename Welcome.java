package ctqcgl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Welcome extends JFrame implements ActionListener
{
	JButton button;
	JRadioButton radiobutton1;
	JRadioButton radiobutton2;
	JRadioButton radiobutton3;
	AdministratorLogin Administratorlogin;
	UsersRegister Usersregister;
	public Welcome()
	{
		this.setSize(380,200);
		this.setLocationRelativeTo(null);
		this.setTitle("欢迎登陆注册长途汽车管理系统");
		this.setLayout(new FlowLayout());
		radiobutton1=new JRadioButton("管理员登陆");
		radiobutton1.addActionListener(this);
		this.setVisible(true);
	    this.validate();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(radiobutton1);
	    radiobutton2=new JRadioButton("乘客注册");
	    radiobutton2.addActionListener(this);
	    this.add(radiobutton2);
	    radiobutton3=new JRadioButton("乘客登陆");
	    radiobutton3.addActionListener(this);
	    this.add(radiobutton3);
	    ButtonGroup bg=new ButtonGroup();
	    bg.add(radiobutton1);
	    bg.add(radiobutton2);
	    bg.add(radiobutton3);
	    button=new JButton("退出");
	    this.add(button);
	    button.addActionListener(this);
	    button.setBounds(150, 60,100,30);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==radiobutton1)
		{
			//关闭界面,跳转到管理员登陆界面
			dispose();
			new AdministratorLogin();
		}
		if(e.getSource()==radiobutton2)
		{
			dispose();
			JOptionPane.showMessageDialog(null,"请注意:用户名或密码不能为空,为空不能注册");
			new UsersRegister();
		}
		if(e.getSource()==radiobutton3)
		{
			dispose();
			new UserLogin();
		}
		if(e.getSource()==button)
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
		Welcome welcome=new Welcome();
	}
}


