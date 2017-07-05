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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class change_Password1 extends JFrame 
{


	Connection con;
	PreparedStatement pst;
	JPasswordField npwd,opwd;
	JTextField user;
	JLabel cross1,tick1;

	change_Password1(final String u)
	{
		con=connectMysql.getConnection();
		Font f=new Font("Oswald",Font.BOLD,22);
		JLabel titl = new JLabel("Password Recovery");
		titl.setFont(f);
		titl.setSize(200,30);
		titl.setLocation(180,60);
		//titl.setAlignmentX();

		//titl.set(Color.BLACK);

		titl.setForeground(Color.BLACK);
		add(titl);

		JLabel uid=new JLabel("Admin ID");
		uid.setSize(100,20);
		uid.setLocation(60,150);
		add(uid);


		user=new JTextField();
		user.setSize(150,20);
		user.setLocation(180,150);
		add(user);
		
		final JLabel tick=new JLabel(new ImageIcon(getClass().getResource("/tick.png")));
		tick.setBounds(350, 150, 20, 20);
    	tick.setVisible(false);
		add(tick);
    	
    	
    	
    	final JLabel cross=new JLabel(new ImageIcon(getClass().getResource("/cross.png")));
		cross.setBounds(350, 150, 20, 20);
		cross.setVisible(false);
		add(cross);
		
		
		
		
		user.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if(user.getText().equals(u))
				{
					tick.setVisible(true);
				}
				else
					cross.setVisible(true);
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tick.setVisible(false);
				cross.setVisible(false);
			}
		});
		
		JLabel opwdl=new JLabel("Old Password");
		opwdl.setSize(100,20);
		opwdl.setLocation(60,200);
		add(opwdl);


		opwd=new JPasswordField();
		opwd.setSize(150,20);
		opwd.setLocation(180,200);
		add(opwd);   
		
		
		tick1=new JLabel(new ImageIcon(getClass().getResource("/tick.png")));
		tick1.setBounds(350, 200, 20, 20);
    	tick1.setVisible(false);
		add(tick1);
    	
    	
    	
    	cross1=new JLabel(new ImageIcon(getClass().getResource("/cross.png")));
    	cross1.setBounds(350, 200, 20, 20);
		cross1.setVisible(false);
		add(cross1);
    	
		
		
		
		

		JLabel npwdl=new JLabel("New Password");
		npwdl.setSize(100,20);
		npwdl.setLocation(60,250);
		add(npwdl);


		npwd=new JPasswordField();
		npwd.setSize(150,20);
		npwd.setLocation(180,250);
		add(npwd);   

		opwd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				check();
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tick1.setVisible(false);
				cross1.setVisible(false);
			}
		});



		//final JButton btn=new JButton("new password");
		// Dimension dm1=btn.getPreferredSize();
		// btn.setBounds(0,190,dm1.width,dm1.height);
		//add(btn);

		JButton btn3=new JButton("Change Password");
		// Dimension dm1=btn.getPreferredSize();
		btn3.setBounds(180,300,150,30);
		add(btn3);

		setLocation(700, 200);
		setResizable(false);
		setLayout(null);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		repaint();



		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				recover();
			}
		});





	}
	
	
	
	
	void check()
	{
		char p[]=opwd.getPassword();
		String ss=new String(p);
		String aa=user.getText();
		
		try 
		{
			pst=con.prepareStatement("select password from admin where user_id=?");
			pst.setString(1, aa);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				String pass=rs.getString("password");
				
				if(pass.equals(ss))
				{
					//JOptionPane.showMessageDialog(null,"Password match");
					tick1.setVisible(true);
				}
				else
					cross1.setVisible(true);
					//JOptionPane.showMessageDialog(null,"Password mismatch");
			}

			else
				JOptionPane.showMessageDialog(null, "Enter admin id");

			pst.close();
		
		
		
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	

	void recover()
	{
		try {

			char p[]=npwd.getPassword();
			String ss=new String(p);
			char o[]=opwd.getPassword();
			String ss1=new String(o);
			
			String aa=user.getText();
			
			if(ss.equals("")&&aa.equals("")&&ss1.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Field cannot be Empty!");
			}
			else
			{
				pst=con.prepareStatement("update admin set password=? where user_id=? and password=?");
				pst.setString(1, ss);
				pst.setString(2, aa);
				pst.setString(3, ss1);

				int rs=pst.executeUpdate();
				if(rs==1)
				{
					JOptionPane.showMessageDialog(null, "Password Changed");
				}
				else
				{
					//JOptionPane.showMessageDialog(null,"Wrong Admin ID/password");
				}
				pst.close();
			}




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class changepwd 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new change_Password1(null);
	}

}
