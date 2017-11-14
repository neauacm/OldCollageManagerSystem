package xin.miku.hat.selecter;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.classbean.Classbean;
import xin.miku.hat.classbean.Democlassbean;
import xin.miku.hat.dao.Getconnection;
import xin.miku.hat.dao.selectclassdao.Get_class_name_from_classtable;
import xin.miku.hat.dao.selectclassdao.Get_session_class_infor;



public class Studentselecter extends HttpServlet {
	
	Connection conn;
	
	PreparedStatement st;
	
	ResultSet rs;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			 {
		
					
				  String sessionid = request.getParameter("sessionid");
				  
				  if(sessionid.equals("")){
					  try {
						response.sendRedirect("/OldCollageManagerSystem/fail.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					} 
				  }
				  System.out.println(sessionid);
				  
				  
				  Get_session_class_infor getsessioninfor = new Get_session_class_infor();//获取编号为sessionid的学期的课表
				 
				 
				 rs = getsessioninfor.getsessionclassinfor(sessionid);
				 
				 
				 List<Classbean> classlist = new ArrayList<Classbean>();
				 
				 try {//输出测试结果
					 
					 
					 if( rs != null){
						 while(rs.next()){
							 
							 	Classbean democlass = new Classbean();
							 	
								String classname = rs.getString("classname");
								
								String classid = rs.getString("classid");
								
								String teacherid = rs.getString("teacherid");
								
								String xueshi = rs.getString("xueshi");
							
								String time = rs.getString("time");
								
								String jiaoshi = rs.getString("jiaoshi");
	
								democlass.setClassid(classid);
								
								democlass.setClassname(classname);
								
								classlist.add(democlass);
								
								System.out.println(classname);
								
								System.out.println(classid);
								
								System.out.println(teacherid);
								
								System.out.println(xueshi);
								
								System.out.println(time);
								
								System.out.println(jiaoshi);
								
							}
						 request.setCharacterEncoding("utf-8");
						 
						 response.setCharacterEncoding("utf-8");
						 
						 request.setAttribute("classlist", classlist);
						 
						 request.getRequestDispatcher("selectclass.jsp").forward(request,response);
						 
						 //response.sendRedirect("/OldCollageManagerSystem/selectclass.jsp");
						 
						 return;
					 }
					 else{
						 System.out.println("结果集为空");
					 }
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				 
				 
			 }
}
