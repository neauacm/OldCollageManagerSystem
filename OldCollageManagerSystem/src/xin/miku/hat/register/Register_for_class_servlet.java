package xin.miku.hat.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.classbean.Classbean;
import xin.miku.hat.classbean.NewclasssessionBean;
import xin.miku.hat.dao.Insertclass;

public class Register_for_class_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		
		NewclasssessionBean newclasssessionbean = new NewclasssessionBean();
		
		boolean flag =false;
		
		newclasssessionbean.setSessionid(request.getParameter("sessionid"));
		
		newclasssessionbean.setClassid(request.getParameter("classid"));
		
		newclasssessionbean.setClassname(request.getParameter("classname"));
		
		newclasssessionbean.setTeacherid(request.getParameter("teacherid"));
		
		newclasssessionbean.setXueshi(request.getParameter("xueshi"));
		
		newclasssessionbean.setTime(request.getParameter("time"));
		
		newclasssessionbean.setJiaoshi(request.getParameter("jiaoshi"));
		
		Insertclass insertclass =  new Insertclass();
		
		flag = insertclass.inserttoclass(newclasssessionbean);
		
		if(flag){
			response.sendRedirect("ok.jsp");
		}
		else {
			response.sendRedirect("fail.jsp");
		}
	}

}
