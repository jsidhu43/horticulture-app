package forms;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



class viewInsectisideTable extends JFrame
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String FarmerID;
	JTable table;
	JButton p;
	viewInsectisideTable(String u)
    {
		setLocation(700, 200);
    	FarmerID=u;
    	Font f=new Font("arial",Font.PLAIN,20);
    	setTitle("Assigned Insecticides");
		try {
			
				
		       p=new JButton("print");
		       p.setBounds(5,10, 100, 20);
		       add(p);
		       
		       p.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					 print();	
				}
			});
		    
			
		       setResizable(false);
			
			con=connectMysql.getConnection();
			String sql = "Select farmer_id,farmer_name,father_name,village,scheme,insectiside_name,crop,total_cost,farmer_share,bank_name,doe from insectiside_farmer where farmer_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, FarmerID);
			rs = pstmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement( md.getColumnName(i) );
			}
			//--------------------------------------------------
			Vector<Object> data = new Vector<Object>();
			while (rs.next())
			{
				Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++)
				{
					row.addElement( rs.getObject(i) );
				}
				data.addElement(row);
			}
			rs.close();
			pstmt.close();
			table = new JTable(data,columnNames);
			
			JScrollPane scrollPane = new JScrollPane( table );
			
			table.setSelectionBackground(Color.YELLOW);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.getAutoResizeMode();
			
			table.getAutoscrolls();
			table.setFont(f);
			setLayout(null);
			scrollPane.setBounds(10,40, 1555, 600);
			add( scrollPane );
			setSize(1600,600);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		catch(Exception ex){ex.printStackTrace();}
    	
		
		
		
    
    }
	
	

void print()
{
	try {
	    boolean complete = table.print();
	    if (complete) {
	        /* show a success message  */
	        
	    } else {
	        /*show a message indicating that printing was cancelled */
	        
	    }
	} catch (PrinterException pe) {
	    /* Printing failed, report to the user */
	  
	}	

}
	
	

}


public class viewAssignedInsectisideTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new viewInsectisideTable(null);
	}

}
