package forms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import java.net.URL;
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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


class login extends JFrame
{
	JPanel pnl=new JPanel();
	JPanel pnl1=new JPanel();
	
	JLabel passwordl=new JLabel("PASSWORD");
	JLabel uidl=new JLabel("USERNAME");
	JTextField uid=new JTextField("");
	JPasswordField password=new JPasswordField("");
	JButton login=new JButton("Login");
	JButton fPassword=new JButton("Forgot Password");
    JLabel heading=new JLabel("NATIONAL HORTICULTURE BOARD");
    JLabel pic;
	Connection con;
	PreparedStatement pst;


	login()
	{
		pnl1.setLayout(null);
		pnl1.setBounds(20,40,500,300);
	   // pnl1.setBackground(new Color(10,10,10));
		add(pnl1);
		
		
		
		con=connectMysql.getConnection(); 	 
        
		setTitle("Admin Login");
		
		Font f=new Font("Courier New",Font.BOLD,15);
		Font f1=new Font("Courier New",Font.BOLD,29);
		//Font f2=new Font("Courier New",Font.BOLD,16);
		//setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG); 
		

         Color col=Color.green.darker();
         
         ImageIcon icon=new ImageIcon(getClass().getResource("/pic5.png"));
         
         pic=new JLabel(icon);
         pic.setBounds(170,0,200,250);
         pnl1.add(pic);
         pic. setCursor(new Cursor(Cursor.HAND_CURSOR));
         
         
         heading.setBounds(30, 240, 500, 50);
         heading.setFont(f1);
         pnl1.add(heading);
         
         
         //getContentPane().setBackground(new Color(103,180,180));
         
         
		pnl.setLayout(null);
		pnl.setBounds(50,250,450,350);
	   // pnl.setBackground(new Color(103,180,180));
		
		// pnl.setBackground(Color.decode("#bdb67b"));
		//pnl.setBorder(BorderFactory.createTitledBorder("Admin Login "));
		//TitledBorder titledBorder = BorderFactory.createTitledBorder("Admin Login");
		//titledBorder.
		//pnl.setBorder(titledBorder);	
		add(pnl);




		uidl.setBounds(70,140,100,30);
		
		uidl.setFont(f);
		uid.setToolTipText("Enter the user name.");
		uidl.setOpaque(true);
		// uidl.setBackground(Color.orange);
		pnl.add(uidl);

		uid.setBounds(190,140,220,30);
		//uid.setFont(f1);

		//uid.setBackground(Color.orange);
		pnl.add(uid);




		passwordl.setBounds(70,180,100,30);
		passwordl.setFont(f);
		//passwordl.setFont(f);
		passwordl.setOpaque(true);
		// passwordl.setBackground(Color.cyan);
		pnl.add(passwordl);

		password.setBounds(190,180,220,30);
		//password.setFont(f1);

		//uid.setBackground(Color.orange);
		pnl.add(password);


		login.setBounds(90, 230, 80, 30);
		//login.setFont(f2);
		login.setToolTipText("Press only after filling above.");
		pnl.add(login);

		fPassword.setBounds(200, 230, 170, 30);
		//fPassword.setFont(f2);
		fPassword.setToolTipText("Secret service");
		pnl.add(fPassword);

		repaint();

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				adminlogin();

			}
		});

		fPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new F_Process();
			}
		});
		
		
		
		
		setResizable(false);
		setLocation(700, 200);
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
		 repaint();

	}

	void adminlogin()
	{
		char[] s=password.getPassword();
		String ss=new String(s);
		String u=uid.getText();
		try {
			pst=con.prepareStatement("select * from admin where user_id=? and password=?");
			pst.setString(1, u);
			pst.setString(2,ss);

			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{


				JOptionPane.showMessageDialog(null, "Signed In as "+uid.getText());
				new adminControl(u);
			}

			else
				{JOptionPane.showMessageDialog(null, "Wrong username/password entered");
				new login();
				}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connect the Database");
		}




	}


}






public class adminLogin {

	public static void main(String[] args) 
	{
		new login();


	}

}
