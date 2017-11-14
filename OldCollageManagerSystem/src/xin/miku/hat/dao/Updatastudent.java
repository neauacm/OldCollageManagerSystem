package xin.miku.hat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import xin.miku.hat.studentbean.Studentbean;

public class Updatastudent {
	Connection conn;
	PreparedStatement st;
	public boolean deletstudent(Studentbean student){
		Getconnection getconnection = new Getconnection();
		conn = getconnection.myconnection();
		if(conn!=null){
			
			return true;
		}
		else
			return false;
	}
}
