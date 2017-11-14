package xin.miku.hat.dao.administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete_session_servlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		
	}
	ResultSet rs;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			boolean flag = false;
		
			String sessionid = request.getParameter("sessionid");
		
			Delete_session delete = new Delete_session();
			
			flag = delete.delsession(sessionid);
			
			System.out.println(flag);
			
			if(flag){
				response.sendRedirect("ok.jsp");
			}
			else {
				response.sendRedirect("fail.jsp");
			}
	}
}
