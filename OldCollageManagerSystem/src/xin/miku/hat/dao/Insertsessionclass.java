package xin.miku.hat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xin.miku.hat.classbean.Classbean;
import xin.miku.hat.classbean.Sessionclassbean;

public class Insertsessionclass {
	
	Connection conn;
	
	PreparedStatement st;
	
	public boolean addclass(Classbean sessionclass,String sessionid){
		
		String classid = sessionclass.getClassid();
		
		String classname = sessionclass.getClassname();
		
		String teacherid = sessionclass.getTeacherid();
		
		String time = sessionclass.getTime();
		
		int xueshi = sessionclass.getXueshi();
		
		String jiaoshi  =sessionclass.getJiaoshi();
		
		
		String sql = "insert into "+sessionid+"class"+"(classname,classid,teacherid,xueshi,time,jiaoshi)"+"values(?,?,?,?,?,?)";
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		if(conn!=null){
			try {
				st = conn.prepareStatement(sql);
				
				st.setString(1,classname);
				
				st.setString(2,classid);
				
				st.setString(3,teacherid);
				
				st.setInt(4,xueshi);
				
				st.setString(5,time);
				
				st.setString(6, jiaoshi);
				
				st.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
				return false;
			}
			
			return true;
		}
	
		return false;
	}
}
