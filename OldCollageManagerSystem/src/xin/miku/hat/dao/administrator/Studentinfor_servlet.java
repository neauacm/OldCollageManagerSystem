package xin.miku.hat.dao.administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.studentbean.Studentbean;

public class Studentinfor_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
	}

	ResultSet rs;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Select_student select = new Select_student();
			
			rs = select.selectstudent();
			
			List studentlist = new ArrayList<Studentbean>();
			
			try {
				while(rs.next()){
					
					Studentbean student = new Studentbean();
					
					student.setXingming(rs.getString("xingming"));//����
					
					String xingbie = rs.getString("xingbie");//�Ա�
					
					String number = rs.getString("number");//ѧ��
					
					int int_xingbie = 0;
					
					if(xingbie.equals("1")){
					 int_xingbie = 1;
						
						student.setXingbie(int_xingbie);
					}
					else 
						student.setXingbie(int_xingbie);
					
					student.setId(rs.getString("id"));//���֤��
					
					student.setPhone(rs.getString("phone"));//�绰����
					
					student.setShenfen(	rs.getString("shenfen"));//ѧԱ���
					
					student.setFamilyphone(	rs.getString("familyphone"));//�����绰
					
					student.setGuanxi(rs.getString("guanxi"));//������ϵ
					
					student.setNumber(rs.getString("number"));//ѧ��
					
					studentlist.add(student);
				}
				
				request.setAttribute("studentlist",studentlist);
				
				request.getRequestDispatcher("studentinfor.jsp").forward(request, response);
				//request.getRequestDispatcher("getclassinfor.jsp").forward(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		
	}

}
