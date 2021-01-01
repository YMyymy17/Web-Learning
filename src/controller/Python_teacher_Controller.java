package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PythonDao;
import dao.python_stuhomeworkDao;
import entity.Python;
import entity.python_student_homework;

@WebServlet("/Python_teacher.action")
public class Python_teacher_Controller extends HttpServlet {
	PythonDao pdao=new PythonDao();
	python_stuhomeworkDao p_hdao=new python_stuhomeworkDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String opttype=req.getParameter("opttype");
		
		switch(opttype) {
		case "queryall":
			List<Python> clist=pdao.allzj();
			req.getSession().setAttribute("clist", clist);
			
			List<python_student_homework> clist1=p_hdao.all();
			req.getSession().setAttribute("clist1", clist1);
			
			resp.sendRedirect("Python_teacher.jsp");
			break;
		case "addzj":
			String id_a=req.getParameter("id_a");
			String name_a=req.getParameter("name_a");
			Python p_a=new Python(id_a,name_a,null,null);
			pdao.addzj(p_a);
			resp.sendRedirect("Python_teacher.action?opttype=queryall");
			break;
		case "deletezj":
			String id_d=req.getParameter("id_d");
			pdao.deletezjByid(id_d);
			resp.sendRedirect("Python_teacher.action?opttype=queryall");
			break;
		case "editzj":
			String id_e=req.getParameter("id_e");
			Python p_e=pdao.queryzjById(id_e);
			req.getSession().setAttribute("p", p_e);
			resp.sendRedirect("editpython.jsp");
			break;
		case "updatezj":
			String id_e1=req.getParameter("id_e1");
			String name_e1=req.getParameter("name_e1");
			Python p_e1=new Python(id_e1,name_e1,null,null);
			pdao.updatezj(p_e1);
			resp.sendRedirect("Python_teacher.action?opttype=queryall");
			break;
		case "uploadhomework":
			String hid_u=req.getParameter("hid_u");
			req.getSession().setAttribute("hid_u", hid_u);
			Python p_homework=pdao.queryzjById(hid_u);
			req.getSession().setAttribute("p_homework", p_homework);
			resp.sendRedirect("Python_teacher_homework.jsp");
			break;
		case"deletehomework":
			String hid_d=req.getParameter("hid_d");
			Python ph_d=pdao.queryzjById(hid_d);
			pdao.updatehomework(ph_d,null);
			resp.sendRedirect("Python_teacher.action?opttype=queryall");
			break;			
		case "uploadvideo":
			String vid_u=req.getParameter("vid_u");
			req.getSession().setAttribute("vid_u", vid_u);
			Python p_video=pdao.queryzjById(vid_u);
			req.getSession().setAttribute("p_video", p_video);
			resp.sendRedirect("Python_teacher_video.jsp");
			break;
		case "deletevideo":
			String vid_d=req.getParameter("vid_d");
			Python pv_d=pdao.queryzjById(vid_d);
			pdao.updatevideo(pv_d,null);
			resp.sendRedirect("Python_teacher.action?opttype=queryall");
			break;		
		case "admindeletevideo":
			String vid_d1=req.getParameter("vid_d1");
			Python pv_d1=pdao.queryzjById(vid_d1);
			pdao.updatevideo(pv_d1,null);
			resp.sendRedirect("me.jsp");
			break;	
		case "setscore":
			String sid=req.getParameter("sid");
			String zjid=req.getParameter("zjid");
			python_student_homework p_hscore=p_hdao.queryById(sid, zjid);
			req.getSession().setAttribute("p_hscore", p_hscore);
			resp.sendRedirect("Python_teacher_setscore.jsp");
			break;
		case "updatescore":
			String sid_score=req.getParameter("sid_score");
			String zjid_score=req.getParameter("zjid_score");
			int score=Integer.parseInt(req.getParameter("score"));
			python_student_homework p_score=p_hdao.queryById(sid_score, zjid_score);
			p_score.setScore(score);
			p_hdao.updatescore(p_score);
			resp.sendRedirect("Python_teacher.action?opttype=queryall");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
