package bank;
import java.sql.*;
public class ConnectionFactory {
	Connection con;
	Statement stmt;
	
	public ConnectionFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","Richa");
			stmt=con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
