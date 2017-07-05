package forms;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class aboutUs extends JFrame
{
	JLabel label,fb;
	
	
	
	aboutUs()
	{
		Font f=new Font("Oswald",Font.BOLD,18);
		 label=new JLabel("<html>Copyright© 2015 Hoticulture DeskApp to present" +
				 "<br>This Application is not intended for Public Use.Kindly get Proper Licence and Agreement from the owner to avoid any disputes or legal actions."+
		 		"<br><br>Developed by:<br>Jasminderpal Singh Sidhu" +
		 		"<br>B.E. Computer Science"+
		 		"<br>Thapar University,Patiala" +
		 		
		 		"<br><br>Under Guidance of:<br>Mr. Rajesh K. Bansal" +
		 		"<br>Sun Certified Java Programmer<br>Banglore Computer Education,Bathinda" +
		 		"<br><br>For any type of query,Contact me: " +
		 		"<br>Jasminderpal Singh Sidhu " +
		 		"<br>Mobile: +9194780-37040 " +
		 		"<br>Email: jammy.sidhu43@gmail.com " +
		 		"<br>Facebook: <a href=\"https://www.facebook.com/jammy.sidhu.14\" target=\"_blank\">https://www.facebook.com/jammy.sidhu.14</a>"+
		 		"</html>");
		 label.setFont(f);
		 label.setEnabled(true);
         label.setBounds(5,-40,600,600);
         add(label);
         
         
         
         
         
         setResizable(false);
		setLayout(null);
		setSize(600, 600);
		setVisible(true);
		
		
		
		
		
		
	}

	public static void main(String[] args) 
	{
		new aboutUs();
	}

}
