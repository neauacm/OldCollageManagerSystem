package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Delete_session {
	
	Connection conn;
	
	PreparedStatement st;
	
	PreparedStatement stdel;
	
	String preparesql = "delete from session where sessionid = ";
	public boolean delsession(String sessionid){
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		if(conn!=null){
			
			try {
				String sessionclass = sessionid+"class";
				
				String sql = preparesql + sessionid ;
				
				String sqldel = "drop table "+sessionclass;
				
				String sql2 = "Truncate Table student_class";
				
				st  =  conn.prepareStatement(sql);
				
				stdel = conn.prepareCall(sqldel);
				
				st.executeUpdate();
				
				stdel.executeUpdate();
				
				st = conn.prepareStatement(sql2);
				
				st.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
					
				e.printStackTrace();
			}
		}
		return false;
	}

}
