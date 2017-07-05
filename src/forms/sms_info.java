package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class info extends JFrame
{
	JLabel inf,newl,warning;
	JTextField newt;
	JTextArea msg;
	JButton send,addb;
	JScrollPane scroll,scroll2;
	JList list;
	DefaultListModel deflist;
	Connection con;
	PreparedStatement pst;
	JCheckBox all;


	info()
	{   
		setLocation(700, 200);
		setResizable(false);
		setLayout(null);

		Font f= new Font("arial", Font.BOLD, 23);

		con=connectMysql.getConnection();

		inf=new JLabel("Information To Farmers ");
		inf.setFont(f);
		inf.setOpaque(true);

		inf.setBounds(110, 30, 270, 30);
		add(inf);
		
		newl=new JLabel("Add a Number");
		newl.setBounds(350, 130, 100, 20);
		add(newl);
		
		newt=new JTextField();
		newt.setBounds(342, 150, 100, 20);
		add(newt);
		
		addb=new JButton("ADD");
		addb.setBounds(358, 180, 60, 20);
		add(addb);
		
		addb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String regex2="^[789]\\d{9}$";
				
				if(newt.getText().matches(regex2))
				{
				deflist.addElement(newt.getText());
				JOptionPane.showMessageDialog(null,newt.getText()+" Added");
					newt.setText("");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Enter Correct Mobile Number!");
					newt.setText("");
				}
			}
		});

		JLabel mob=new JLabel("Mobile Numbers");
		mob.setBounds(30, 160, 100, 30);
		add(mob);

		all=new JCheckBox("Select All");
		all.setBounds(146,250, 100, 20);	
		add(all);


		all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				if(all.isSelected())
				{
					int start = 0;
				    int end = list.getModel().getSize() - 1;
				    if (end >= 0) {
				      list.setSelectionInterval(start, end);
				    }
				}
				
				else
				{
					int start = 0;
				    int end = list.getModel().getSize() - 1;
				    if (end >= 0) {
				      list.removeSelectionInterval(start, end);
				    }
				}
			}
		});


		deflist=new DefaultListModel(); 
		list=new JList(deflist); 

		scroll2=new JScrollPane(list);
		scroll2.setBounds(150, 100,150,150);
		add(scroll2);


		JLabel msgl=new JLabel("Message");
		msgl.setBounds(30, 325, 100, 30);
		add(msgl);


		msg=new JTextArea();
		scroll=new JScrollPane(msg);
		scroll.setBounds(150, 290, 200, 100);
		Font f1= new Font("arial", Font.PLAIN, 18);
		msg.setLineWrap(true);
		msg.setToolTipText("Do Not Press Enter!");
		msg.setFont(f1);
		add(scroll);
		
		warning=new JLabel();
		Font f2=new Font("arial",Font.BOLD,10);
		warning.setFont(f2);
		warning.setText("*Do Not Press Enter!");
		warning.setBounds(150, 390, 150, 10);
		add(warning);
		


		mobs();





		send=new JButton("Send");
		send.setBounds(150, 420, 150, 30);
		add(send);

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ss = null;
				Object a[]=list.getSelectedValues();
				for (int i = 0; i < a.length; i++) 
				{
					ss = ss + a[i] +",";
				}


				//boolean x=ss.endsWith(",");
				//JOptionPane.showMessageDialog(null, x);
				int sa =ss.lastIndexOf(",");
				String ssa =ss.substring(4, sa);
				JOptionPane.showMessageDialog(null, ssa);
				String message=msg.getText();
				//JOptionPane.showMessageDialog(null, message);
				String sms_msg=smsDone.bceSunSoftSend("sunsoft123","sunsoft1234",ssa,message,"SUNSFT");
				JOptionPane.showMessageDialog(null,"<html>"+sms_msg+"</html>");
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,520);
		setVisible(true);
		//  this.dispose();
		repaint();

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});



	}

	void mobs()
	{
		try {
			pst=con.prepareStatement("select * from farmers");

			ResultSet rs=pst.executeQuery();

			while(rs.next())
			{
				String m=rs.getString("mobile");
				//number.setString(";"+m);

				deflist.addElement(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}




public class sms_info {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new info();

	}

}