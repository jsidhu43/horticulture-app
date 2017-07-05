package forms;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;







class assign_Insectiside
{

	JLabel farmer_id,vfarmer_id;
	JLabel cond1=new JLabel("*This form is generated under the guidlines ," +"\n"+
			"Issued by the Horticulture Department of India");
	JLabel cond2=new JLabel("*This form is the soft copy of the hard copy that has been submitted to the respective officers");


	JLabel namel,fatherl,genderl,mobilel,villagel,blockl,districtl,agel; 
	JTextField name,father,mobile,village,block,district,age;
	JRadioButton male=new JRadioButton("Male");
	JRadioButton female=new JRadioButton("Female");
	JFrame fr=new JFrame("BeeHiveForm");

	JLabel bankl,accountl,codel;
	JTextField bank,account,code;
	JCheckBox slip;
	JCheckBox ver1,ver2,ver3;
	JLabel unitl,ratel,tcostl,scostl,subsidyl;
	JTextField unit,rate,tcost,scost,subsidy;
	JPanel pnl1;
	JTextField scost1;
	JComboBox scheme,insectiside,crop;
	JLabel scostl1,schemel,insectisidel,cropl;
	JTextArea assist;
	JScrollPane scroll;
	JButton save;
	String u;
	JLabel err1,err2,err3,err4,err5,err6,err7,err8,err9,err10,err11,err12,err13,err14;
	boolean chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11,chk12,chk13,chk14,chk15,chk16,chk17;
	String regex1="^[a-zA-Z]+(?:\\s+[a-zA-Z]+)*$";
	String regex2="^[789]\\d{9}$";
	String regex3="^(0|[1-9][0-9]*)$";
	String perc="^(100.[0]+|[0]+.[0]+|\\d{1,2}|\\.\\d{1,2}|\\d{1,2}\\.\\d{1,2})$";
	String decimal="[+]?\\d*\\.?\\d+";
	String regex4="^[0-9]?[0-9]{1}$|^100$";
	Connection con;
	PreparedStatement pst;

	assign_Insectiside(String user)
	{
		u=user;
		fr.setLocation(700, 200);
		fr.setResizable(false);
		fr.setLayout(null);
		con=connectMysql.getConnection();

		Font f1=new Font("arial",Font.BOLD,12);
		Font f2=new Font("arial",Font.PLAIN,18);
		Color col = Color.RED;


		farmer_id=new JLabel("Farmer ID :");
		farmer_id.setBounds(855, 95, 100, 30);
		fr.add(farmer_id);

		vfarmer_id=new JLabel();
		vfarmer_id.setBounds(920, 95, 100, 30);
		fr.add(vfarmer_id);
		vfarmer_id.setText(u);

		schemel=new JLabel("Scheme");

		schemel.setBounds(20, 100, 80, 20);
		fr.add(schemel);

		scheme=new JComboBox();
		scheme.setBounds(120, 100, 100,20);
		//scheme.setEditable(true);
		fr.add(scheme);

		scheme.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if((scheme.getSelectedItem()=="Select"))
				{
					chk15=false;


				}
				else
				{
					chk15=true;

				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				scheme();				
			}
		});



		scheme.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				program();

			}
		});


		insectisidel=new JLabel("Insectiside Name");
		insectisidel.setOpaque(true);

		//insectisidel.setBackground(Color.BLUE);
		insectisidel.setBounds(300, 100, 150, 20);
		fr.add(insectisidel);

		insectiside=new JComboBox();
		insectiside.setBounds(450,100,100,20);

		//scheme.setEditable(true);
		fr.add(insectiside);

		insectiside.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				crop();

			}
		});

		insectiside.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if((insectiside.getSelectedItem()=="Select"))
				{
					chk16=false;


				}
				else
				{
					chk16=true;

				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});

		cropl=new JLabel("Crop");

		cropl.setBounds(630, 100, 100, 20);
		fr.add(cropl);

		crop=new JComboBox();
		crop.setBounds(700, 100, 100, 20);
		fr.add(crop);


		crop.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				cost();

			}
		});
		
		crop.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if((crop.getSelectedItem()=="Select"))
				{
					chk17=false;


				}
				else
				{
					chk17=true;

				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});



		cond1.setBounds(10,10,700,20);
		cond1.setOpaque(true);
		cond1.setFont(f1);
		//cond1.setBackground(Color.BLUE);
		fr.add(cond1);

		cond2.setBounds(10,30,700,20);
		cond2.setFont(f1);
		cond2.setOpaque(true);
		//cond2.setBackground(Color.BLUE);
		fr.add(cond2);

		JPanel pnl=new JPanel();
		pnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),"Personal Details",TitledBorder.CENTER, TitledBorder.TOP, f1, col));
		pnl.setSize(500,440);
		pnl.setLocation(30,150);
		pnl.setLayout(null);
		//pnl.setBackground(Color.black);
		fr.add(pnl);

		namel=new JLabel("Full Name");
		namel.setOpaque(true);
		//namel.setBackground(Color.BLUE);
		namel.setBounds(50,30,100,20);
		pnl.add(namel);

		name=new JTextField();
		name.setBounds(200,30,120,20);
		pnl.add(name);
		err1=new JLabel();
		err1.setBounds(360, 30, 100, 20);
		pnl.add(err1);

		fatherl=new JLabel("Father's Name");

		fatherl.setOpaque(true);
		//fatherl.setBackground(Color.BLUE);
		fatherl.setBounds(50,60,100,20);
		pnl.add(fatherl);

		father=new JTextField();
		father.setBounds(200,60,120,20);
		pnl.add(father);
		err2=new JLabel();
		err2.setBounds(360, 60, 100, 20);
		pnl.add(err2);
		
		genderl=new JLabel("Gender");

		genderl.setBounds(50,90,100,20);
		pnl.add(genderl);

		ButtonGroup grp=new ButtonGroup();
		grp.add(male);
		grp.add(female);

		male.setBounds(200,90,55,20);

		pnl.add(male);

		female.setBounds(255,90,70,20);

		pnl.add(female);
		err3=new JLabel();
		err3.setBounds(360, 90, 100, 20);
		pnl.add(err3);

		mobilel=new JLabel("Mobile");

		mobilel.setBounds(50,120,100,20);
		pnl.add(mobilel);

		mobile=new JTextField();
		mobile.setBounds(200,120,120,20);
		pnl.add(mobile);
		err4=new JLabel();
		err4.setBounds(360, 120, 100, 20);
		pnl.add(err4);

		agel=new JLabel("Age");
		agel.setBounds(50,150,100,20);
		pnl.add(agel);


		age=new JTextField();
		age.setBounds(200,150,120,20);
		pnl.add(age);
		err5=new JLabel();
		err5.setBounds(360, 150, 100, 20);
		pnl.add(err5);

		villagel=new JLabel("Village");

		villagel.setBounds(50,180,100,20);
		pnl.add(villagel);

		village=new JTextField();
		village.setBounds(200,180,120,20);
		pnl.add(village);
		err6=new JLabel();
		err6.setBounds(360, 180, 100, 20);
		pnl.add(err6);
		
		blockl=new JLabel("Block");

		blockl.setBounds(50,210,100,20);
		pnl.add(blockl);

		block=new JTextField();
		block.setBounds(200,210,120,20);
		pnl.add(block);
		err7=new JLabel();
		err7.setBounds(360, 210, 100, 20);
		pnl.add(err7);


		districtl=new JLabel("District");

		districtl.setBounds(50,240,100,20);
		pnl.add(districtl);

		district=new JTextField();
		district.setBounds(200,240,120,20);
		pnl.add(district);err8=new JLabel();
		err8.setBounds(360, 240, 100, 20);
		pnl.add(err8);

		unitl=new JLabel("No. of Litres");

		unitl.setBounds(50,270,100,20);
		pnl.add(unitl);

		unit=new JTextField("0");
		unit.setBounds(200,270,120,20);
		unit.setFocusable(true);
		unit.requestFocus();
		pnl.add(unit);
		err9=new JLabel();
		err9.setBounds(360, 270, 100, 20);
		pnl.add(err9);


		ratel=new JLabel("Rate/Litre");

		ratel.setBounds(50,300,100,20);
		pnl.add(ratel);

		rate=new JTextField("0");
		rate.setBounds(200,300,120,20);

		pnl.add(rate);
		err10=new JLabel();
		err10.setBounds(360, 300, 100, 20);
		pnl.add(err10);

		subsidyl=new JLabel("Subsidy (%)");

		subsidyl.setBounds(50,330,100,20);
		pnl.add(subsidyl);

		subsidy=new JTextField("0");
		subsidy.setBounds(200,330,120,20);

		pnl.add(subsidy);
		err11=new JLabel();
		err11.setBounds(360, 330, 100, 20);
		pnl.add(err11);


		tcostl=new JLabel("Total Cost");
		tcostl.setBounds(40,370,100,20);
		pnl.add(tcostl);

		tcost=new JTextField();
		tcost.setBounds(30,400,80,20);
		pnl.add(tcost);



		scostl=new JLabel("Farmer's Share");
		scostl.setBounds(140,370,100,20);
		pnl.add(scostl);



		scost=new JTextField();
		scost.setBounds(140,400,80,20);
		pnl.add(scost);

		scostl1=new JLabel("Govt.'s Share");
		scostl1.setBounds(252,370,120,20);
		pnl.add(scostl1);

		scost1=new JTextField();
		scost1.setBounds(250,400,80,20);
		pnl.add(scost1);


		/*		tcost.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				  int x,y;
				    x=Integer.parseInt(rate.getText());
				    y=Integer.parseInt(unit.getText());

					tcost.setText(""+x*y);	

			}
		});
		 */

		subsidy.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {

				if(subsidy.getText().matches(perc))
				{
					err11.setText("");
					chk11=true;
					Double x,y,z,subs;
					x=Double.parseDouble(rate.getText());
					y=Double.parseDouble(unit.getText());
					subs=Double.parseDouble(subsidy.getText());
					z=x*y*(1-(subs/100));

					scost1.setText(""+x*y*subs/100);
					tcost.setText(""+x*y);
					scost.setText(""+z);
				}

				else{
					err11.setText("Invalid Subsidy!");
					chk11=false;
				}




			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}


		});


		rate.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if(rate.getText().matches(decimal))
				{
					err10.setText("");
					chk10=true;
					Double x,y,z = null,subs;
					x=Double.parseDouble(rate.getText());
					y=Double.parseDouble(unit.getText());
					tcost.setText(""+x*y);
					scost.setText(""+x*y);
				}

				else{
					err10.setText("Invalid Rate!");
					chk10=false;
				}


			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}


		});



		save=new JButton("Save");
		save.setBounds(480,605,100,30);
		fr.add(save);
		save.setVisible(false);


		pnl1=new JPanel();
		pnl1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),"Bank Details",TitledBorder.CENTER, TitledBorder.TOP, f1, col));

		pnl1.setBounds(540,150,430,160);
		pnl1.setLayout(null);
		//pnl.setBackground(Color.black);
		fr.add(pnl1);

		bankl=new JLabel("Bank Name");

		bankl.setBounds(30,30,100,20);
		pnl1.add(bankl);

		bank=new JTextField();
		bank.setBounds(140,30,150,20);
		pnl1.add(bank);
		err12=new JLabel();
		err12.setBounds(310, 30, 100, 20);
		pnl1.add(err12);

		accountl=new JLabel("A/C No.");

		accountl.setBounds(30,60,100,20);
		pnl1.add(accountl);

		account=new JTextField();
		account.setBounds(140,60,150,20);
		pnl1.add(account);
		err13=new JLabel();
		err13.setBounds(310, 60, 100, 20);
		pnl1.add(err13);

		codel=new JLabel("Bank IFSC");

		codel.setBounds(30,90,100,20);
		pnl1.add(codel);

		code=new JTextField();
		code.setBounds(140,90,150,20);
		pnl1.add(code);
		err14=new JLabel();
		err14.setBounds(310, 90, 100, 20);
		pnl1.add(err14);

		slip=new JCheckBox("PhotoCopy Of the Bank PassBook has been provided");
		slip.setBounds(30,120,330,20);
		//slip.setBackground(Color.red);
		pnl1.add(slip);





		//fr.add(assist);
		assist=new JTextArea();
		//assist.setBounds(600, 750, 300, 150);
		scroll = new JScrollPane(assist);
		scroll.setBounds(540, 470, 430, 118);
		assist.setFont(f2);
		assist.setEditable(false);
		//scroll.add(assist);
		//scroll.setEnabled(true);
		//fr.add(scroll);
		fr.add(scroll);



		JPanel pnl2=new JPanel();
		pnl2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),"Verifications",TitledBorder.CENTER, TitledBorder.TOP, f1, col));
		pnl2.setBounds(540,320,430,135);
		pnl2.setLayout(null);
		//pnl.setBackground(Color.black);
		fr.add(pnl2);

		ver1=new JCheckBox("Village Sarpanch/Nambardar");
		ver1.setBounds(30,30,200,20);

		pnl2.add(ver1);

		ver2=new JCheckBox("Village Patwari");
		ver2.setBounds(30,60,130,20);

		pnl2.add(ver2);

		ver3=new JCheckBox("District Horticulture Officer");
		ver3.setBounds(30,90,200,20);

		pnl2.add(ver3);


		ver1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((ver1.isSelected())&&(ver2.isSelected())&&(ver3.isSelected()&&(slip.isSelected())))
				{
					save.setVisible(true);
				}
				else
				{
					save.setVisible(false);
				}
			}
		});

		ver2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((ver1.isSelected())&&(ver2.isSelected())&&(ver3.isSelected()&&(slip.isSelected())))
				{
					save.setVisible(true);
				}

				else
				{
					save.setVisible(false);
				}
			}
		});

		ver3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((ver1.isSelected())&&(ver2.isSelected())&&(ver3.isSelected()&&(slip.isSelected())))
				{
					save.setVisible(true);
				}else
				{
					save.setVisible(false);
				}
			}
		});

		slip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((ver1.isSelected())&&(ver2.isSelected())&&(ver3.isSelected()&&(slip.isSelected())))
				{
					save.setVisible(true);
				}else
				{
					save.setVisible(false);
				}
			}
		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				


				if((chk1)&&(chk2)&&(chk3)&&(chk4)&&(chk5)&&(chk6)&&(chk7)&&(chk8)&&(chk9)&&(chk10)&&(chk11)&&(chk12)&&(chk13)&&(chk14)&&(chk15)&&(chk16)&&(chk17))
				{
					String aa = null;
					if(male.isSelected())
					{
						aa="male";
					}
					else if(female.isSelected())
					{
						aa="female";
					}


					try {
						save(aa);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}	
				
				else
				{
					JOptionPane.showMessageDialog(null,"Fill Form Correctly");
				}
			}
		});
		
		
		name.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(name.getText().matches(regex1))
				{
					err1.setText("");
					chk1=true;
				}

				else{
					err1.setText("Invalid Name!");
					chk1=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		father.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(father.getText().matches(regex1))
				{
					err2.setText("");
					chk2=true;
				}

				else{
					err2.setText("Invalid Name!");
					chk2=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		
		
		male.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if((male.isSelected())||(female.isSelected()))
				{
					err3.setText("");
					chk3=true;
				}
				else
				{
					err3.setText("Select Gender!");
					chk3=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		
		
		
		
		
		
		
		female.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if((male.isSelected())||(female.isSelected()))
				{
					err3.setText("");
					chk3=true;
				}
				else
				{
					err3.setText("Select Gender!");
					chk3=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		mobile.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(mobile.getText().matches(regex2))
				{
					err4.setText("");
					chk4=true;
				}

				else{
					err4.setText("Invalid Mobile!");
					chk4=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		age.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(age.getText().matches(regex3))
				{
					err5.setText("");
					chk5=true;
				}

				else{
					err5.setText("Invalid Age!");
					chk5=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		village.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(village.getText().matches(regex1))
				{
					err6.setText("");
					chk6=true;
				}

				else{
					err6.setText("Invalid Village!");
					chk6=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		block.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(block.getText().matches(regex1))
				{
					err7.setText("");
					chk7=true;
				}

				else{
					err7.setText("Invalid Block!");
					chk7=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		district.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(district.getText().matches(regex1))
				{
					err8.setText("");
					chk8=true;
				}

				else{
					err8.setText("Invalid District!");
					chk8=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		unit.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(unit.getText().matches(regex3))
				{
					err9.setText("");
					chk9=true;
					Double x,y,z,subs;
					x=Double.parseDouble(rate.getText());
					y=Double.parseDouble(unit.getText());
					subs=Double.parseDouble(subsidy.getText());
					z=x*y*(1-(subs/100));

					scost1.setText(""+x*y*subs/100);
					tcost.setText(""+x*y);
					scost.setText(""+z);
				}

				else{
					err9.setText("Invalid Litres!");
					chk9=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		bank.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(bank.getText().matches(regex1))
				{
					err12.setText("");
					chk12=true;
				}

				else{
					err12.setText("Invalid Name!");
					chk9=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		account.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(account.getText().matches(regex3))
				{
					err13.setText("");
					chk13=true;
				}

				else{
					err13.setText("Invalid A/C No.!");
					chk12=false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		code.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(code.getText().equals(""))
				{
					err14.setText("Invalid IFSC Code!");
					chk14=false;
				}

				else{
					
					err14.setText("");
					chk14=true;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});





		//fr.getContentPane().setBackground(Color.green);
		fr.setSize(1000,700);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




		fr.repaint();

	}


	void scheme()
	{
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

	void program()
	{


		insectiside.removeAllItems();
		String s=(String) scheme.getSelectedItem();
		insectiside.addItem("Select");
		//JOptionPane.showMessageDialog(null, s);
		try {
			pst=con.prepareStatement("select distinct insect_name from insectiside_govt where scheme=?");
			pst.setString(1,s);
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			{
				String se=rs.getString("insect_name");
				insectiside.addItem(se+"");
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
			pst=con.prepareStatement("select crops from insectiside_govt where scheme=? and insect_name=?");
			pst.setObject(1, scheme.getSelectedItem());
			pst.setObject(2,insectiside.getSelectedItem());
			ResultSet rs=pst.executeQuery();
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


	void cost()
	{
		rate.setText("");
		assist.setText("");

		try {
			pst=con.prepareStatement("select * from insectiside_govt where insect_name=? and scheme=? and crops=?");
			pst.setObject(2, scheme.getSelectedItem());
			pst.setObject(1, insectiside.getSelectedItem());
			pst.setObject(3, crop.getSelectedItem());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{String se=rs.getString("cost");
			rate.setText(se);
			assist.setText(rs.getString("assist"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void save(String s) throws SQLException
	{
		pst=con.prepareStatement("insert into insectiside_farmer (farmer_id,farmer_name,father_name,gender,mobile,village,block,district,age,scheme,insectiside_name,crop,total_cost,farmer_share,govt_share,assist,bank_name,account_no,ifsc) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1,vfarmer_id.getText());
		pst.setString(2,name.getText());
		pst.setString(3,father.getText());
		pst.setString(4,s);
		pst.setString(5,mobile.getText());
		pst.setString(6,village.getText());
		pst.setString(7,block.getText());
		pst.setString(8,district.getText());
		pst.setString(9,age.getText());
		pst.setObject(10,scheme.getSelectedItem());

		//------------------------------------------
		pst.setObject(11,insectiside.getSelectedItem());
		pst.setObject(12,crop.getSelectedItem());
		pst.setString(13,tcost.getText());
		pst.setString(14,scost.getText());
		pst.setString(15,scost1.getText());
		pst.setString(16,assist.getText());
		pst.setString(17,bank.getText());
		pst.setString(18,account.getText());
		pst.setString(19,code.getText());

		int x=pst.executeUpdate();
		JOptionPane.showMessageDialog(null,x+" Record Saved");
		pst.close();
	}


}







public class assignInsectiside {


	public static void main(String[] args) 
	{
		new assign_Insectiside(null);

	}

}
