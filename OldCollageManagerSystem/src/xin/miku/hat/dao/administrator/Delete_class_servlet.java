package xin.miku.hat.dao.administrator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete_class_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag =false;
		
		String classid = request.getParameter("classid");
		
		String sessionid = request.getParameter("sessionid");
		
		Delete_class delete  = new Delete_class();
		
		flag = delete.delclass(classid,sessionid);
		
		if(flag){
			response.sendRedirect("ok.jsp");
		}
		else {
			response.sendRedirect("fail.jsp");
		}
	}

}
