package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.adminDao;
import dao.courseDao;
import dao.studentDao;
import dao.teacherDao;
import entity.Admin;
import entity.Course;
import entity.Student;
import entity.Teacher;
import entity.User;

@WebServlet("/admin.action")
public class AdminController extends HttpServlet {
	courseDao cdao=new courseDao();
	studentDao sdao=new studentDao();
	teacherDao tdao=new teacherDao();
	adminDao adao=new adminDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String opttype=req.getParameter("opttype");
		
		switch(opttype) {
		case "queryall":
			List<Course> clist1=cdao.allCourse();
			req.getSession().setAttribute("clist1", clist1);
			
			List<Student> clist2=sdao.allStudent();
			req.getSession().setAttribute("clist2", clist2);
			
			List<Teacher> clist3=tdao.allTeacher();
			req.getSession().setAttribute("clist3", clist3);
			
			resp.sendRedirect("admin.jsp");
			break;
		case "addcourse":
			int cid_a=Integer.parseInt(req.getParameter("cid_a"));
			String cname_a=req.getParameter("cname_a");
			int classid_a=Integer.parseInt(req.getParameter("classid_a"));
			int ctid_a=Integer.parseInt(req.getParameter("ctid_a"));
			Course c_a=new Course(cid_a,cname_a,classid_a,ctid_a);
			cdao.addCourse(c_a);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "deletecourse":
			String cid_d=req.getParameter("cid_d");
			cdao.deleteCourseByCid(cid_d);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "editcourse":
			String cid_e=req.getParameter("cid_e");
			Course c_e=cdao.queryCourseById(cid_e);
			req.getSession().setAttribute("c",c_e);
			resp.sendRedirect("editcourse.jsp");
			break;
		case "updatecourse":
			int cid_e1=Integer.parseInt(req.getParameter("cid_e1"));
			String cname_e1=req.getParameter("cname_e1");
			int cclassid_e1=Integer.parseInt(req.getParameter("cclassid_e1"));
			int ctid_e1=Integer.parseInt(req.getParameter("ctid_e1"));
			Course c_e1=new Course(cid_e1,cname_e1,cclassid_e1,ctid_e1);
			cdao.updateCourse(c_e1);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "addstudent":
			int sid_a=Integer.parseInt(req.getParameter("sid_a"));
			String sname_a=req.getParameter("sname_a");
			String ssex_a=req.getParameter("ssex_a");
			int sclassid_a=Integer.parseInt(req.getParameter("sclassid_a"));
			String scheck_key_a=req.getParameter("scheck_key_a");
			Student s_a=new Student(sid_a,sname_a,ssex_a,sclassid_a,scheck_key_a);
			sdao.addStudent(s_a);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "deletestudent":
			String sid_d=req.getParameter("sid_d");
			sdao.deleteStudentByCid(sid_d);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "editstudent":
			String sid_e=req.getParameter("sid_e");
			Student s_e=sdao.queryStudentById(sid_e);
			req.getSession().setAttribute("s",s_e);
			resp.sendRedirect("editstudent.jsp");
			break;
		case "updatestudent":
			int sid_e1=Integer.parseInt(req.getParameter("sid_e1"));
			String sname_e1=req.getParameter("sname_e1");
			String ssex_e1=req.getParameter("ssex_e1");
			int classid_e1=Integer.parseInt(req.getParameter("sclassid_e1"));
			Student s_e1=new Student(sid_e1,sname_e1,ssex_e1,classid_e1,null);
			sdao.updateStudent(s_e1);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "addteacher":
			int tid_a=Integer.parseInt(req.getParameter("tid_a"));
			String tname_a=req.getParameter("tname_a");
			String tsex_a=req.getParameter("tsex_a");
			int tclassid_a=Integer.parseInt(req.getParameter("tclassid_a"));
			String tcheck_key_a=req.getParameter("tcheck_key_a");
			Teacher t_a=new Teacher(tid_a,tname_a,tsex_a,tclassid_a,tcheck_key_a);
			tdao.addTeacher(t_a);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "deleteteacher":
			String tid_d=req.getParameter("tid_d");
			tdao.deleteTeacherByCid(tid_d);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "editteacher":
			String tid_e=req.getParameter("tid_e");
			Teacher t_e=tdao.queryTeacherById(tid_e);
			req.getSession().setAttribute("t",t_e);
			resp.sendRedirect("editteacher.jsp");
			break;
		case "updateteacher":
			int tid_e1=Integer.parseInt(req.getParameter("tid_e1"));
			String tname_e1=req.getParameter("tname_e1");
			String tsex_e1=req.getParameter("tsex_e1");
			int tclassid_e1=Integer.parseInt(req.getParameter("tclassid_e1"));
			Teacher t_e1=new Teacher(tid_e1,tname_e1,tsex_e1,tclassid_e1,null);
			tdao.updateTeacher(t_e1);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		case "resetpwd":
			User user=(User)req.getSession().getAttribute("user");
			Admin a_p=adao.queryAdminById(user.getId());
			req.getSession().setAttribute("a_p",a_p);
			resp.sendRedirect("admin_resetpwd.jsp");
			break;
		case "updatepwd":
			String aid_p1=req.getParameter("aid_p1");
			String acheck_key_new=req.getParameter("acheck_key_new");
			Admin a_p1=adao.queryAdminById(aid_p1);
			a_p1.setAcheck_key(acheck_key_new);
			adao.updatepwd(a_p1);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
