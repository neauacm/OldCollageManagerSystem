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

import xin.miku.hat.sessionbean.Sessionbean;

public class Sessioninfor_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}
	
	ResultSet rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			response.setCharacterEncoding("UTF-8");//设置响应和请求的字符编码
			
			request.setCharacterEncoding("UTF-8");
		
			Select_session select = new Select_session();
			
			List sessionlist = new ArrayList<Sessionbean>();
			
			rs = select.selectsession();
			
			try {
				while(rs.next()){
					
				Sessionbean session = new Sessionbean();
				
				session.setSessionname(rs.getString("sessionname"));
				
				session.setSessionbeginmtime(rs.getString("sessionbegintime"));
				
				session.setSessionendtime(rs.getString("sessionendtime"));
				
				session.setSessiontime(rs.getString("sessiontime"));
				
				session.setSessionid(rs.getString("sessionid"));
				
				session.setSessionclass(rs.getString("sessionclass"));
				
				sessionlist.add(session);
				
				}
				request.setAttribute("sessionlist",sessionlist);
				
				request.getRequestDispatcher("sessioninfor.jsp").forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
	}

}
