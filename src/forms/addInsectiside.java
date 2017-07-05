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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

class subsidy_Insectiside
{

	JFrame f=new JFrame("Add new Insectiside");
	JLabel schemel=new JLabel("Scheme");
	JLabel namel=new JLabel("Insectiside Name");
	JLabel vegl=new JLabel("Applied on Crop");
	JLabel costl=new JLabel("Cost/litre");
	JLabel assistl=new JLabel("Pattern Of "+"\n"+"Assistance");
	JPanel pnl=new JPanel();
	
	JTextField scheme=new JTextField("");
	JTextField name=new JTextField("");
	JTextField veg=new JTextField("");
	JTextField cost=new JTextField("");
	JTextArea assist=new JTextArea();
	JButton save=new JButton("Save");
	
	boolean c1,c2,c3,c4,c5;
	String regex3="^(0|[1-9][0-9]*)$";
	String regex1="^[\\s]*$";
	
	Connection con;
	PreparedStatement pst;
	
	subsidy_Insectiside(final String u)
	{
    
		con=connectMysql.getConnection(); 
		
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		f.setLocation(700, 200);
		

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
		
		
		
		
		
		
		//=-------------------------
		
		pnl.setLayout(null);
		pnl.setBounds(50,50,400, 400);
		pnl.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		f.add(pnl);
		
		
		
		schemel.setOpaque(true);
	    
		schemel.setBounds(50,30,150,30);
		pnl.add(schemel);
		
		namel.setOpaque(true);
	
		namel.setBounds(50,80,150,30);
		pnl.add(namel);
		
		
		vegl.setOpaque(true);
		
		vegl.setBounds(50,130,150,30);
		pnl.add(vegl);
		
		
		costl.setOpaque(true);
		
		costl.setBounds(50,180,150,30);
		pnl.add(costl);
		
		
		assistl.setOpaque(true);
		
		assistl.setBounds(50,230,150,30);
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
		
		
		name.setEditable(true);
		name.setBounds(220,80,150,20);
		pnl.add(name);
		
		name.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			    if(name.getText().equals(""))
			    {
			    	c2=false;
			    	name.setBackground(Color.red);
			    }
			    else
			    	{
			    	c2=true;
			    	name.setBackground(Color.white);
			    	}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		veg.setEditable(true);
		veg.setBounds(220,130,150,20);
		pnl.add(veg);
		
		veg.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			    if(veg.getText().equals(""))
			    {
			    	c3=false;
			    	veg.setBackground(Color.red);
			    }
			    else
			    	{
			    	c3=true;
			    	veg.setBackground(Color.white);
			    	}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//cost.setEditable(false);
		cost.setBounds(220,180,150,20);
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
			    	{c4=false;
			    	cost.setBackground(Color.red);
			    	 JOptionPane.showMessageDialog(null, "Enter numbers only");
			    	}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//assist.setEditable(true);
		assist.setBounds(220,230,150,20);
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
		scroll.setBounds(220, 230, 150, 150);
		pnl.add(scroll);
	
		save.setBounds(190,460,130, 30);
		f.add(save);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(c1&&c2&&c3&&c4&&c5)
				save();
				else
					JOptionPane.showMessageDialog(null, "Fill All Fields");
				
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
			pst=con.prepareStatement("insert into insectiside_govt(record_id,scheme,insect_name,crops,cost,assist) values(?,?,?,?,?,?)");
			
			pst.setInt(1, 0);
			pst.setString(2,scheme.getText());
			pst.setString(3, name.getText());
			pst.setString(4, veg.getText());
			pst.setString(5, cost.getText());
			pst.setString(6, assist.getText());
			
			int x=pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "saved:"+x);
			pst.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}



public class addInsectiside {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new subsidy_Insectiside(null);

	}

}
