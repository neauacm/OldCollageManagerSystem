package xin.miku.hat.dao.selectclassdao;

import java.sql.*;

import xin.miku.hat.dao.Getconnection;

public class Get_class_name_from_classtable {
	
	Connection conn;
	PreparedStatement st;
	String classname;
	public String get_name_from_class(String classid){
		
		 Getconnection getconnection = new Getconnection();
		 
		 conn = getconnection.myconnection();//��ȡ����
		 
		 if(conn!=null){//�����Ӳ�Ϊ��ʱ
			 
			 String sql="select classname from class where classid = '?' ";
			 
				 try {
					 
					st=conn.prepareStatement(sql);
					
					st.setString(1, classid);
					
					ResultSet rs = st.executeQuery();
					
					classname = rs.getString(0);
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
					return null;
				
				}
				return classname;
		 }
		 else{
			 return null;
		 }
		
		
		
		
	}
}
