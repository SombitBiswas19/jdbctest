package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnectionOfDatabase {
	public static Connection create_connection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem is in the loading of JDBC Driver.");
		}
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
		} catch (SQLException e) {
			System.out.println("Problem is in establishing connection.");
		}
		
		return connection;
		
	}
}
