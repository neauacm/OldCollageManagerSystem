package xin.miku.hat.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Getconnection {
	
	Connection conn;
	
	public Connection myconnection (){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
		
			
			e.printStackTrace();
			
		}
		
		String url="jdbc:mysql://47.94.201.175:3306/oldcollege?useUnicode=true&characterEncoding=utf-8";
		
		
		String user="root";
		
		
		String password="3b02f2f8d1";
		
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}
