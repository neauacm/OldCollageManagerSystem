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

public class Get_class_in_studentorder_servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ResultSet rs =null;
		
		String classid = request.getParameter("classid");
		
		Get_class_in_studentorder getclassorder = new Get_class_in_studentorder();
		
		rs = getclassorder.get_order(classid);
		
		List studentidlist = new ArrayList<Studentbean>();
		
		if(rs!=null){
			try {
				
				while(rs.next()){
					
					Studentbean student = new Studentbean();
					
					String studentid = rs.getString("studentid");
					
					student.setNumber(studentid);
					
					studentidlist.add(student);
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			request.setAttribute("studentidlist",studentidlist);
			
			request.getRequestDispatcher("student_class_inorder.jsp").forward(request, response);
		}
		else{
			
			//获取结果失败
		
		}
		
	}

}
