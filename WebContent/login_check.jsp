<%@ page language="java" import="entity.User,entity.Student,entity.Teacher,entity.Admin"
						import="dao.studentDao,dao.teacherDao,dao.adminDao,dao.Login_recordDao"
						import="java.*,java.text.SimpleDateFormat,java.util.*" 
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录验证</title>
</head>
<body>
	<%
	User user=(User)session.getAttribute("user");
	
	Date now=new Date();						//取当前时间
	SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time=f.format(now.getTime());
	
	studentDao sdao=new studentDao();
	teacherDao tdao=new teacherDao();
	adminDao adao=new adminDao();
	Login_recordDao lrdao=new Login_recordDao();
	
	Student s=sdao.queryStudentById(user.getId());
	Teacher t=tdao.queryTeacherById(user.getId());
	Admin a=adao.queryAdminById(user.getId());
	if(user.id.equals("")){
		out.print("<script>alert('ID不能为空！'); window.location='login.html' </script>");
		out.flush();
		out.close();
	}
	else{
		if(user.uyzm.equals(session.getAttribute("yzm"))){
			if(s!=null){	//找到学生
				if(user.upwd.equals(s.getScheck_key())){
					user.setRole("student");
					out.print("<script>alert('欢迎学生 "+s.getSname()+" 登录'); window.location='me.jsp' </script>");
					out.flush();
					out.close();
					lrdao.addrecords(user.id,time);
				}else{
					out.print("<script>alert('用户名或密码错误!'); window.location='login.html' </script>");
					out.flush();
					out.close();
					lrdao.addrecordf(user.id,time);
				}
			}
			else if(t!=null){	//找到老师
				if(user.upwd.equals(t.getTcheck_key())){
					user.setRole("teacher");
					out.print("<script>alert('欢迎老师 "+t.getTname()+" 登录'); window.location='me.jsp' </script>");
					out.flush();
					out.close();
					lrdao.addrecords(user.id,time);
				}else{
					out.print("<script>alert('用户名或密码错误!'); window.location='login.html' </script>");
					out.flush();
					out.close();
					lrdao.addrecordf(user.id,time);
				}
			}
			else if(a!=null){	//找到管理员
				if(user.upwd.equals(a.getAcheck_key())){
					user.setRole("admin");
					out.print("<script>alert('欢迎 管理员 "+a.getAid()+" 登录!'); window.location='me.jsp' </script>");
					out.flush();
					out.close();
					lrdao.addrecords(user.id,time);
				}else{
					out.print("<script>alert('用户名或密码错误!'); window.location='login.html' </script>");
					out.flush();
					out.close();
					lrdao.addrecordf(user.id,time);
				}
			}
			else{
				out.print("<script>alert('用户不存在，登录失败!'); window.location='login.html' </script>");
				out.flush();
				out.close();
				lrdao.addrecordf(user.id,time);
			}
		}
		else {
			out.print("<script>alert('验证码错误!'); window.location='login.html' </script>");
			out.flush();
			out.close();
			lrdao.addrecordf(user.id,time);
		}
	}
	%>
</body>
</html>