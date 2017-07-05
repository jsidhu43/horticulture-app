package forms;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

class adminControl
{
	Connection con;
	PreparedStatement pst;
	JFrame fr=new JFrame("Admin Controls");
	JButton farmers=new JButton("Farmer's Enrolled");
	JButton addSubsidy=new JButton("Add Project");
	JButton viewSubsidy=new JButton("View Projects");
	JButton addInsect=new JButton("Add Insecticide");
	JButton viewInsect=new JButton("View Insecticides");
	JPanel j1,field;
	JLabel farmerid,vfarmerid,farmername,vfarmername,mobile,vmobile;
	//JButton addSubsidyform1=new JButton("Print SubsidyForm ");
	JButton faq=new JButton("SMS Portal");
	
	JLabel logout,help;
	String u;
	
	JPasswordField pwd=new JPasswordField();
	JLabel Fnamel,Fidl,Fmobilel;
	JTextField Fname,Fid,Fmobile;
	JButton newF,existF,adminDB;
	
	
	adminControl(String User)
	{
		u=User;
		con=connectMysql.getConnection();
		//Font f1=new Font("oswald",Font.BOLD,20);
		//Font f1=new Font(null,Font.BOLD,14);
		//Font f=new Font("Bell MT", 0, 18);
		//Font f2=new FontUIResource("Roman", Font.BOLD, 12);
		//fr.setUndecorated(true);
		//fr.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG); 
		//fr.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		fr.setResizable(false);
		fr.setSize(630,600);
		fr.setVisible(true);
		fr.setLayout(null);
		fr.setLocation(700, 200);
		
		
		help=new JLabel(new ImageIcon(getClass().getResource("/help.png")));
		help.setBounds(540, 30,30,30);
		fr.add(help);
		help.setToolTipText("Contact");
		
		help.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new aboutUs();
				
			}
		});
		
		logout=new JLabel(new ImageIcon(getClass().getResource("/logout1.png")));
		logout.setBounds(500, 30,30,30);
		fr.add(logout);
		logout.setToolTipText("Logout");
		
		logout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				fr.dispose();
				new login();
				
			}
		});
		
		//fr.setBackground(Color.green);
		//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//farmers.setFont(f1);
		farmers.setBounds(20,20,170,50);
		fr.add(farmers);
		
		j1=new JPanel();
		j1.setLayout(null);
		j1.setBounds(10, 220, 595, 342);
		j1.setBorder(BorderFactory.createTitledBorder(""));
		fr.add(j1);
		
		farmers.setBounds(5, 5, 190, 50);
		j1.add(farmers);
		
		
		farmers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new showTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		faq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				new info();
			}
		});
		
		//----------------------------------------------------------------------------------------------------//
		
		//addSubsidy.setFont(f1);
		addSubsidy.setBounds(5,75,290,50);
		j1.add(addSubsidy);
		
		addSubsidy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.setVisible(false);
				new formaddSubsidy(u);
				
			}
		});
		
		//----------------------------------------------------------------------------------------------------//
		//viewSubsidy.setFont(f1);
		viewSubsidy.setBounds(5,145,290,50);
		j1.add(viewSubsidy);
		
		viewSubsidy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.setVisible(false);
				new formviewSubsidy(u);
				
			}
		});
	
		//----------------------------------------------------------------------------------------------------//
		
		viewInsect.setBounds(300,145,290,50);
		j1.add(viewInsect);
		
		viewInsect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.setVisible(false);
				new subsidyview_Insectiside(u);			
			}
		});
		//----------------------------------------------------------------------------------------------------//
		
		addInsect.setBounds(300,75,290,50);
		j1.add(addInsect);
		
		addInsect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    fr.setVisible(false);
				new subsidy_Insectiside(u);			
			}
		});
		
		
		//----------------------------------------------------------------------------------------------------//
		
		faq.setBounds(205,5,190,50);
		j1.add(faq);
		
		//----------------------------------------------------------------------------------------------------//
		
		  adminDB=new JButton("Change Password?");
		  adminDB.setBounds(400,5, 190,50);
		  j1.add(adminDB);
		  
		     adminDB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					//JPasswordField pwd = new JPasswordField();
				   // int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION);
				   // if(action < 0)JOptionPane.showMessageDialog(null,"Cancel, X or escape key selected");
				   // else JOptionPane.showMessageDialog(null,"Your password is "+new String(pwd.getPassword()));
					
					
					//JLabel lbl=new JLabel("Enter Password");
					//JOptionPane.showInputDialog(null,pwd,lbl);
				     new change_Password1(u);
					
				}
			});
		  
			//----------------------------------------------------------------------------------------------------//
		  
		 newF=new JButton("New Farmer");
	        newF.setBounds(5,215,585,50);
	        j1.add(newF);
		
			//----------------------------------------------------------------------------------------------------//
	        
	        
	        existF=new JButton("Existing Farmer");
	        existF.setBounds(5,285,585,50);
	        j1.add(existF);
	        
			//----------------------------------------------------------------------------------------------------//  
	        
	        field=new JPanel();
	        field.setLayout(null);
			field.setBounds(00, 20, 300, 180);
			//field.setBorder(BorderFactory.createTitledBorder(""));
			fr.add(field);
	        
	        farmerid=new JLabel("Admin ID :");
	        //farmerid.setFont(f1);
			farmerid.setBounds(25, 25, 100, 20);
			field.add(farmerid);
			
			vfarmerid=new JLabel();
			vfarmerid.setBounds(150, 25, 100, 20);
			//vfarmerid.setFont(f1);
			field.add(vfarmerid);
			
			farmername=new JLabel("Admin's Name :");
			farmername.setBounds(25, 75, 100, 20);
			//farmername.setFont(f1);
			field.add(farmername);
			

			vfarmername=new JLabel();
			//vfarmername.setFont(f1);
			vfarmername.setBounds(150, 75, 100, 20);
			field.add(vfarmername);
			
			mobile=new JLabel("Mobile No. :");
			//mobile.setFont(f1);
			mobile.setBounds(25, 125, 100, 20);
			field.add(mobile);
			
			vmobile=new JLabel();
			vmobile.setBounds(150, 125, 100, 20);
			//vfarmername.setFont(f1);
			field.add(vmobile);
		
	
		try {
			fetchinfo(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		fr.repaint();
		
		adminDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	new F_Process();
			}
		});
		
		newF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				new L_Process2(u);
				fr.dispose();
			}
		});
		
		existF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					check();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	void check() throws SQLException
	{
		int s;
		String aa=JOptionPane.showInputDialog(null, "Enter Farmer ID:");
		pst=con.prepareStatement("select * from farmers where farmer_id=?");
		pst.setString(1, aa);
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next())
			s=1;
		else
			s=0;
		
		if(s==1)
		{
			try {
				
				new process2(aa,u);fr.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Invalid Farmer ID!");
			
		pst.close();
	}
	
	void fetchinfo(String s) throws SQLException
	{	
		//JOptionPane.showMessageDialog(null,s);
		int ss=0;
		pst = con.prepareStatement("select * from admin where user_id=?");
		pst.setString(1,s);
		ResultSet rs=pst.executeQuery();
		
		
		
		String nam="",mob="";
		if(rs.next())
		{
			ss=1;
		}
		else ss=0;
		
		if(ss==1)
		{
			nam=rs.getString("u_name");
			mob=rs.getString("mobile");
			vfarmerid.setText(s);
			vfarmername.setText(nam);
			vmobile.setText(mob);
			//JOptionPane.showMessageDialog(null,s+nam+mob);
		}
		pst.close();
	}
	
	
	

}

public class adminAfterLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new adminControl(null);
	}

}
