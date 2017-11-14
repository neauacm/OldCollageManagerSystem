package xin.miku.hat.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.dao.administrator.Select_class;
import xin.miku.hat.dao.administrator.Select_session;
import xin.miku.hat.dao.administrator.Select_student;
import xin.miku.hat.dao.administrator.Select_teacher;


public class Testservlet extends HttpServlet {
	
	ResultSet rs;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			Select_session select= new Select_session();
			
			System.out.println("lalala~~~");
			
			rs =  select.selectsession();
			
			try {
				while(rs.next()){
					
					 String poi = rs.getString("sessionid");
					 
					 System.out.println(poi);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	private void getString(String string) {
		
	}

}
