package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Delete_teacher {
	
	Connection conn;
	
	PreparedStatement st;
	
	String preparesql = "delete from oldteacher where number = ";
	
	public boolean delteacher(String teacherid){
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		if(conn!=null){
			
			try {
				
				String sql = preparesql + teacherid;
				
				st  =  conn.prepareStatement(sql);
				
				st.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
					
				e.printStackTrace();
			}
			
		}
		return false;
	}
}
