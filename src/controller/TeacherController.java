package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.courseDao;
import dao.studentDao;
import dao.teacherDao;
import entity.Course;
import entity.Student;
import entity.Teacher;

@WebServlet("/teacher.action")
public class TeacherController extends HttpServlet {
	courseDao cdao=new courseDao();
	studentDao sdao=new studentDao();
	teacherDao tdao=new teacherDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String opttype=req.getParameter("opttype");
		String tid=(String)req.getSession().getAttribute("tid");
		
		switch(opttype) {
		case "queryall":
			List<Course> clist1=cdao.queryCourseByTid(tid);
			req.getSession().setAttribute("clist1", clist1);
			resp.sendRedirect("teacher.jsp");
			break;
		case "querystudentbyclassid":
			String classid=req.getParameter("classid");
			List<Student> clist2=sdao.queryStudentByClassid(classid);
			req.getSession().setAttribute("clist2", clist2);
			resp.sendRedirect("teacher.jsp");
			break;
		case "resetpwd":
			Teacher t_p=tdao.queryTeacherById(tid);
			req.getSession().setAttribute("t_p",t_p);
			resp.sendRedirect("teacher_resetpwd.jsp");
			break;
		case "updatepwd":
			String tid_p1=req.getParameter("tid_p1");
			String tcheck_key_new=req.getParameter("tcheck_key_new");
			Teacher t_p1=tdao.queryTeacherById(tid_p1);
			t_p1.setTcheck_key(tcheck_key_new);
			tdao.updatepwd(t_p1);
			resp.sendRedirect("teacher.action?opttype=queryall");
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
