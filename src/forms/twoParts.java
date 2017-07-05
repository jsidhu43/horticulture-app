package forms;



import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.print.PrinterException;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;


class showTable extends JFrame
{ 
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	JButton p,subsidy,insect,show_insect,show_subsidy;
	JPanel pnl;
	JLabel schemel,prognamel,namel,cropl;
	JComboBox scheme,progname,name,crop;
	JTable table = new JTable();
	JScrollPane scrollPane = new JScrollPane();

	showTable() throws SQLException
	{ 
		
		setLocation(700, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		con=connectMysql.getConnection();
		pnl=new JPanel();
		pnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),"", TitledBorder.CENTER, TitledBorder.TOP));
		pnl.setBounds(40, 30, 500, 50);
		pnl.setLayout(null);
		add(pnl);

		subsidy= new JButton("Farmers with Subsidies");
		subsidy.setBounds(10, 10, 235, 30);
		pnl.add(subsidy);


		insect= new JButton("Farmers with Insecticides");
		insect.setBounds(255, 10, 235, 30);
		pnl.add(insect);

		schemel=new JLabel("Scheme");

		schemel.setBounds(70, 120, 80, 20);
		add(schemel);
		schemel.setVisible(false);

		
		
		scheme=new JComboBox();
		scheme.setBounds(40, 150, 120,20);
		//scheme.setEditable(true);
		add(scheme);
		scheme.setVisible(false);
		
		


		prognamel=new JLabel("Project Name");
		prognamel.setOpaque(true);
		prognamel.setBounds(240, 120, 120, 20);
		add(prognamel);
		prognamel.setVisible(false);

		progname=new JComboBox();
		progname.setBounds(220,150,150,20);

		//scheme.setEditable(true);
		add(progname);
		progname.setVisible(false);


		namel=new JLabel("Insecticide");
		namel.setOpaque(true);
		namel.setBounds(255, 120, 100, 20);
		add(namel);
		namel.setVisible(false);


		name=new JComboBox();
		name.setBounds(220,150,150,20);

		//scheme.setEditable(true);
		add(name);
		name.setVisible(false);


		cropl=new JLabel("Crop");
		cropl.setOpaque(true);


		cropl.setBounds(460, 120, 100, 20);
		add(cropl);
		cropl.setVisible(false);


		crop=new JComboBox();
		crop.setBounds(410,150,150,20);

		//scheme.setEditable(true);
		add(crop);
		crop.setVisible(false);
		
		show_insect=new JButton("Show Records");
		show_insect.setBounds(120,200,150,30);
		add(show_insect);
		show_insect.setVisible(false);
		
		show_subsidy=new JButton("Show Records");
		show_subsidy.setBounds(120,200,150,30);
		add(show_subsidy);
		show_subsidy.setVisible(false);
		
		 p=new JButton("Print Records");
	     p.setBounds(300,200, 150, 30);
	     add(p);
		
	     p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				print();
			}
		});

		subsidy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				subsidy();
			}
		});
		
		insect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insect();
			}
		});


		

		setLayout(null);
		setResizable(false);
		setSize(600,150);
		setVisible(true);
		repaint();
	}

	void subsidy()
	{
		setSize(600,280);
		show_insect.setVisible(false);
		namel.setVisible(false);
		name.setVisible(false);
		cropl.setVisible(false);
		crop.setVisible(false);
		schemel.setVisible(true);
		scheme.setVisible(true);
		prognamel.setVisible(true);
		progname.setVisible(true);
		show_subsidy.setVisible(true);

		try {
			scheme();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		scheme.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				program();
			}
		});
		show_subsidy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String n=(String)progname.getSelectedItem();
				
				if(n.equals("Select"))
				{
					try {
						subsidy_table1();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						subsidy_table();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
			

	}

	void insect()
	{
		setSize(600,280);
		prognamel.setVisible(false);
		show_subsidy.setVisible(false);
		progname.setVisible(false);
		schemel.setVisible(true);
		scheme.setVisible(true);
		namel.setVisible(true);
		name.setVisible(true);
		cropl.setVisible(true);
		crop.setVisible(true);
		show_insect.setVisible(true);
		
		try {
			scheme1();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		scheme.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				program1();

			}
		});
		
		name.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				crop();

			}
		});
		
		show_insect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String c=(String)crop.getSelectedItem();
				String n=(String)name.getSelectedItem();
				if(c.equals("Select")&&(n.equals("Select")))
				{
					try {
						insect_table2();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else if(c.equals("Select"))
				{
					try {
						insect_table1();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else
				{
					try {
						insect_table();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
	
		
	}

	void scheme() throws SQLException
	{
		scheme.removeAllItems();
		scheme.addItem("Select");

		pstmt=con.prepareStatement("select distinct scheme from subsidy_govt");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()==true)
		{
			String s=rs.getString("scheme");
			scheme.addItem(s+"");


		}
	}
	
	void scheme1() throws SQLException
	{
		scheme.removeAllItems();
		scheme.addItem("Select");

		pstmt=con.prepareStatement("select distinct scheme from insectiside_govt");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()==true)
		{
			String s=rs.getString("scheme");
			scheme.addItem(s+"");


		}
	}

	void program()
	{


		progname.removeAllItems();
		String s=(String) scheme.getSelectedItem();
		progname.addItem("Select");
		//JOptionPane.showMessageDialog(null, s);
		try {
			pstmt=con.prepareStatement("select prog_name from subsidy_govt where scheme=?");
			pstmt.setString(1,s);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()==true)
			{
				String se=rs.getString("prog_name");
				progname.addItem(se+"");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void program1()
	{


		name.removeAllItems();
		String s=(String) scheme.getSelectedItem();
		name.addItem("Select");
		//JOptionPane.showMessageDialog(null, s);
		try {
			pstmt=con.prepareStatement("select distinct insect_name from insectiside_govt where scheme=?");
			pstmt.setString(1,s);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()==true)
			{
				String se=rs.getString("insect_name");
				name.addItem(se+"");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void crop()
	{

		crop.removeAllItems();
		crop.addItem("Select");

		try {
			pstmt=con.prepareStatement("select crops from insectiside_govt where scheme=? and insect_name=?");
			pstmt.setObject(1, scheme.getSelectedItem());
			pstmt.setObject(2,name.getSelectedItem());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				String se=rs.getString("crops");
				crop.addItem(se+"");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	void insect_table() throws SQLException
	{	
		setSize(600,500);
		String sql = "Select record_id,farmer_id,farmer_name,mobile from insectiside_farmer where scheme=? and insectiside_name=? and crop=? order by farmer_name";
		
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setObject(1, scheme.getSelectedItem());
		pstmt.setObject(2, name.getSelectedItem());
		pstmt.setObject(3, crop.getSelectedItem());
		
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
		
		show_table(data,columnNames);
		
	}
	
	void insect_table1() throws SQLException
	{	
		setSize(600,500);
	
		String sql = "Select record_id,farmer_id,farmer_name,mobile from insectiside_farmer where scheme=? and insectiside_name=? order by farmer_name";
		
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setObject(1, scheme.getSelectedItem());
		pstmt.setObject(2, name.getSelectedItem());
		
		
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
		show_table(data,columnNames);
		
	
	}
	
	void insect_table2() throws SQLException
	{	
		setSize(600,500);
		String sql = "Select record_id,farmer_id, farmer_name, mobile from insectiside_farmer where scheme=? order by farmer_name";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setObject(1,scheme.getSelectedItem());
		
		
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
		show_table(data,columnNames);
		
	
	}
	
	void subsidy_table() throws SQLException
	{	
		setSize(600,500);
		String sql = "Select record_id,farmer_id,farmer_name,mobile from subsidy_farmer where scheme=? and program_name=? order by farmer_name";
		
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setObject(1, scheme.getSelectedItem());
		pstmt.setObject(2, progname.getSelectedItem());
		
		
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
		
		show_table(data,columnNames);
		
	}
	
	void subsidy_table1() throws SQLException
	{	
		setSize(600,500);
		String sql = "Select record_id,farmer_id,farmer_name,mobile from subsidy_farmer where scheme=? order by farmer_name";
		
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setObject(1, scheme.getSelectedItem());
		
		
		
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
		
		show_table(data,columnNames);
		
	}
	
	void show_table(Vector<Object> data,Vector<String> columnNames)
	
	{	scrollPane.setVisible(false);
		table = new JTable(data,columnNames);
		scrollPane= new JScrollPane( table );
		//table.setSelectionBackground(Color.yellow);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar
	     
		
		
		
		
		table.setSelectionBackground(Color.YELLOW);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getAutoResizeMode();
		table.setEnabled(false);
		table.getAutoscrolls();
		//table.setFont(f);
		setLayout(null);
		
		
		scrollPane.setBounds(40, 300, 500, 100);
		add(scrollPane);
		
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

public class twoParts {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new showTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
