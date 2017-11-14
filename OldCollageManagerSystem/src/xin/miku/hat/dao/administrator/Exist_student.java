package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

public class Exist_student {
	
	Connection conn = null;
	
	PreparedStatement st;
	
	ResultSet rs = null;
	
	public boolean get_soluction(String studentid){
		
		boolean flag = false;
		
		Getconnection getconnection = new Getconnection();
		
		conn  = getconnection.myconnection();
		
		String sql ="select * from oldstudent where xingming ="+"'"+studentid+"'";
		if(conn!=null){
			
			try {
				
				st = conn.prepareStatement(sql);
				
				rs = st.executeQuery();
				
				
				if(rs!=null) {
					
					while(rs.next()){
						
						String res =rs.getString("number");
						
						if(studentid.equals(res)){
							
							flag = true;
						}
					}
				}
				
			
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("i'm here ~");
			}
			
		}
		
		return flag;
	
	}
}
