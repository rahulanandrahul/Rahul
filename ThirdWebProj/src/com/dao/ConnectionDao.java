package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

	
	Connection connection=null;
	
	public Connection getConn() {
		
		Connection connection = null;
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName = sample;integratedSecurity=true");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return connection;
		
		
	}
	
	
}
