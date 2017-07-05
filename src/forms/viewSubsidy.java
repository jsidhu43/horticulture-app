package forms;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

class formviewSubsidy 
{
	JFrame f=new JFrame("View Project");
	JLabel schemel=new JLabel("Scheme");
	JLabel progl=new JLabel("Programme Name");
	JLabel costl=new JLabel("Estimated Cost");
	JLabel assistl=new JLabel("Pattern Of "+"\n"+"Assistance");
	JPanel pnl=new JPanel();
	
	
	//String[] progarray={"BEE HIVE","POlyhouse"};                                                   //NHM-National Horticulture Mission RKVY=Rashtriya Krishi Vikaas Yojana  Atma=Agriculture Tech. Mngt. Agency
	JComboBox scheme=new JComboBox();
	JComboBox prog=new JComboBox();
	JTextField cost=new JTextField();
	JTextArea assist=new JTextArea();
	// JButton save=new JButton(new ImageIcon("*.jpg")); 
	
	JButton update=new JButton("Update");
	JButton fetch=new JButton("Fetch");
	Connection con;
	PreparedStatement pst;
	
	formviewSubsidy(final String u)
	
	{
		//f.setUndecorated(true);
		//f.getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG);
		  con=connectMysql.getConnection();
		
		f.setLocation(700, 200);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		f.addWindowListener(new WindowListener() {
			
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
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				new adminControl(u);
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		  pnl.setLayout(null);
			pnl.setBounds(30,50,400, 400);
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
		
		
		
		prog.setEditable(true);
		prog.setBounds(220,80,150,20);
		pnl.add(prog);
		
		
		
		//cost.setEditable(false);
		cost.setBounds(220,130,150,20);
		pnl.add(cost);
		
	
		//assist.setEditable(true);
		assist.setBounds(220,180,150,200);
		pnl.add(assist);
		
		JScrollPane scroll=new JScrollPane(assist);
		scroll.setBounds(220, 180, 150, 200);
		pnl.add(scroll);
		
		//view.setFont(f2);
		update.setBounds(190,460,130, 30);
		f.add(update);
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				update();
				
			}
		});
		
		
		fetch.setBounds(450, 80, 70, 20);
		f.add(fetch);
		
fetch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fetch();
				
			}
		});				 
		
		scheme.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
		         view();		
			}
		});
		
		prog.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
			    show();		
			}
		});
		
	
		f.setLayout(null);
		f.setSize(550,550);
		f.setVisible(true);
		f.repaint();
		
	}
	
	void fetch()
	{	
		cost.setText("");
		assist.setText("");
		scheme.removeAllItems();
		scheme.addItem("Select");
		try {
			pst=con.prepareStatement("select distinct scheme from subsidy_govt");
			ResultSet rs=pst.executeQuery();
			 while(rs.next()==true)
			 {
				String s=rs.getString("scheme");
				scheme.addItem(s+"");
				 
				 
			 }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	void view()
	{   prog.removeAllItems();
		String s=(String) scheme.getSelectedItem();
		prog.addItem("Select");
		//JOptionPane.showMessageDialog(null, s);
		try {
			pst=con.prepareStatement("select prog_name from subsidy_govt where scheme=?");
			pst.setString(1,s);
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			 {
				 String se=rs.getString("prog_name");
				 prog.addItem(se+"");
			 }
			/* while(rs.next()==true)
			 {
				 String se=rs.getString("prog_name");
				 String cos=rs.getString("cost");
				 String assis=rs.getString("assist");
				 prog.addItem(se+"");
				 cost.setText(cos);
				 assist.setText(assis);
				 
				 
			 }
			
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void show()
	{
		String s=(String) prog.getSelectedItem();
		
		try {
			pst=con.prepareStatement("select * from subsidy_govt where prog_name=?");
			pst.setString(1,s);
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			 {
				 //String se=rs.getString("prog_name");
				 String cos=rs.getString("cost");
				 String assis=rs.getString("assist");
				 //prog.addItem(se+"");
				 cost.setText(cos);
				 assist.setText(assis);
				 
				 
			 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void update()
	{
		String v=(String) prog.getSelectedItem();
		String s=(String) scheme.getSelectedItem();
		//String n=(String) name.getSelectedItem();
		
		try {
			pst=con.prepareStatement("update subsidy_govt set cost=?,assist=? where prog_name=? and scheme=?");
			pst.setString(1,cost.getText());
			pst.setString(2, assist.getText());
			pst.setString(3, v);
			pst.setString(4, s);
			//pst.setString(5, s);
			
			 int rs=pst.executeUpdate();
			  if(rs==1){
				 JOptionPane.showMessageDialog(null,"Updated Successfully");
			  }
			  else
				  JOptionPane.showMessageDialog(null,"Failed to Update");
			  cost.setText("");
			  assist.setText(""); 
			pst.close();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}


public class viewSubsidy {

	public static void main(String[] args)
	{
		new formviewSubsidy(null);

	}

}
