package UniversityDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static Connection RetConn() throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		try
		{
		 Class.forName("com.mysql.jdbc.Driver");  
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://www.papademas.net:3306/fp?autoReconnect=true&useSSL=false","dbfp","510");  
		 //System.out.println("Connection Established Success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Connector c1 = new Connector();
		Connector.RetConn();
	}

}
