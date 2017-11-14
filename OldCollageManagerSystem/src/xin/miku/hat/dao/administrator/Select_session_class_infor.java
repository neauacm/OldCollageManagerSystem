package xin.miku.hat.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jms.Session;

import xin.miku.hat.classbean.Sessionclassbean;
import xin.miku.hat.dao.Getconnection;

public class Select_session_class_infor {
	
	Connection conn;
	
	PreparedStatement st;
	
	ResultSet rs = null;
	public ResultSet selectsessionclass(String sessionid){
		
		
		String sessionclass  = sessionid+"class";
		String sql  = "select * from "+sessionclass;
		
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
