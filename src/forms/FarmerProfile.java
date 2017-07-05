package forms;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Window;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

class Profile extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JLabel head,uidl,namel,fnamel,gfnamel,
	mobl,haddressl,laddressl,totall,
	khatal,incomel,eqipl,livestkl,chk1,chk2,chk3,chk4,chk5;
	JTextField uidt,namet,fnamet,gfnamet,mobt,totalt,khatat,incomet;
	JTextArea haddresst,laddresst,livestkt,eqipt;
	JPanel field;
	JButton update,fetch,close;
	int count = 0;
	String regex1="^[a-zA-Z]+(?:\\s+[a-zA-Z]+)*$";
	String regex2="^[789]\\d{9}$";
	String regex3="^(0|[1-9][0-9]*)$";
	String User;
	boolean count1,count2,count3,count4,count5;
	JScrollPane sp1,sp2,sp3,sp4;

	Profile(String u)
	{	
		User=u;
		Font f=new Font("Oswald",Font.BOLD,25);
		setResizable(false);
		setLocation(700, 200);
		con=connectMysql.getConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		field = new JPanel();
		field.setLayout(null);
		//field.setBorder(BorderFactory.createTitledBorder(""));
		field.setBounds(50,50,400,600);
		add(field);

		
		head = new JLabel("Farmer Profile");
		head.setBounds(180, 10, 200, 50);
		head.setFont(f);
		add(head);

		uidl = new JLabel("Farmer User ID");
		uidl.setBounds(30, 20, 100, 20);
		field.add(uidl);

		 

		uidt = new JTextField();
		uidt.setBounds(180, 20, 100,20);
		uidt.setText(User);
		field.add(uidt);
		uidt.setEditable(false);
        
		
		
		
		namel = new JLabel("Name");
		namel.setBounds(30, 50, 100, 20);
		field.add(namel);

		namet = new JTextField();
		namet.setBounds(180, 50, 100,20);
		chk1=new JLabel();
		chk1.setBounds(310, 50, 100, 20);
		field.add(chk1);
		field.add(namet);

		fnamel = new JLabel("Father's Name");
		fnamel.setBounds(30, 80, 100, 20);
		field.add(fnamel);

		fnamet = new JTextField();
		fnamet.setBounds(180, 80, 100, 20);
		field.add(fnamet);
		chk2=new JLabel();
		chk2.setBounds(310, 80, 100, 20);
		field.add(chk2);


		gfnamel = new JLabel("Grandfather's Name");
		gfnamel.setBounds(30, 110, 150, 20);
		field.add(gfnamel);

		gfnamet = new JTextField();
		gfnamet.setBounds(180, 110, 100, 20);
		field.add(gfnamet);
		chk3=new JLabel();
		chk3.setBounds(310, 110, 100, 20);
		field.add(chk3);

		mobl = new JLabel("Mobile");
		mobl.setBounds(30, 140, 100, 20);
		field.add(mobl);

		mobt = new JTextField();
		mobt.setBounds(180, 140, 100, 20);
		field.add(mobt);
		chk4=new JLabel();
		chk4.setBounds(290, 140, 100, 20);
		field.add(chk4);

		haddressl = new JLabel("Home Address");
		haddressl.setBounds(30, 170, 100, 20);
		field.add(haddressl);

		haddresst = new JTextArea();
		haddresst.setLineWrap(true);
		sp1=new JScrollPane(haddresst);
		field.add(sp1);
		sp1.setBounds(180, 170, 100, 20);
		sp1.setSize(100, 60);
		haddresst.setSize(100, 60);





		totall = new JLabel("Total Land");
		totall.setBounds(30, 250, 100, 20);
		field.add(totall);

		totalt = new JTextField();
		totalt.setBounds(180, 250, 100, 20);
		field.add(totalt);

		khatal = new JLabel("Khata Number");
		khatal.setBounds(30, 280, 100, 20);
		field.add(khatal);

		khatat = new JTextField();
		khatat.setBounds(180, 280, 100, 20);
		field.add(khatat);

		laddressl = new JLabel("Land Address");
		laddressl.setBounds(30, 310, 100, 20);
		field.add(laddressl);

		laddresst = new JTextArea();
		laddresst.setLineWrap(true);
		sp2=new JScrollPane(laddresst);
		sp2.setBounds(180, 310, 100, 20);
		laddresst.setSize(100, 60);
		sp2.setSize(100, 60);
		field.add(sp2);

		incomel = new JLabel("Income Per Annum");
		incomel.setBounds(30, 390, 150, 20);
		field.add(incomel);


		incomet = new JTextField();
		incomet.setBounds(180, 390, 100, 20);
		field.add(incomet);
		chk5=new JLabel();
		chk5.setBounds(310, 390, 100, 20);
		field.add(chk5);

		eqipl = new JLabel("Agricultural Equipment");

		eqipl.setBounds(30, 430, 150, 20);
		JLabel eqipl2=new JLabel("(if any)");
		eqipl2.setBounds(30, 445, 150, 20);
		field.add(eqipl2);
		field.add(eqipl);

		eqipt = new JTextArea();
		sp3= new JScrollPane(eqipt);
		sp3.setBounds(180, 430, 100, 20);
		eqipt.setSize(100, 60);
		sp3.setSize(100, 60);
		field.add(sp3);

		livestkl = new JLabel("Livestock (if any)");
		livestkl.setBounds(30, 520, 100, 20);
		field.add(livestkl);

		livestkt = new JTextArea();
		sp4=new JScrollPane(livestkt);
		sp4.setBounds(180, 520, 100, 20);
		livestkt.setSize(100, 60);
		sp4.setSize(100, 60);
		field.add(sp4);


		fetch = new JButton("FETCH");
		fetch.setBounds(500,250, 100, 20);
		add(fetch);


		update = new JButton("UPDATE");
		update.setBounds(500,300, 100, 20);
		add(update);


		close = new JButton("CLOSE");
		close.setBounds(500,350, 100, 20);
		add(close);

		setVisible(true);
		setSize(650,700);
		repaint();


		fetch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String s= uidt.getText();
					get(s);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String s= uidt.getText();

					if((count1)&&(count2)&&(count3)&&(count4)&&(count5))
						update(s);
					else
						JOptionPane.showMessageDialog(null, "Insert Correct Values!");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dispose();
			}
		});

		namet.addFocusListener(new FocusListener(
				) {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(namet.getText().matches(regex1))
				{	
					count1=true;
					chk1.setText("");
				}
				else
				{
					chk1.setText("Invalid Name!");
					count1=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		fnamet.addFocusListener(new FocusListener(
				) {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(fnamet.getText().matches(regex1))
				{	
					count2=true;
					chk2.setText("");
				}
				else
				{
					chk2.setText("Invalid Name!");
					count2=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		gfnamet.addFocusListener(new FocusListener(
				) {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(gfnamet.getText().matches(regex1))
				{	
					count3=true;
					chk3.setText("");
				}
				else
				{
					chk3.setText("Invalid Name!");
					count3=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		mobt.addFocusListener(new FocusListener(
				) {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(mobt.getText().matches(regex2))
				{	
					count4=true;
					chk4.setText("");
				}
				else
				{
					chk4.setText("Invalid Mobile No.!");
					count4=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		incomet.addFocusListener(new FocusListener(
				) {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(incomet.getText().matches(regex3))
				{	
					count5=true;
					chk5.setText("");
				}
				else
				{
					chk5.setText("Invalid Income!");
					count5=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		uidt.setText(User);


	}


	void update(String b) throws SQLException
	{	
		pst=con.prepareStatement("update farmers set farmer_name=?, father_name=?, grandfather_name=?,mobile=?,home_address=?,total_land=?, khata_number=?, land_address=?,income=?,equipment=?, livestock=?  where farmer_id=?");
		pst.setString(1,namet.getText());
		pst.setString(2,fnamet.getText());
		pst.setString(3,gfnamet.getText());
		pst.setObject(4,mobt.getText());						
		pst.setString(5,haddresst.getText());
		pst.setString(6,totalt.getText());						
		pst.setString(7,khatat.getText());
		pst.setString(8,laddresst.getText());
		pst.setString(9,incomet.getText());
		pst.setString(10,eqipt.getText());
		pst.setString(11,livestkt.getText());
		pst.setString(12,b);

		int x=pst.executeUpdate();
		JOptionPane.showMessageDialog(null,x+" Record(s) Updated");
		pst.close();
	}


	void get(String u) throws Exception
	{
		int s=0;
		String cnamet="",cfnamet="",cgfnamet="",cmobt="",ctotalt="",ckhatat="",cincomet="",chaddresst="",claddresst="",clivestkt="",ceqipt="";
		pst=con.prepareStatement("select farmer_name, father_name, grandfather_name,mobile,home_address,total_land,khata_number,land_address,income,equipment,livestock from farmers where farmer_id=?");
		pst.setString(1,u);

		ResultSet rs=pst.executeQuery();

		if(rs.next())
		{
			s=1;
			cnamet=rs.getString("farmer_name");
			cfnamet=rs.getString("father_name");
			cgfnamet=rs.getString("grandfather_name");
			cmobt=rs.getString("mobile");
			ctotalt=rs.getString("total_land");	
			ckhatat=rs.getString("khata_number");
			cincomet=rs.getString("income");
			chaddresst=rs.getString("home_address");		
			claddresst=rs.getString("land_address");	
			clivestkt=rs.getString("livestock");
			ceqipt=rs.getString("equipment");


		}


		else
			s=0;

		if(s==1)
		{
			namet.setText(cnamet);
			fnamet.setText(cfnamet);
			gfnamet.setText(cgfnamet);
			mobt.setText(cmobt);
			totalt.setText(ctotalt);	
			khatat.setText(ckhatat);
			incomet.setText(cincomet);
			haddresst.setText(chaddresst);		
			laddresst.setText(claddresst);	
			livestkt.setText(clivestkt);
			eqipt.setText(ceqipt);

		}

		else
			JOptionPane.showMessageDialog(null, "Invalid User ID");

		pst.close();


	}

}
public class FarmerProfile {

	public static void main (String[] args)
	{
		new Profile(null);
	}
}
