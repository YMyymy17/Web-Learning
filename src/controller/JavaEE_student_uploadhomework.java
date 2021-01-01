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

import dao.JavaeeDao;
import dao.javaee_stuhomeworkDao;
import entity.JavaEE;
import entity.javaee_student_homework;
@WebServlet("/javaee_stu_uphomework.action")
public class JavaEE_student_uploadhomework extends HttpServlet {
	javaee_stuhomeworkDao j_hdao=new javaee_stuhomeworkDao();
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
            String testparam=su.getRequest().getParameter("TEST");//接收Form中普通的参数
            System.out.println(testparam);
			// 逐一提取上传文件信息，同时可保存文件。
			for (int i = 0; i < su.getFiles().getCount(); i++) {
				com.jspsmart.upload.File file = su.getFiles().getFile(i);
				// 若文件不存在则继续
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
				javaee_student_homework j=new javaee_student_homework(sid,zjid,path1,null);
				j_hdao.add(j);
				response.sendRedirect("JavaEE_student.action?opttype=queryall");
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