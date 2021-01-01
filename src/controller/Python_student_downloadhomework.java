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
		String filename = request.getParameter("filename");	// ��ȡҪ���ص��ļ���
		String downloadPath = "E:\\eclipse\\apache-tomcat-8.5.46\\webapps\\Web-Learning\\fileupload\\"; // ����·��
		SmartUpload sUpload = new SmartUpload();	// ʵ����SmartUpload����
		sUpload.initialize(getServletConfig(), request, response);	// ��ʼ��SmartUpload����
		
		sUpload.setContentDisposition(null); // ʹ����������ط�ʽ
		try {
			sUpload.downloadFile(downloadPath+filename); // �����ļ�
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}