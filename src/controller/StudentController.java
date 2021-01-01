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
import entity.Student;
import entity.User;
import entity.Admin;
import entity.Course;

@WebServlet("/student.action")
public class StudentController extends HttpServlet {
	courseDao cdao=new courseDao();
	studentDao sdao=new studentDao();
	
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String opttype=req.getParameter("opttype");
		
		String sid=(String)req.getSession().getAttribute("sid");
		Student s=sdao.queryStudentById(sid);
		int classid=s.getClassid();
		
		switch(opttype) {
		case "querycourse":
			List<Course> clist1=cdao.queryCourseByClassid(classid);
			req.getSession().setAttribute("clist1", clist1);
			resp.sendRedirect("student.jsp");
			break;
		case "resetpwd":
			req.getSession().setAttribute("s_p",s);
			resp.sendRedirect("student_resetpwd.jsp");
			break;
		case "updatepwd":
			String sid_p1=req.getParameter("sid_p1");
			String scheck_key_new=req.getParameter("scheck_key_new");
			Student s_p1=sdao.queryStudentById(sid_p1);
			s_p1.setScheck_key(scheck_key_new);
			sdao.updatepwd(s_p1);
			resp.sendRedirect("student.action?opttype=querycourse");
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
