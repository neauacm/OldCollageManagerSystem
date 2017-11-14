package xin.miku.hat.dao;

import java.beans.Statement;
import java.sql.*;

import xin.miku.hat.sessionbean.Sessionbean;

public class Desginsession {
	Connection conn;
	PreparedStatement st_creatsession;
	PreparedStatement st_createssionclass;
	String sql_creatsessione="insert into session(sessionname,sessionbegintime,sessionendtime,sessiontime,sessionid,sessionclass)" + 
	"values(?,?,?,?,?,?)";
	public boolean mysession (Sessionbean session){
		Getconnection getconnection = new Getconnection();
		
		String name = session.getSessionname();//ѧ����
		
		String begintime = session.getSessionbeginmtime();//ѧ�ڿ�ʼʱ��
		
		String endtime = session.getSessionendtime();//ѧ�ڽ���ʱ��
		
		String time = session.getSessiontime();//ѧʱ
		
		String id = session.getSessionid();//ѧ��id
		
		String sessionclass= session.getSessionclass();//ѧ�ڿα���
		
		conn=getconnection.myconnection(); 
		
		
		String sql_creatsessionclass="create table "+sessionclass+"(classname varchar(32),classid varchar(32),teacherid varchar(32),xueshi varchar(32),time varchar(32),jiaoshi varchar(32))";
		if(conn!=null){
			
			try {
				
				
				
				st_creatsession = conn.prepareStatement(sql_creatsessione);
				
				st_creatsession.setString(1, name);
				
				st_creatsession.setString(2, begintime);
				
				st_creatsession.setString(3, endtime);
				
				st_creatsession.setString(4, time);
				
				st_creatsession.setString(5, id);
				
				st_creatsession.setString(6, sessionclass);
				
				st_createssionclass = conn.prepareStatement(sql_creatsessionclass);
				
				st_creatsession.executeUpdate();
				
				st_createssionclass.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	
}
