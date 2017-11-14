package xin.miku.hat.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.dao.Desginsession;
import xin.miku.hat.sessionbean.Sessionbean;

public class Register_for_session_servlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置响应和请求的字符编码
		
		request.setCharacterEncoding("UTF-8");
		
		boolean flag =false;
		//从表单获取数据
		String sessionname = request.getParameter("sessionname");//学期名
		
		String sessionbegintime = request.getParameter("sessionbegintime");//学期开始 时间
		
		String sessionendtime = request.getParameter("sessionendtime");//学期结束时间
		
		String sessiontime = request.getParameter("sessiontime");//学时
		
		String sessionid = request.getParameter("sessionid");//学期id
		
		String sessionclass = sessionid+"class";
		
		Sessionbean session = new Sessionbean();
		
		//将数据封装进bean对象中
		
		session.setSessionname(sessionname);
		
		session.setSessionbeginmtime(sessionbegintime);
		
		session.setSessionendtime(sessionendtime);
		
		session.setSessiontime(sessiontime);
		
		session.setSessionid(sessionid);
		
		session.setSessionclass(sessionclass);
			
		Desginsession desginsession = new Desginsession();
		
		flag = desginsession.mysession(session);//讲session对象中的信息插入数据库并创建sessionclass TABLE
		
		if(flag){
			response.sendRedirect("ok.jsp");
		}
		else {
			response.sendRedirect("fail.jsp");
		}
		
	}

}
