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

import xin.miku.hat.teacherbean.Teacherbean;

public class Teacherinfor_servlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	
	ResultSet rs;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			Select_teacher select = new Select_teacher();
			
			rs = select.selectteacher();
				
			
			
			List teacherlist = new ArrayList<Teacherbean>();
			
			
			
			
			try {
				while(rs.next()){
					
				Teacherbean teacher = new Teacherbean();
				
				
				
				teacher.setXingming(rs.getString("xingming"));//获取姓名	
				
				String xingbie = 	rs.getString("xingbie");//性别	
				
				int int_xingbie = 0;
				if(xingbie.equals("1")){
					
					int_xingbie = 1;
					
					teacher.setXingbie(int_xingbie);
				}
				
				teacher.setId(rs.getString("id"));//身份证号
				
				
				teacher.setPhone(rs.getString("phone"));//电话号
				
				teacher.setFamilyphone(rs.getString("familyphone"));//亲属电话
				
				teacher.setGuanxi(	rs.getString("guanxi"));//亲属关系
				
				teacher.setXueli(rs.getString("xueli"));//学历
				
				teacher.setZhicheng(rs.getString("zhicheng"));//职称
				
				teacher.setZhengzhimianmao(rs.getString("zhengzhimianmao"));//政治面貌
				
				teacherlist.add(teacher);
				
				}
				
				request.setAttribute("teacherlist", teacherlist);
				
				request.getRequestDispatcher("teacherinfor.jsp").forward(request, response);
				
			} catch (SQLException e) {
				
				
				e.printStackTrace();
			
			}
	}

}
