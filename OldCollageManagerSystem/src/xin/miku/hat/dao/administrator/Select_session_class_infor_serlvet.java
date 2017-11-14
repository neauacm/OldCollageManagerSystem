package xin.miku.hat.dao.administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.classbean.Sessionclassbean;
import xin.miku.hat.studentbean.Studentclassbean;

public class Select_session_class_infor_serlvet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	ResultSet rs;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sessionid = request.getParameter("sessionid");
		
		Select_session_class_infor selectsessionclass = new Select_session_class_infor();
		
		rs = selectsessionclass.selectsessionclass(sessionid);
		
		List sessionclasslist = new ArrayList<Sessionclassbean>();
		
		if(rs!=null)//ѡ�ν����ѯ�ɹ������ص�ǰ����ʾ
		{
			try {
				
				while(rs.next()){
					
					Sessionclassbean sessionclass = new Sessionclassbean();
					
					sessionclass.setClassid(rs.getString("classid"));//��ȡ������е���ֵ����Bean��
					
					sessionclass.setClassname(rs.getString("classname"));
					
					sessionclasslist.add(sessionclass);
					
				}
				request.setAttribute("sessionclasslist",sessionclasslist);
				
				request.getRequestDispatcher("Sessionclassinfor.jsp").forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
				System.out.println("��ѯѡ�ν��ʧ��~");
				
				response.sendRedirect("/OldCollageManagerSystem/fail.jsp"); 
			}
	
	}

}