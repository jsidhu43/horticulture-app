package forms;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class F_Process extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JLabel head,uidl;
	JTextField uidt;
	JButton sms;
	JPanel field;
	
	F_Process()
	{
	
		Font f=new Font("Oswald",Font.BOLD,25);
		con=connectMysql.getConnection();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(700, 200);
		setResizable(false);
		setLayout(null);
		field = new JPanel();
		field.setLayout(null);
		field.setBorder(BorderFactory.createTitledBorder(""));
		field.setBounds(100,100,280,100);
		add(field);
		
		head=new JLabel("FORGOT PASSWORD");
		head.setBounds(135, 20, 250, 50);
		head.setFont(f);
		add(head);
		
		uidl=new JLabel("User ID");
		uidl.setBounds(30, 40, 100, 20);
		field.add(uidl);
		
		uidt=new JTextField();
		uidt.setBounds(130, 40, 100,20);
		field.add(uidt);
		
		sms=new JButton("SEND SMS");
		sms.setBounds(135,230, 200, 20);
		add(sms);
		
		sms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String x= uidt.getText();
				try {
					getPassword(x);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		setVisible(true);
		setSize(500,400);
		repaint();
	
	
	}
	
	void getPassword(String u) throws Exception
	{
		int s=0;
		String pwd="",mob="",nam="";
		pst=con.prepareStatement("select * from admin where user_id=?");
		pst.setString(1,u);
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next())
			{
				s=1;
				pwd=rs.getString("password");
				mob=rs.getString("mobile");
				nam=rs.getString("u_name");
			}
		
							
		else
			s=0;
		
		if(s==1)
		{	String msg="User ID: "+u+"  Name: "+nam+"  Password: "+pwd;
			//JOptionPane.showMessageDialog(null,msg);
		String sms = smsDone.bceSunSoftSend("sunsoft123","sunsoft1234",mob,msg,"SUNSFT");
			
			JOptionPane.showMessageDialog(null,"<html>"+sms+"</html>");
		}
				
		else
			JOptionPane.showMessageDialog(null, "Invalid User ID");
			
		pst.close();
		
		
	}
	
}	

public class Forgot 
{
	public static void main (String[] args)
	{
		new F_Process();
	}
}
