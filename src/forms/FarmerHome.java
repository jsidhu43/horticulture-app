package forms;



import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;



class process2 extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JButton assignsub,assignins,vwsub,vwins,profile,see;
	JPanel field;
	JLabel farmerid,farmername,mobile,vfarmerid,vfarmername,vmobile;
	String f;
	process2(String fid,final String u) throws Exception
	{	
		
		setResizable(false);
		setLocation(700, 200);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
			     new adminControl(u);	
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		f=fid;
		con=connectMysql.getConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		field = new JPanel();
		field.setLayout(null);
		field.setBorder(BorderFactory.createTitledBorder(""));
		field.setBounds(50,50,465,400);
		add(field);

		assignsub = new JButton("Assign a Project");
		assignsub.setBounds(25,200,200,30);
		field.add(assignsub);
		
		
		assignsub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new assign_subsidy(f);
			}
		});
		
		assignins= new JButton("Assign an Insecticide");
		assignins.setBounds(235,200,200,30);
		field.add(assignins);
		
		assignins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new assign_Insectiside(f);
				
			}
		});
		
		
		
		vwsub = new JButton("View Assigned Projects");
		vwsub.setBounds(25,250,200,30);
		field.add(vwsub);
		
		vwsub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   new viewSubsidyTable(f);				
			}
		});
		
		vwins = new JButton("View Assigned Insecticides");
		vwins.setBounds(235,250,200,30);
		field.add(vwins);
		
		vwins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new viewInsectisideTable(f);
				
			}
		});
		
		profile = new JButton("Farmer Profile");
		profile.setBounds(25,300,410,30);
		field.add(profile);
		
		profile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Profile(f);
				
			}
		});
		
		
		farmerid=new JLabel("Farmer ID :");
		farmerid.setBounds(25, 25, 100, 20);
		field.add(farmerid);
		
		
		
		
		
		vfarmerid=new JLabel();
		vfarmerid.setText(f);
		vfarmerid.setBounds(150, 25, 200, 20);
		field.add(vfarmerid);
		
		farmername=new JLabel("Farmer's Name :");
		farmername.setBounds(25, 75, 100, 20);
		field.add(farmername);
		

		vfarmername=new JLabel("");
		vfarmername.setBounds(150, 75, 200, 20);
		field.add(vfarmername);
		
		mobile=new JLabel("Mobile No. :");
		mobile.setBounds(25, 125, 100, 20);
		field.add(mobile);
		
		vmobile=new JLabel("");
		vmobile.setBounds(150, 125, 100, 20);
		field.add(vmobile);
		
		setResizable(false);
		setVisible(true);
		setSize(600,500);
		repaint();
	
		onload();
	}
	
	void onload()
	{
		try {
			String s=vfarmerid.getText();
			pst=con.prepareStatement("select farmer_name,mobile from farmers where farmer_id=?");
			pst.setString(1, s);
			 ResultSet rs=pst.executeQuery();
			if(rs.next())
			 {//JOptionPane.showMessageDialog(null, rs+" recieved");
			   vfarmername.setText(rs.getString("farmer_name"));
			   vmobile.setText(rs.getString("mobile"));
			 
			 }
			
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
public class FarmerHome 
{
	public static void main(String[] args)  throws Exception
	{
		new process2(null,null);

	}
}
