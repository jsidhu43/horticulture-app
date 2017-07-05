package forms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

class formaddSubsidy 
{
	JFrame f=new JFrame("Add Project");
	JLabel schemel=new JLabel("Scheme");
	JLabel progl=new JLabel("Programme Name");
	JLabel costl=new JLabel("Estimated Cost");
	JLabel assistl=new JLabel("Pattern Of "+"\n"+"Assistance");
	JPanel pnl=new JPanel();
	
	boolean c1,c2,c3,c4,c5;
	String regex3="^(0|[1-9][0-9]*)$";
	String regex1="^[\\s]*$";
	
	//String[] schemearray={};
	                                                    //NHM-National Horticulture Mission RKVY=Rashtriya Krishi Vikaas Yojana  Atma=Agriculture Tech. Mngt. Agency
	JTextField scheme=new JTextField();
	JTextField prog=new JTextField();
	JTextField cost=new JTextField();
	JTextArea assist=new JTextArea();
	JButton save=new JButton("Save"); // JButton save=new JButton(new ImageIcon("*.jpg")); 
	
	
	Connection con;
	PreparedStatement pst;
	
	formaddSubsidy(final String u)
	
	{
		//f.setUndecorated(true);
		//f.getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG);

		
		
		
		// connecting to mysql 
			con=connectMysql.getConnection();
		
		
		
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocation(700, 200);
		f.setResizable(false);
		f.addWindowListener(new WindowListener() {
			
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
				
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				new adminControl(u);
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		pnl.setLayout(null);
		pnl.setBounds(50,50,400, 400);
		pnl.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		f.add(pnl);
		
		
		
	
		schemel.setOpaque(true);
	    
		schemel.setBounds(50,30,150,30);
		pnl.add(schemel);
		
		
		progl.setOpaque(true);
		
		progl.setBounds(50,80,150,30);
		pnl.add(progl);
		
		
		costl.setOpaque(true);

		costl.setBounds(50,130,150,30);
		pnl.add(costl);
		
		
		assistl.setOpaque(true);         
		
		assistl.setBounds(50,180,150,30);
		pnl.add(assistl);
		
		
		scheme.setEditable(true);              //important
		scheme.setBounds(220,30,150,20);
	
		pnl.add(scheme);
		
scheme.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			    if(scheme.getText().equals(""))
			    {
			    	c1=false;
			    	scheme.setBackground(Color.red);
			    }
			    else
			    	{
			    	c1=true;
			    	scheme.setBackground(Color.white);
			    	}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
		prog.setEditable(true);
		prog.setBounds(220,80,150,20);
		pnl.add(prog);
		
       prog.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			    if(prog.getText().equals(""))
			    {
			    	c2=false;
			    	prog.setBackground(Color.red);
			    }
			    else
			    	{
			    	c2=true;
			    	prog.setBackground(Color.white);
			    	}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		//cost.setEditable(false);
		cost.setBounds(220,130,150,20);
		pnl.add(cost);
		
		
cost.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			    if(cost.getText().matches(regex3))
			    {
			    	c4=true;
			    	cost.setBackground(Color.white);
			    }
			    else
			    	{c4=false;cost.setBackground(Color.red);
			          JOptionPane.showMessageDialog(null, "Enter numbers only");
			    	}
			}
			
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//assist.setEditable(true);
		//assist.setBounds(280,200,275,300);
		   pnl.add(assist);
		
          assist.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			    if(assist.getText().matches(regex1))
			    {
			    	c5=false;
			    	assist.setBackground(Color.red);
			    }
			    else
			    	{
			    	c5=true;
			    	assist.setBackground(Color.white);
			    	}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JScrollPane scroll=new JScrollPane(assist);
		scroll.setBounds(220, 180, 150, 200);
		pnl.add(scroll);
		
		
		
		
		save.setBounds(190,460,130, 30);
	f.add(save);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(c1&&c2&&c4&&c5)
				save();
				else
					JOptionPane.showMessageDialog(null, "Fill All Fields Properly");
			}
		});
		
		f.setLayout(null);
		f.setSize(550,550);
		f.setVisible(true);
		
		f.repaint();
		
	}
	
	void save()
	{
		try {
			pst=con.prepareStatement("insert into subsidy_govt(record_id,scheme,prog_name,cost,assist) values(?,?,?,?,?)");
			pst.setInt(1, 0);
			pst.setString(2,scheme.getText());
			pst.setString(3, prog.getText());
			pst.setString(4, cost.getText());
			pst.setString(5, assist.getText());
			
			int x=pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "saved:"+x);
			pst.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		
		
	}
	

}


public class addSubsidy {

	public static void main(String[] args)
	{
		new formaddSubsidy(null);

	}

}
