package xin.miku.hat.dao;

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

import xin.miku.hat.dao.administrator.Get_a_student;
import xin.miku.hat.dao.administrator.Select_student_class_infor;
import xin.miku.hat.studentbean.Studentbean;
import xin.miku.hat.studentbean.Studentclassbean;

public class Print_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
	}

	ResultSet rs;
	
	ResultSet rs1;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String studentid = request.getParameter("studentid");
			
			Get_a_student getastudent = new Get_a_student();
			
			Select_student_class_infor selectclassinfor = new Select_student_class_infor();
			
			rs = getastudent.selectstudent(studentid);
			
			rs1 = selectclassinfor.getstudentmap(studentid);
			
			List studentlist = new ArrayList<Studentbean>();
			
			List classnametable = new ArrayList<Studentclassbean>();
			
			try {
				while(rs.next()){
					
					Studentbean student = new Studentbean();
					
					student.setXingming(rs.getString("xingming"));//姓名
					
					String xingbie = rs.getString("xingbie");//性别
					
					int int_xingbie = 0;
					
					if(xingbie.equals("1")){
					 int_xingbie = 1;
						
						student.setXingbie(int_xingbie);
					}
					else 
						student.setXingbie(int_xingbie);
					
					student.setNumber(rs.getString("number"));
					
					student.setId(rs.getString("id"));//身份证号
					
					student.setPhone(rs.getString("phone"));//电话号码
					
					student.setShenfen(	rs.getString("shenfen"));//学员身份
					
					student.setFamilyphone(	rs.getString("familyphone"));//亲属电话
					
					student.setGuanxi(rs.getString("guanxi"));//亲属关系
					
					studentlist.add(student);
				}
				try {
					while(rs1.next()){
						
						Studentclassbean studentclass = new Studentclassbean();
						
						studentclass.setStudentname(rs1.getString("studentid"));//获取结果集中的数值存在Bean中
						
						studentclass.setClassname(rs1.getString("classid"));
						
						classnametable.add(studentclass);
						
					}
					
				} catch (SQLException e) {
					
					
					e.printStackTrace();
				}
				request.setAttribute("studentlist2",studentlist);
				
				request.setAttribute("classnametable2",classnametable);
				
				request.getRequestDispatcher("printf.jsp").forward(request, response);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		
	}

}
