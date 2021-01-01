<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>作业评分</title>
	</head>
	<body>
	     <form action="Python_teacher.action" method="post">
	        学号:<input type=text name="sid_score" value="${p_hscore.sid}" readonly><br>
	        章节号:<input type=text name="zjid_score" value="${p_hscore.zjid}" readonly><br>
	        得分:<input type=text name="score" value="${p_hscore.score}"><br>
	        <input type=hidden name="opttype" value="updatescore">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>