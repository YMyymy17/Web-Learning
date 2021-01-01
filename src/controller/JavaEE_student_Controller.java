package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JavaeeDao;
import dao.javaee_stuhomeworkDao;
import entity.JavaEE;
import entity.javaee_student_homework;

@WebServlet("/JavaEE_student.action")
public class JavaEE_student_Controller extends HttpServlet {
	JavaeeDao jdao=new JavaeeDao();
	javaee_stuhomeworkDao j_hdao=new javaee_stuhomeworkDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String opttype=req.getParameter("opttype");
		switch(opttype) {
		
		case "queryall":
			List<JavaEE> clist=jdao.allzj();
			req.getSession().setAttribute("clist", clist);
			
			List<javaee_student_homework> clist1=j_hdao.all();
			req.getSession().setAttribute("clist1", clist1);
			
			resp.sendRedirect("JavaEE_student.jsp");
			break;
		case "uploadhomework":
			String sid_u=req.getParameter("sid");
			req.getSession().setAttribute("sid_u", sid_u);
			
			String zjid_u=req.getParameter("zjid");
			req.getSession().setAttribute("zjid_u", zjid_u);
			
			String zjname_u=req.getParameter("zjname");
			req.getSession().setAttribute("zjname_u", zjname_u);
			
			resp.sendRedirect("JavaEE_student_uphomework.jsp");
			break;
		case "deletehomework":
			String sid=req.getParameter("sid");
			String zjid=req.getParameter("zjid");
			j_hdao.deleteByid(sid, zjid);
			resp.sendRedirect("JavaEE_student.action?opttype=queryall");
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
