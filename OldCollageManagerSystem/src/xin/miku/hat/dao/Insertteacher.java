package xin.miku.hat.dao;
import java.beans.Statement;
import java.sql.*;

import xin.miku.hat.teacherbean.Teacherbean;
public class Insertteacher {
	 Connection conn; 
	 PreparedStatement st;
	public boolean inserttoteacher(Teacherbean teacher ){
		String xingming = teacher.getXingming();//教师姓名9
		
		int xingbie = teacher.getXingbie();//教师性别
		
		String id = teacher.getId();//教师身份证号	
		
		String phone = teacher.getPhone();//教师电话
		
		String familyphone = teacher.getFamilyphone();//教师家属电话
		
		String guanxi = teacher.getGuanxi();//家属与本人关系
		
		String xueli = teacher.getXueli();//教师学历
		
		String number = teacher.getNumber();//新添加的教师编号
		
		String zhicheng =teacher.getZhicheng();//教师职称
		
		String zhengzhimianmao = teacher.getZhengzhimianmao();//教师政治面貌
		
		Getconnection getconnection = new Getconnection();
		conn = getconnection.myconnection();
		String sql="insert into oldteacher(xingming,xingbie,id,phone,familyphone,guanxi,xueli,zhicheng,zhengzhimianmao,number) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		if(conn!=null){
		
			try {
				st  = conn.prepareStatement(sql);//预处理命令
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				st.setString(1, xingming);//插入数据
				
				st.setInt(2, xingbie);
				
				st.setString(3, id);
				
				st.setString(4, phone);
				
				st.setString(5, familyphone);
				
				st.setString(6, guanxi);
				
				st.setString(7, xueli);
				
				st.setString(8, zhicheng);
				
				st.setString(9, zhengzhimianmao);
				
				st.setString(10, number);
				
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		try {
			conn.close();//关闭连接和预处理
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		}
		else{
		return false;
		}
	
	}
}
