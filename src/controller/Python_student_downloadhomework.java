package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class SmartUploadDownloadServlet
 */
@WebServlet("/python_homework_download.action")
public class Python_student_downloadhomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");	// 获取要下载的文件名
		String downloadPath = "E:\\eclipse\\apache-tomcat-8.5.46\\webapps\\Web-Learning\\fileupload\\"; // 下载路径
		SmartUpload sUpload = new SmartUpload();	// 实例化SmartUpload对象
		sUpload.initialize(getServletConfig(), request, response);	// 初始化SmartUpload对象
		
		sUpload.setContentDisposition(null); // 使用浏览器下载方式
		try {
			sUpload.downloadFile(downloadPath+filename); // 下载文件
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}