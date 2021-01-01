 package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.SmartUpload;

import dao.PythonDao;
import entity.Python;
@WebServlet("/python_homework.action")
public class Python_teacher_uploadhomework extends HttpServlet {
	PythonDao pdao=new PythonDao();
	private ServletConfig config;

	/**
	 * Init the servlet
	 */
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	final public ServletConfig getServletConfig() {
		return config;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String hid_u=(String)request.getSession().getAttribute("hid_u");
		
		PrintWriter out = response.getWriter();
		
		// Variables
		int count = 0;
		SmartUpload su = new SmartUpload();

		try {
			// Initialization
			su.initialize(config, request, response);
			su.setAllowedFilesList("doc,txt,pdf,docx");
			// Upload
			su.upload();
            String testparam=su.getRequest().getParameter("TEST");//����Form����ͨ�Ĳ���
            System.out.println(testparam);
			// ��һ��ȡ�ϴ��ļ���Ϣ��ͬʱ�ɱ����ļ���
			for (int i = 0; i < su.getFiles().getCount(); i++) {
				com.jspsmart.upload.File file = su.getFiles().getFile(i);
				// ���ļ������������
				if (file.isMissing())
					continue;
				// file.saveAs("/upload/" + myFile.getFileName());
				file.saveAs("/fileupload/" + file.getFileName(), su.SAVE_VIRTUAL);
				
				String path=request.getServletContext().getRealPath("/")+"fileupload"+("\\");
				String path1=path+file.getFileName();
	
				Python p_homeworkup=pdao.queryzjById(hid_u);
				pdao.updatehomework(p_homeworkup, path1);
				response.sendRedirect("Python_teacher.action?opttype=queryall");
			}

		} catch (Exception e) {
			out.println("Unable to upload the file.<br>");
			out.println("Error : " + e.toString());
		}
	}

	/**
	 * Destroy the servlet
	 */
	public void destroy() {
	}
}