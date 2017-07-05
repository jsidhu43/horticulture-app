package forms;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class connectMysql
{

	public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agriculture","root","");
		   }
		
		
		
		
		
		
		
		
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
		   	e.printStackTrace();
		   	JOptionPane.showMessageDialog(null, "MySql server might be off.Switch On the Xampp.");
		}
		
		return con;
	}


}