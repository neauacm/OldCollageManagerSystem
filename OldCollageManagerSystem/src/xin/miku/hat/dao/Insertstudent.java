package xin.miku.hat.dao;

import java.sql.*;

import xin.miku.hat.studentbean.Studentbean;

public class Insertstudent {
	Connection conn;
	
	PreparedStatement st;
	
	public boolean inserttostudent(Studentbean student){
		
		Getconnection getconnection = new Getconnection();
		
		conn = getconnection.myconnection();
		
		String xingming = student.getXingming();//����7
		
		int xingbie = student.getXingbie();//�Ա�
		
		String id = student.getId();//���֤��
		
		String number = student.getNumber();//ѧ��
		
		String phone = student.getPhone();//���˵绰
		
		String shenfen = student.getShenfen();//���
		
		String familyphone = student.getFamilyphone();//�����绰
		
		String guanxi = student.getGuanxi();//�뱾�˹�ϵ
		
		String sql="insert into oldstudent(xingming,xingbie,id,phone,shenfen,familyphone,guanxi,number) "
								+ "values(?,?,?,?,?,?,?,?)";
		
		if(conn!=null){
				try {
					
					st = conn.prepareStatement(sql);//Ԥ��������
					
				} catch (SQLException e) {
					
					System.out.println("Ԥ����");
					
					e.printStackTrace();
				}
			try {
				st.setString(1, xingming);//��������
				
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
					conn.close();//�ر����Ӻ�Ԥ����
					
					st.close();//�ر�����
					
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
