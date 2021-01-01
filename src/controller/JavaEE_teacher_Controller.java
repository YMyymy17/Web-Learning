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
import entity.Python;
import entity.javaee_student_homework;

@WebServlet("/JavaEE_teacher.action")
public class JavaEE_teacher_Controller extends HttpServlet {
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
			
			resp.sendRedirect("JavaEE_teacher.jsp");
			break;
		case "addzj":
			String id_a=req.getParameter("id_a");
			String name_a=req.getParameter("name_a");
			JavaEE j_a=new JavaEE(id_a,name_a,null,null);
			jdao.addzj(j_a);
			resp.sendRedirect("JavaEE_teacher.action?opttype=queryall");
			break;
		case "deletezj":
			String id_d=req.getParameter("id_d");
			jdao.deletezjByid(id_d);
			resp.sendRedirect("JavaEE_teacher.action?opttype=queryall");
			break;
		case "editzj":
			String id_e=req.getParameter("id_e");
			JavaEE j_e=jdao.queryzjById(id_e);
			req.getSession().setAttribute("j", j_e);
			resp.sendRedirect("editjavaee.jsp");
			break;
		case "updatezj":
			String id_e1=req.getParameter("id_e1");
			String name_e1=req.getParameter("name_e1");
			JavaEE j_e1=new JavaEE(id_e1,name_e1,null,null);
			jdao.updatezj(j_e1);
			resp.sendRedirect("JavaEE_teacher.action?opttype=queryall");
			break;
		case "uploadhomework":
			String hid_u=req.getParameter("hid_u");
			req.getSession().setAttribute("hid_u", hid_u);
			JavaEE j_homework=jdao.queryzjById(hid_u);
			req.getSession().setAttribute("j_homework", j_homework);
			resp.sendRedirect("JavaEE_teacher_homework.jsp");
			break;
		case"deletehomework":
			String hid_d=req.getParameter("hid_d");
			JavaEE jh_d=jdao.queryzjById(hid_d);
			jdao.updatehomework(jh_d,null);
			resp.sendRedirect("JavaEE_teacher.action?opttype=queryall");
			break;			
		case "uploadvideo":
			String vid_u=req.getParameter("vid_u");
			req.getSession().setAttribute("vid_u", vid_u);
			JavaEE j_video=jdao.queryzjById(vid_u);
			req.getSession().setAttribute("j_video", j_video);
			resp.sendRedirect("JavaEE_teacher_video.jsp");
			break;
		case "deletevideo":
			String vid_d=req.getParameter("vid_d");
			JavaEE jv_d=jdao.queryzjById(vid_d);
			jdao.updatevideo(jv_d,null);
			resp.sendRedirect("JavaEE_teacher.action?opttype=queryall");
			break;		
		case "admindeletevideo":
			String vid_d1=req.getParameter("vid_d1");
			JavaEE jv_d1=jdao.queryzjById(vid_d1);
			jdao.updatevideo(jv_d1,null);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;		
		case "setscore":
			String sid=req.getParameter("sid");
			String zjid=req.getParameter("zjid");
			javaee_student_homework j_hscore=j_hdao.queryById(sid, zjid);
			req.getSession().setAttribute("j_hscore", j_hscore);
			resp.sendRedirect("JavaEE_teacher_setscore.jsp");
			break;
		case "updatescore":
			String sid_score=req.getParameter("sid_score");
			String zjid_score=req.getParameter("zjid_score");
			int score=Integer.parseInt(req.getParameter("score"));
			javaee_student_homework j_score=j_hdao.queryById(sid_score, zjid_score);
			j_score.setScore(score);
			j_hdao.updatescore(j_score);
			resp.sendRedirect("JavaEE_teacher.action?opttype=queryall");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
