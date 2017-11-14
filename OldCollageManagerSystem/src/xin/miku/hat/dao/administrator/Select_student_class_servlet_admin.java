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

import xin.miku.hat.studentbean.Studentclassbean;


public class Select_student_class_servlet_admin  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	
	ResultSet rs;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String studentid = request.getParameter("studentid");
		
		Select_student_class_infor selectstudentclassinfor = new Select_student_class_infor();
		
		rs = selectstudentclassinfor.getstudentmap(studentid);
		
		List classnametable = new ArrayList<Studentclassbean>();
		if(rs!=null)//选课结果查询成功，返回到前端显示
		{
			try {
				while(rs.next()){
					
					Studentclassbean studentclass = new Studentclassbean();
					
					studentclass.setStudentname(rs.getString("studentid"));//获取结果集中的数值存在Bean中
					
					studentclass.setClassname(rs.getString("classid"));
					
					classnametable.add(studentclass);
					
				}
				request.setAttribute("classnametable",classnametable);
				
				request.getRequestDispatcher("soluctionofstudentclass.jsp").forward(request, response);
			} catch (SQLException e) {
				
				
				e.printStackTrace();
			}
			
		
			
		}
		else System.out.println("查询选课结果失败~");
	
	}

}



