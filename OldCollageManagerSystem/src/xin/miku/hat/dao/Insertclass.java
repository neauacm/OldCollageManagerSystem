package xin.miku.hat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.GET;

import xin.miku.hat.classbean.Classbean;
import xin.miku.hat.classbean.NewclasssessionBean;
import xin.miku.hat.teacherbean.Teacherbean;
			
public class Insertclass {
	
	
	Connection conn;
	PreparedStatement st;
	public boolean inserttoclass(NewclasssessionBean newclasssessionBean){
		
		String classid = newclasssessionBean.getClassid();
		
		String classname = newclasssessionBean.getClassname();
		
		String teacherid = newclasssessionBean.getTeacherid();
		
		String xueshi = newclasssessionBean.getXueshi();
		
		String time = newclasssessionBean.getTime();
		
		String jiaoshi = newclasssessionBean.getJiaoshi();
		
		String sessionid = newclasssessionBean.getSessionid();
		
		String sessionclass = sessionid+"class";
		
		System.out.println(sessionclass);
		
		String sql = "insert into "+sessionclass+" (classname,classid,teacherid,xueshi,time,jiaoshi)"+
		"values(?,?,?,?,?,?)";
		Getconnection getconnection = new Getconnection();
		
		conn=getconnection.myconnection();
		
		if(conn!=null){
			try {
				
				st = conn.prepareStatement(sql);
				
				st.setString(1, classname);
				
				st.setString(2, classid);
				
				st.setString(3, teacherid);
				
				st.setString(4, xueshi);
				
				st.setString(5,time);
				
				st.setString(6,jiaoshi);
				
				st.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
}
