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
		response.setCharacterEncoding("UTF-8");//������Ӧ��������ַ�����
		
		request.setCharacterEncoding("UTF-8");
		
		boolean flag =false;
		//�ӱ���ȡ����
		String sessionname = request.getParameter("sessionname");//ѧ����
		
		String sessionbegintime = request.getParameter("sessionbegintime");//ѧ�ڿ�ʼ ʱ��
		
		String sessionendtime = request.getParameter("sessionendtime");//ѧ�ڽ���ʱ��
		
		String sessiontime = request.getParameter("sessiontime");//ѧʱ
		
		String sessionid = request.getParameter("sessionid");//ѧ��id
		
		String sessionclass = sessionid+"class";
		
		Sessionbean session = new Sessionbean();
		
		//�����ݷ�װ��bean������
		
		session.setSessionname(sessionname);
		
		session.setSessionbeginmtime(sessionbegintime);
		
		session.setSessionendtime(sessionendtime);
		
		session.setSessiontime(sessiontime);
		
		session.setSessionid(sessionid);
		
		session.setSessionclass(sessionclass);
			
		Desginsession desginsession = new Desginsession();
		
		flag = desginsession.mysession(session);//��session�����е���Ϣ�������ݿⲢ����sessionclass TABLE
		
		if(flag){
			response.sendRedirect("ok.jsp");
		}
		else {
			response.sendRedirect("fail.jsp");
		}
		
	}

}
