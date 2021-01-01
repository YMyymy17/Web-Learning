package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AndroidDao;
import dao.android_stuhomeworkDao;
import entity.Android;
import entity.android_student_homework;

@WebServlet("/Android_student.action")
public class Android_student_Controller extends HttpServlet {
	AndroidDao adao=new AndroidDao();
	android_stuhomeworkDao a_hdao=new android_stuhomeworkDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String opttype=req.getParameter("opttype");
		switch(opttype) {
		
		case "queryall":
			List<Android> clist=adao.allzj();
			req.getSession().setAttribute("clist", clist);
			
			List<android_student_homework> clist1=a_hdao.all();
			req.getSession().setAttribute("clist1", clist1);
			
			resp.sendRedirect("Android_student.jsp");
			break;
		case "uploadhomework":
			String sid_u=req.getParameter("sid");
			req.getSession().setAttribute("sid_u", sid_u);
			
			String zjid_u=req.getParameter("zjid");
			req.getSession().setAttribute("zjid_u", zjid_u);
			
			String zjname_u=req.getParameter("zjname");
			req.getSession().setAttribute("zjname_u", zjname_u);
			
			resp.sendRedirect("Android_student_uphomework.jsp");
			break;
		case "deletehomework":
			String sid=req.getParameter("sid");
			String zjid=req.getParameter("zjid");
			a_hdao.deleteByid(sid, zjid);
			resp.sendRedirect("Android_student.action?opttype=queryall");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
