package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Get_class_in_studentorder {
	
	Connection conn = null;
	
	PreparedStatement st = null;
	
	ResultSet rs = null;
	
	public ResultSet get_order(String classid){
		
		String sql = "select * from student_class where classid = "+classid;
		
		Getconnection getconnection =  new Getconnection();
		
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
