package xin.miku.hat.dao.insertmaptabledao;

import java.sql.Connection;

import xin.miku.hat.dao.Getconnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class Insert_map_student {
	
	Connection conn;
	
	PreparedStatement st;
	
	String sql="insert into student_class(studentid,classid)"+
	"values(?,?)";
	public void insertmapstudent(String classid[]){
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		if(conn!=null){
			
			String studentname = "77777";
			try {
				
				for(int i=0;i<classid.length;i++){
					
					st = conn.prepareStatement(sql);
					
					st.setString(1, studentname);
					
					st.setString(2, classid[i]);
					
					System.out.println(classid);
				
				}
				
				st.close();
				
				conn.close();
				
			
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
	}
	
	
}
