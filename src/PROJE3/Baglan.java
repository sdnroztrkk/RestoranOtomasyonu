package PROJE3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baglan {
	
	public Connection getConnection() throws SQLException 
	 {
	 final String dbUrl="jdbc:mysql://localhost:3306/NESPRO";
	 final String userName="root";
	 final String password="Karatekin123";
	 return DriverManager.getConnection(dbUrl,userName,password);
	 }
	 public void showErrorMessage(SQLException exception)
	 {
	   System.out.println("Error : "+exception.getMessage());
	   System.out.println("Error code : "+exception.getErrorCode());
	 }
	 public static Connection bagkur() throws SQLException {
		  String dbUrl="jdbc:mysql://localhost:3306/NESPRO";
		  String userName="root";
		 String password="Karatekin123";
	        
	        Connection connection = DriverManager.getConnection(dbUrl,userName,password);
	        return connection;
	    }
	 

}