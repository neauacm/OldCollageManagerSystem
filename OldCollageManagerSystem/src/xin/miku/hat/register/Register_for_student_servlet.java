package xin.miku.hat.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.dao.Insertstudent;
import xin.miku.hat.studentbean.Studentbean;

public class Register_for_student_servlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");//设置响应和请求的字符编码
		
		request.setCharacterEncoding("UTF-8");
		
		boolean flag = false;
		
		int xingbie = 0;
		
		Insertstudent insertstudent = new Insertstudent();//dao
		
		Studentbean student = new Studentbean();//获取一个student对象
		
		student.setXingming(request.getParameter("xingming"));//将用户所提交的属性封装进student对象中
		
		student.setNumber(request.getParameter("number"));//新添加的属性学号
		
		String gen = request.getParameter("xingbie");
		
		if(gen.equals("man"))
			xingbie=1;
		
		student.setXingbie(xingbie);
		
		student.setId(request.getParameter("id"));
		
		student.setPhone(request.getParameter("phone"));
		
		student.setShenfen(request.getParameter("shenfen"));
		
		student.setFamilyphone(request.getParameter("familyphone"));
		
		student.setGuanxi(request.getParameter("guanxi"));
		
		flag = insertstudent.inserttostudent(student);//返回将student对象插入数据库的结果
		
		response.sendRedirect("/OldCollageManagerSystem/success.jsp"); 
	}
}
