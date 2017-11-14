package xin.miku.hat.dao;
import java.beans.Statement;
import java.sql.*;

import xin.miku.hat.teacherbean.Teacherbean;
public class Insertteacher {
	 Connection conn; 
	 PreparedStatement st;
	public boolean inserttoteacher(Teacherbean teacher ){
		String xingming = teacher.getXingming();//��ʦ����9
		
		int xingbie = teacher.getXingbie();//��ʦ�Ա�
		
		String id = teacher.getId();//��ʦ���֤��	
		
		String phone = teacher.getPhone();//��ʦ�绰
		
		String familyphone = teacher.getFamilyphone();//��ʦ�����绰
		
		String guanxi = teacher.getGuanxi();//�����뱾�˹�ϵ
		
		String xueli = teacher.getXueli();//��ʦѧ��
		
		String number = teacher.getNumber();//����ӵĽ�ʦ���
		
		String zhicheng =teacher.getZhicheng();//��ʦְ��
		
		String zhengzhimianmao = teacher.getZhengzhimianmao();//��ʦ������ò
		
		Getconnection getconnection = new Getconnection();
		conn = getconnection.myconnection();
		String sql="insert into oldteacher(xingming,xingbie,id,phone,familyphone,guanxi,xueli,zhicheng,zhengzhimianmao,number) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		if(conn!=null){
		
			try {
				st  = conn.prepareStatement(sql);//Ԥ��������
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				st.setString(1, xingming);//��������
				
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
			conn.close();//�ر����Ӻ�Ԥ����
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
