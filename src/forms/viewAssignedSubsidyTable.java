package forms;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;



class viewSubsidyTable extends JFrame
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String FarmerID;
	JButton p;
	
	JTable table ;
	
	
	viewSubsidyTable(String s)
	
	{
		setLocation(700, 200);
		FarmerID=s;
		setTitle("Assigned Projects");
		setResizable(false);

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
		 
		       JButton export = new JButton("Export");
		       export.setBounds(200,10, 100,20);
		       add(export);
		        export.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent evt) {

		                try {
		                    ExcelExporter exp = new ExcelExporter();
		                    exp.fillData(table, new File("H:\\Subsidy_assigned.xls"));
		                    JOptionPane.showMessageDialog(null, "Data saved at " +
		                            "'H: \\ result.xls' successfully", "Message",
		                            JOptionPane.INFORMATION_MESSAGE);
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            }
		        });


		//Read more: http://niravjavadeveloper.blogspot.com/2011/05/java-swing-export-jtable-to-excel-file.html#ixzz4BqN1UMcQ
		
		
		
		
			con=connectMysql.getConnection();
			String sql = "Select farmer_id,farmer_name,father_name,village,scheme,program_name,total_cost,farmer_share,bank_name,doe from subsidy_farmer where farmer_id=?";
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
			//table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar
			table.getAutoResizeMode();
			table.getAutoscrolls();
			setLayout(null);
			scrollPane.setBounds(10,40, 1555, 600);
			add( scrollPane );
			setSize(1600,600);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

public class viewAssignedSubsidyTable //extends viewSubsidyTable
{
	public static void main(String[] args)
	{
		new viewSubsidyTable(null);	 
	}

}
