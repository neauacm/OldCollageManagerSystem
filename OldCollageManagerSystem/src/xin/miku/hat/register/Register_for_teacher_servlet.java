package xin.miku.hat.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.dao.Insertteacher;
import xin.miku.hat.teacherbean.Teacherbean;

public class Register_for_teacher_servlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		
		int xingbie=0;
		
		boolean flag =false;
		
		Teacherbean teacher = new Teacherbean();//����һ��teacher����
		
		teacher.setXingming(request.getParameter("xingming"));//�û��ύ�����Է�װ��teacher������
		
		String gen = request.getParameter("xingbie");
		
		if(gen.equals("man"))
			xingbie = 1;
		
		teacher.setXingbie(xingbie);
		
		teacher.setNumber(request.getParameter("number"));
		
		teacher.setId(request.getParameter("id"));
		
		teacher.setPhone(request.getParameter("phone"));
		
		teacher.setFamilyphone(request.getParameter("familyphone"));
		
		teacher.setGuanxi(request.getParameter("guanxi"));
		
		teacher.setXueli(request.getParameter("xueli"));
		
		teacher.setZhicheng(request.getParameter("zhicheng"));
		
		teacher.setZhengzhimianmao(request.getParameter("zhengzhimianmao"));
		
		Insertteacher insertteacher = new Insertteacher();//dao��teacher������뵽���ݿ���
		
		
		flag = insertteacher.inserttoteacher(teacher);//���ز����Ƿ�ɹ��Ľ��
		
		System.out.println(flag);
		response.sendRedirect("/OldCollageManagerSystem/success.jsp"); 
		
	}
}
