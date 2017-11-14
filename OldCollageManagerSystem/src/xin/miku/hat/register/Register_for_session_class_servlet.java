package xin.miku.hat.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.classbean.Classbean;
import xin.miku.hat.classbean.Sessionclassbean;
import xin.miku.hat.dao.Insertsessionclass;

public class Register_for_session_class_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		String sessionid = request.getParameter("sessionid");
		
		String classid = request.getParameter("classid");
		
		String classname = request.getParameter("classname");
		
		String teacherid = request.getParameter("teacherid");
		
		String xueshi = request.getParameter("xueshi");
		
		String time = request.getParameter("time");
		
		String jiaoshi = request.getParameter("jiaoshi");
		
		Classbean sessionclassbean = new Classbean();
		
		sessionclassbean.setClassid(classid);
		
		sessionclassbean.setClassname(classname);
		
		sessionclassbean.setJiaoshi(jiaoshi);
		
		sessionclassbean.setTime(time);
		
		sessionclassbean.setTeacherid(teacherid);
		
		int a = Integer.parseInt(xueshi);
		
		sessionclassbean.setXueshi(a);
		
		Insertsessionclass insertsessionclass = new Insertsessionclass();
		
		boolean flag = false;
		
		flag = insertsessionclass.addclass(sessionclassbean,sessionid);
		
		if(!flag){
			response.sendRedirect("/OldCollageManagerSystem/fail.jsp"); 
		}
		else 
			response.sendRedirect("/OldCollageManagerSystem/ok.jsp"); 
	}

}
