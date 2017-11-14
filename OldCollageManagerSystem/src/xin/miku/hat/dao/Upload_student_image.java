package xin.miku.hat.dao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload_student_image extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;character=utf-8");
		//����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//�õ�FileItem
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			//����
			FileItem fi1 = fileItemList.get(0);
			FileItem fi2 = fileItemList.get(1);
			
			System.out.println("1:" + fi1.getFieldName() + "=" + fi1.getString("utf-8"));
			System.out.println("content-type:" + fi2.getContentType());
			System.out.println("size:" + fi2.getSize());
			System.out.println("file name:" + fi2.getName());
			//����
			File destFile = new File("d:/"+fi1.getString("utf-8") +".jpg");
			fi2.write(destFile);
			response.sendRedirect("/OldCollageManagerSystem/success.jsp"); 
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		//����
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
