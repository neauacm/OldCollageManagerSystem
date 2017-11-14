package xin.miku.hat.dao.selectclassdao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import xin.miku.hat.dao.Getconnection;

import java.sql.*;
public class Get_session_class_infor {
	
	ResultSet rs;
	
	Connection conn;
	
	PreparedStatement st;
	public ResultSet getsessionclassinfor(String sessionid){
		
		 String class_table_name = sessionid+"class";
		  
		  String sql="select * from"+" "+class_table_name;
		  
		  Getconnection getconnection  = new Getconnection();

		  conn = getconnection.myconnection();
		  
		  if(conn!=null){
			  
			  try {
				  
				st = conn.prepareStatement(sql);
				
				 rs =  st.executeQuery();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			  
		  }
		  else{
			  
			  System.out.println("获取连接时时失败");
			  
		  }
		  
		return rs;
	

	}
}
