package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Select_session {
	
	Connection conn;
	
	PreparedStatement st;
	
	ResultSet rs;
	
	String sql = "select * from session";
	public 	ResultSet selectsession (){
		
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
