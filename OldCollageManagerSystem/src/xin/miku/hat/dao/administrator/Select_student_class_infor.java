package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

import java.sql.PreparedStatement;

public class Select_student_class_infor {
	
	Connection conn;
	
	PreparedStatement st;
	
	
	ResultSet rs =  null;
	
	public ResultSet getstudentmap(String studentid){
		
		String sql  ="select * from student_class where studentid ="+"'"+studentid+"'";
		
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
