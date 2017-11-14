package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Delete_student {
		
	Connection conn;
	
	PreparedStatement st;
	
	String preparesql = "delete from oldstudent where number = ";
	public boolean delstudent(String studentid){
		
		String sql1 = "delete from student_class where studentid = "+"'"+studentid+"'";
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		if(conn!=null){
			
			try {
				
				String sql = preparesql + "'"+studentid+"'";
				
				st  =  conn.prepareStatement(sql);
				
				st.executeUpdate();
				
				st = conn.prepareStatement(sql1);
				
				st.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
					
				e.printStackTrace();
			}
			
			
		}
		return false;
	}
}
