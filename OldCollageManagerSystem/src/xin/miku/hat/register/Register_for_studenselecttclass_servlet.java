package xin.miku.hat.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.dao.Getconnection;
import xin.miku.hat.dao.administrator.Exist_student;
import xin.miku.hat.dao.insertmaptabledao.Insert_map_student;

public class Register_for_studenselecttclass_servlet extends HttpServlet {
	
	Connection conn;
	
	PreparedStatement st;
	
	String sql="insert into student_class(studentid,classid)"+
	"values(?,?)";
	
	String studentid =null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String classid[];
			
			classid = request.getParameterValues("soluction");//获取选课结果，存储于字符串数组中
			
			studentid = request.getParameter("studentid");
			
			boolean flag = false;
			
			Getconnection getconnection = new Getconnection();
				
			conn = getconnection.myconnection();
			
			Exist_student exist = new Exist_student();
			
			flag = exist.get_soluction(studentid);
			
			if(classid!=null){
				
				for(int i=0;i<classid.length;i++){
					
					try {
						
						System.out.println("__________"+classid[i]);
						
						st = conn.prepareStatement(sql);
						
						st.setString(1, studentid);
						
						st.setString(2, classid[i]);
						
						st.executeUpdate();
						
					} catch (SQLException e) {
					
						e.printStackTrace();
						
					}
				}
					try {//关闭连接
						
						st.close();
						
						conn.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
				if(flag==true){
					
					response.sendRedirect("/OldCollageManagerSystem/ok.jsp"); 
					
				}
				else {
					response.sendRedirect("/OldCollageManagerSystem/noexist.jsp"); 
				}
				
					
		
				}
				
			}
	}