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
		
		response.setCharacterEncoding("UTF-8");//������Ӧ��������ַ�����
		
		request.setCharacterEncoding("UTF-8");
		
		boolean flag = false;
		
		int xingbie = 0;
		
		Insertstudent insertstudent = new Insertstudent();//dao
		
		Studentbean student = new Studentbean();//��ȡһ��student����
		
		student.setXingming(request.getParameter("xingming"));//���û����ύ�����Է�װ��student������
		
		student.setNumber(request.getParameter("number"));//����ӵ�����ѧ��
		
		String gen = request.getParameter("xingbie");
		
		if(gen.equals("man"))
			xingbie=1;
		
		student.setXingbie(xingbie);
		
		student.setId(request.getParameter("id"));
		
		student.setPhone(request.getParameter("phone"));
		
		student.setShenfen(request.getParameter("shenfen"));
		
		student.setFamilyphone(request.getParameter("familyphone"));
		
		student.setGuanxi(request.getParameter("guanxi"));
		
		flag = insertstudent.inserttostudent(student);//���ؽ�student����������ݿ�Ľ��
		
		response.sendRedirect("/OldCollageManagerSystem/success.jsp"); 
	}
}
