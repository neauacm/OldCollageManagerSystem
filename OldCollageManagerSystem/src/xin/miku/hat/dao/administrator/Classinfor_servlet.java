package xin.miku.hat.dao.administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.miku.hat.classbean.Classbean;
import xin.miku.hat.teacherbean.Teacherbean;

public class Classinfor_servlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	ResultSet rs=null;
	
	ResultSet teacherrs=null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sessionid = request.getParameter("sessionid");//��ȡѧ�ں���
		
		
		
		Select_class selsect = new  Select_class();
		
		Select_teacher selectteacher = new Select_teacher();
		
		List<Classbean> dateclasslist =new  ArrayList<Classbean>();
		
		List<Teacherbean> dateteacherlist = new ArrayList<Teacherbean>();
		
		rs = selsect.selectclass(sessionid);
		
		teacherrs = selectteacher.selectteacher();
		try {
			
			while(rs.next()){
				
				Classbean Class = new Classbean();  
				
				Class.setClassname(rs.getString("classname"));//�γ���
				
				Class.setClassid(rs.getString("classid"));//�γ�id
				
				Class.setTeacherid(rs.getString("teacherid"));//��ʦid
				
				String xueshi = rs.getString("xueshi");
				
				if(xueshi!=null){
					
					int int_xueshi = Integer.valueOf(xueshi).intValue();
					Class.setXueshi(int_xueshi);//ѧʱ
				}

				Class.setTime(rs.getString("time"));//�Ͽ�ʱ��
				
				Class.setJiaoshi(rs.getString("jiaoshi"));//�Ͽεص�(����)
				
//				String dinger = rs.getString("dinger");
//				if(dinger!=null){
//					
//					int int_dinger = Integer.valueOf(dinger).intValue();
//					
//					Class.setDinger(int_dinger);//����
//				}
				
				dateclasslist.add(Class);
			}//�����ݰ�װ��Bean��
			while(teacherrs.next()){
				
				Teacherbean teacher = new Teacherbean();
				
				String xingming = teacherrs.getString("xingming");
				
				String xingbie = teacherrs.getString("xingbie");
				
				String id = teacherrs.getString("id");
				
				String phone = teacherrs.getString("phone");
				
				String familyphone = teacherrs.getString("familyphone");
				
				String guanxi = teacherrs.getString("guanxi");
				
				String xueli = teacherrs.getString("xueli");
				
				String zhicheng = teacherrs.getString("zhicheng");
				
				String zhengyuanmianmao = teacherrs.getString("zhengzhimianmao");
				
				String number = teacherrs.getString("number");
				
				teacher.setFamilyphone(familyphone);
				
				teacher.setGuanxi(guanxi);
				
				teacher.setId(id);
				
				teacher.setNumber(number);
				
				teacher.setPhone(familyphone);
				
				teacher.setXingming(xingming);
				
				dateteacherlist.add(teacher);
				
			}
			request.setAttribute("dateclasslist", dateclasslist);
			
			request.setAttribute("dateteacherlist", dateteacherlist);
			
			request.getRequestDispatcher("getclassinfor.jsp").forward(request,response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}
