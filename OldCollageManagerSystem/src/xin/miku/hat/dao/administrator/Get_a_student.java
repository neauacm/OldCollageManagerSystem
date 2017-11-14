package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Get_a_student {
	
	Connection conn;
	
	PreparedStatement st;
	
	ResultSet rs;
	
	String sql = null;
	public 	ResultSet selectstudent (String studentid){
		
		
		sql = "select * from oldstudent where number="+"'"+studentid+"'";
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		if(conn!=null){
			
			try {
				
				
				st = conn.prepareStatement(sql);
				
				rs = st.executeQuery();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return rs;
	
	}
}
