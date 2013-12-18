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
		this.setTitle("��ӭ��½ע�᳤;��������ϵͳ");
		this.setLayout(new FlowLayout());
		radiobutton1=new JRadioButton("����Ա��½");
		radiobutton1.addActionListener(this);
		this.setVisible(true);
	    this.validate();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(radiobutton1);
	    radiobutton2=new JRadioButton("�˿�ע��");
	    radiobutton2.addActionListener(this);
	    this.add(radiobutton2);
	    radiobutton3=new JRadioButton("�˿͵�½");
	    radiobutton3.addActionListener(this);
	    this.add(radiobutton3);
	    ButtonGroup bg=new ButtonGroup();
	    bg.add(radiobutton1);
	    bg.add(radiobutton2);
	    bg.add(radiobutton3);
	    button=new JButton("�˳�");
	    this.add(button);
	    button.addActionListener(this);
	    button.setBounds(150, 60,100,30);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==radiobutton1)
		{
			//�رս���,��ת������Ա��½����
			dispose();
			new AdministratorLogin();
		}
		if(e.getSource()==radiobutton2)
		{
			dispose();
			JOptionPane.showMessageDialog(null,"��ע��:�û��������벻��Ϊ��,Ϊ�ղ���ע��");
			new UsersRegister();
		}
		if(e.getSource()==radiobutton3)
		{
			dispose();
			new UserLogin();
		}
		if(e.getSource()==button)
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
		Welcome welcome=new Welcome();
	}
}


