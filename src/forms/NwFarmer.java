
package forms;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class L_Process2 extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JLabel head,uidl,namel,mobl;
	JTextField uidt,namet,mobt;
	JButton next,close;
	JPanel field;
	
	JLabel uerrl,nerrl,merrl;
	boolean chk1,chk2,chk3;
	
	
	String username="^(([a-zA-Z]+)([a-zA-Z0-9@.-_]+))$";
	String mobile="^((0091)|(\\+91)|0?)[789]\\d{9}$";
	String name="^[a-zA-Z]+(?:\\s+[a-zA-Z]+)*$";
	L_Process2(final String u)
	{
		con=connectMysql.getConnection();
		setLocation(700, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		Font f=new Font("Oswald",Font.BOLD,15);
		field = new JPanel();
		field.setLayout(null);
		field.setBorder(BorderFactory.createTitledBorder(""));
		//field.setBackground(new Color(69,184,20));
		field.setBounds(100,100,380,150);
		add(field);
		
        addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				 new adminControl(u);
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		head=new JLabel("ADD NEW FARMER");
		head.setFont(f);
		head.setBounds(220, 20, 300, 50);
		add(head);
		
		uidl=new JLabel("Farmer's User ID");
		uidl.setBounds(30, 20, 100, 20);
		
		field.add(uidl);
		
	
		
		uidt=new JTextField();
		uidt.setBounds(130, 20, 100,20);
		field.add(uidt);
		
		uerrl=new JLabel();
		uerrl.setBounds(250, 20, 100, 20);
		field.add(uerrl);
		
		namel=new JLabel("Farmer's Name");
		namel.setBounds(30, 60, 100, 20);
		field.add(namel);
		
		namet=new JTextField();
		namet.setBounds(130, 60, 100, 20);
		field.add(namet);
		
		nerrl=new JLabel();
		nerrl.setBounds(250, 60, 100, 20);
		field.add(nerrl);
		
		mobl=new JLabel("Mobile");
		mobl.setBounds(30, 100, 100, 20);
		field.add(mobl);
		
		mobt=new JTextField();
		mobt.setBounds(130, 100, 100, 20);
		field.add(mobt);
		
		merrl=new JLabel();
		merrl.setBounds(250, 100, 100, 20);
		field.add(merrl);
		
		next=new JButton("NEXT");
		next.setBounds(90,270, 200, 20);
		add(next);
		
		close=new JButton("CLOSE");
		close.setBounds(290,270, 200, 20);
		add(close);
		
		uidt.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(uidt.getText().matches(username))
				{	
					//count++;
					uerrl.setText("valid");
					uidt.setBackground(Color.white);
					chk1=true;
				}
				else
				{
					uerrl.setText("*Invalid Name");
					uidt.setBackground(Color.red);
				    chk1=false;
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e)
			{
				//uidt.setBackground(Color.yellow);
				
			}
		});
		
mobt.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(mobt.getText().matches(mobile))
				{	
					//count++;
					merrl.setText("valid");
					mobt.setBackground(Color.white);
					chk2=true;
				}
				else
				{
					merrl.setText("*Invalid Number");
					mobt.setBackground(Color.red);
					chk2=false;
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e)
			{
				//mobt.setBackground(Color.yellow);
				
			}
		});

namet.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent e) {
		if(namet.getText().matches(name))
		{	
			//count++;
			nerrl.setText("valid");
			namet.setBackground(Color.white);
			chk3=true;
		}
		else
		{
			nerrl.setText("*Invalid Name");
			namet.setBackground(Color.red);
			chk3=false;
		}
		
	}
	
	@Override
	public void focusGained(FocusEvent e)
	{
		//namet.setBackground(Color.yellow);
		
	}
});
		
		
		
		
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   dispose();
				new adminControl(u);
			}
		});
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a = uidt.getText();
				String p = namet.getText();
				String m = mobt.getText();
				try {
					if((chk1)&&chk2&&chk3)
					{	
						//if(uidt.getText().equals(""))
						{
						doLogin(a,p,m);
					    dispose();
						new process2(a,u);
						}
						}
					else
					JOptionPane.showMessageDialog(null, "Check something is filled Wrong.");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "FarmerID already exist!");
				}
			}
		});
		
		setResizable(false);
		setVisible(true);
		setSize(600,500);
		repaint();
	
	}
	
	
	void doLogin(String u,String p,String m) throws Exception
	{
		int s=0;
		pst=con.prepareStatement("insert into farmers(farmer_id,farmer_name,mobile) values (?,?,?)");
		pst.setString(1, u);
		pst.setString(2, p);
		pst.setString(3, m);
		
		int x=pst.executeUpdate();
		JOptionPane.showMessageDialog(null,"Successfully Registered");
		pst.close();
		
	}
	
}

public class NwFarmer
{
	public static void main (String[] args)
	{
		new L_Process2(null);
	}
}
