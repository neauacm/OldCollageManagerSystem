package xin.miku.hat.dao.administrator;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete_teacher_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			boolean flag =false;
			
			String teacherid = request.getParameter("teacherid");
			
			Delete_teacher delete = new Delete_teacher();
			
			flag = delete.delteacher(teacherid);
			
			System.out.println(flag);
			
			if(flag){
				response.sendRedirect("ok.jsp");
			}
			else {
				response.sendRedirect("fail.jsp");
			}
		
	}

}
