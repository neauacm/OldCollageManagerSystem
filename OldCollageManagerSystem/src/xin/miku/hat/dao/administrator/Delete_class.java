package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Delete_class {
	
	Connection conn;
	
	PreparedStatement st;
	
	public boolean delclass(String classid,String sessionid){
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		String sql = "delete from "+sessionid+"class "+" where classid = "+classid;
		
		String sql1 = "delete from student_class where classid ="+classid;
		if(conn!=null){
			
			try {
				
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
