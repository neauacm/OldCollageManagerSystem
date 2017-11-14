package xin.miku.hat.dao;

import java.sql.*;

import xin.miku.hat.studentbean.Studentbean;

public class Insertstudent {
	Connection conn;
	
	PreparedStatement st;
	
	public boolean inserttostudent(Studentbean student){
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		String xingming = student.getXingming();//姓名7
		
		int xingbie = student.getXingbie();//性别
		
		String id = student.getId();//身份证号
		
		String number = student.getNumber();//学号
		
		String phone = student.getPhone();//本人电话
		
		String shenfen = student.getShenfen();//身份
		
		String familyphone = student.getFamilyphone();//家属电话
		
		String guanxi = student.getGuanxi();//与本人关系
		
		String sql="insert into oldstudent(xingming,xingbie,id,phone,shenfen,familyphone,guanxi,number) "
								+ "values(?,?,?,?,?,?,?,?)";
		
		if(conn!=null){
				try {
					
					st = conn.prepareStatement(sql);//预处理命令
					
				} catch (SQLException e) {
					
					System.out.println("预处理");
					
					e.printStackTrace();
				}
			try {
				st.setString(1, xingming);//插入数据
				
				st.setInt(2, xingbie);
				
				st.setString(3, id);
				
				st.setString(4, phone);
				
				st.setString(5, shenfen);
				
				st.setString(6, familyphone);
				
				st.setString(7, guanxi);
				
				st.setString(8,number);
				
				st.executeUpdate();
				
			} catch (SQLException e) {
				
				
				e.printStackTrace();
				
			}finally{
				
				try {
					conn.close();//关闭连接和预处理
					
					st.close();//关闭连接
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			return true;	
		}
		else{
			return false;
		}
	}
}
