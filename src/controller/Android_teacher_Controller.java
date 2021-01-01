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

@WebServlet("/Android_teacher.action")
public class Android_teacher_Controller extends HttpServlet {
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
			
			resp.sendRedirect("Android_teacher.jsp");
			break;
		case "addzj":
			String id_a=req.getParameter("id_a");
			String name_a=req.getParameter("name_a");
			Android a_a=new Android(id_a,name_a,null,null);
			adao.addzj(a_a);
			resp.sendRedirect("Android_teacher.action?opttype=queryall");
			break;
		case "deletezj":
			String id_d=req.getParameter("id_d");
			adao.deletezjByid(id_d);
			resp.sendRedirect("Android_teacher.action?opttype=queryall");
			break;
		case "editzj":
			String id_e=req.getParameter("id_e");
			Android a_e=adao.queryzjById(id_e);
			req.getSession().setAttribute("p", a_e);
			resp.sendRedirect("editandroid.jsp");
			break;
		case "updatezj":
			String id_e1=req.getParameter("id_e1");
			String name_e1=req.getParameter("name_e1");
			Android a_e1=new Android(id_e1,name_e1,null,null);
			adao.updatezj(a_e1);
			resp.sendRedirect("Android_teacher.action?opttype=queryall");
			break;
		case "uploadhomework":
			String hid_u=req.getParameter("hid_u");
			req.getSession().setAttribute("hid_u", hid_u);
			Android a_homework=adao.queryzjById(hid_u);
			req.getSession().setAttribute("a_homework", a_homework);
			resp.sendRedirect("Android_teacher_homework.jsp");
			break;
		case"deletehomework":
			String hid_d=req.getParameter("hid_d");
			Android ah_d=adao.queryzjById(hid_d);
			adao.updatehomework(ah_d,null);
			resp.sendRedirect("Android_teacher.action?opttype=queryall");
			break;			
		case "uploadvideo":
			String vid_u=req.getParameter("vid_u");
			req.getSession().setAttribute("vid_u", vid_u);
			Android a_video=adao.queryzjById(vid_u);
			req.getSession().setAttribute("a_video", a_video);
			resp.sendRedirect("Android_teacher_video.jsp");
			break;
		case "deletevideo":
			String vid_d=req.getParameter("vid_d");
			Android av_d=adao.queryzjById(vid_d);
			adao.updatevideo(av_d,null);
			resp.sendRedirect("Android_teacher.action?opttype=queryall");
			break;		
		case "admindeletevideo":
			String vid_d1=req.getParameter("vid_d1");
			Android av_d1=adao.queryzjById(vid_d1);
			adao.updatevideo(av_d1,null);
			resp.sendRedirect("admin.action?opttype=queryall");
			break;		
		case "setscore":
			String sid=req.getParameter("sid");
			String zjid=req.getParameter("zjid");
			android_student_homework a_hscore=a_hdao.queryById(sid, zjid);
			req.getSession().setAttribute("a_hscore", a_hscore);
			resp.sendRedirect("Android_teacher_setscore.jsp");
			break;
		case "updatescore":
			String sid_score=req.getParameter("sid_score");
			String zjid_score=req.getParameter("zjid_score");
			int score=Integer.parseInt(req.getParameter("score"));
			android_student_homework a_score=a_hdao.queryById(sid_score, zjid_score);
			a_score.setScore(score);
			a_hdao.updatescore(a_score);
			resp.sendRedirect("Android_teacher.action?opttype=queryall");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
