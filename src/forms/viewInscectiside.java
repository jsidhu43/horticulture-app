package forms;



import java.awt.Color;
import java.awt.Font;
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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

class subsidyview_Insectiside
{

	JFrame f=new JFrame("viewInsectiside");
	JLabel schemel=new JLabel("Scheme");
	JLabel namel=new JLabel("Insectiside Name");
	JLabel vegl=new JLabel("Applied on Crop");
	JLabel costl=new JLabel("Cost/litre");
	JLabel assistl=new JLabel("Pattern Of "+"\n"+"Assistance");
	JPanel pnl=new JPanel();
	
	JComboBox scheme=new JComboBox();
	JComboBox name=new JComboBox();
	JComboBox veg=new JComboBox();
	
	DefaultListModel model=new DefaultListModel();
	JList veg1=new JList(model);
	
	
	
	JTextField cost=new JTextField("");
	JTextArea assist=new JTextArea();

	JButton fetch=new JButton("Fetch");
	JButton update=new JButton("Update");
	
	
	Connection con;
	PreparedStatement pst;


	
    
		
		
	subsidyview_Insectiside(final String u)
	{
		
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
				
				new adminControl(u);
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
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
		
		
		
		
		//=-------------------------
		
		
		pnl.setLayout(null);
		pnl.setBounds(30,50,400, 400);
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
		
		
		name.setEditable(true);
		name.setBounds(220,80,150,20);
		pnl.add(name);
		
		
		veg.setEditable(true);
		veg.setBounds(220,130,150,20);
		pnl.add(veg);
		
		
		
		
		fetch.setBounds(450, 80, 70, 20);
		f.add(fetch);
		
		fetch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fetch();
				
			}
		});
		//-----------------------------------

		
		
		scheme.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				view();
				
			}
		});
		
		name.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			show();
				
			}
		});
		
		
		
		//veg.setEditable(true);
		
		veg.setBounds(220,130,150,20);
		pnl.add(veg);
		
		
		  veg.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
			      crop();	
				
			}
		});
		
		
	
		//cost.setEditable(false);
		  cost.setBounds(220,180,150,20);
			pnl.add(cost);
	

		//assist.setEditable(true);
		//assist.setBounds(280,200,275,300);
			assist.setBounds(220,230,150,20);
			pnl.add(assist);
			
			JScrollPane scroll=new JScrollPane(assist);
			scroll.setBounds(220, 230, 150, 150);
			pnl.add(scroll);
	

		
		update.setBounds(190,460,130, 30);
		f.add(update);
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update();			}
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
			pst=con.prepareStatement("select distinct scheme from insectiside_govt");
			ResultSet rs=pst.executeQuery();
			 while(rs.next()==true)
			 {
				String s=rs.getString("scheme");
				scheme.addItem(s+"");
				 
				 
			 }
			
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	void view()
	{   name.removeAllItems();
		String s=(String) scheme.getSelectedItem();
		name.addItem("Select");
		//JOptionPane.showMessageDialog(null, s);
		try {
			pst=con.prepareStatement("select distinct insect_name from insectiside_govt where scheme=?");
			pst.setString(1,s);
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			 {
				 String se=rs.getString("insect_name");
				 name.addItem(se+"");
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
		String s=(String) name.getSelectedItem();
		veg.removeAllItems();  
		try {
			
			pst=con.prepareStatement("select * from insectiside_govt where insect_name=?");
			pst.setString(1,s);
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			 {
				 String se=rs.getString("crops");
				veg.addItem(se+"");
				
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
	
	void crop()
	{
		Object s=veg.getSelectedItem();
		String s1=(String) name.getSelectedItem();
		//veg.removeAllItems();  
		try {
			
			pst=con.prepareStatement("select * from insectiside_govt where crops=? and insect_name=?");
			pst.setObject(1,s);
			pst.setString(2, s1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			 {
				 //String se=rs.getString("crops");
				//veg.addItem(se+"");
				// model.addElement(se+"");
				 String cos=rs.getString("cost");
				 String assis=rs.getString("assist");
				
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
		String v=(String) name.getSelectedItem();
		String s=(String) scheme.getSelectedItem();
		String n=(String) veg.getSelectedItem();
		
		try {
			pst=con.prepareStatement("update insectiside_govt set cost=?,assist=? where insect_name=? and scheme=? and crops=?");
			pst.setString(1,cost.getText());
			pst.setString(2, assist.getText());
			pst.setString(3, v);
			pst.setString(4, s);
			pst.setString(5, n);
			
			 int rs=pst.executeUpdate();
			  if(rs==1){
				 JOptionPane.showMessageDialog(null,"Updated Successfully!");
			  }
			  else
				  JOptionPane.showMessageDialog(null,"Failed to Update!");
			
			  cost.setText("");
				assist.setText("");  
			  
			pst.close();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	

}


public class viewInscectiside {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new 	subsidyview_Insectiside(null);
	}

}
