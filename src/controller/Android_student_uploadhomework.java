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

import dao.android_stuhomeworkDao;
import entity.android_student_homework;
@WebServlet("/android_stu_uphomework.action")
public class Android_student_uploadhomework extends HttpServlet {
	android_stuhomeworkDao a_hdao=new android_stuhomeworkDao();
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
				System.out.println(path1);
				
				String sid_u=(String)request.getSession().getAttribute("sid_u");
				int sid=Integer.parseInt(sid_u);
				String zjid=(String)request.getSession().getAttribute("zjid_u");
				android_student_homework a=new android_student_homework(sid,zjid,path1,null);
				a_hdao.add(a);
				response.sendRedirect("Android_student.action?opttype=queryall");
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