<%@ page language="java" import="dao.JavaeeDao,dao.PythonDao,dao.AndroidDao"
						import="entity.JavaEE,entity.Python,entity.Android"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>视频播放</title>
<link rel="stylesheet" type="text/css" href="css/Home.css">
<link rel="stylesheet" type="text/css" href="css/container.css">
</head>
<%
	String id=request.getParameter("zj_id");
	JavaeeDao jdao=new JavaeeDao();
	PythonDao pdao=new PythonDao();
	AndroidDao adao=new AndroidDao();
	JavaEE j=jdao.queryzjById(id);
	Python p=pdao.queryzjById(id);
	Android a=adao.queryzjById(id);
	String url="";
	if(j!=null){
		url=j.getVideo().toString();
	}
	else if(p!=null){
		url=p.getVideo().toString();
	}
	else if(a!=null){
		url=a.getVideo().toString();
	}
	String path=request.getServletContext().getRealPath("/");
	String real=".\\"+url.replace(path,"");
%>
<body>
	<ul>
		<li><font color="skyblue" size="4">选择成就梦想，努力造就未来！</font></li>
		<li><a href="Home.jsp">首页</a></li>
		<li><a href="Course.action?opttype=queryall">课程</a></li>
		<li><a href="login.html">登录</a></li>
		<li><a href="me.jsp">我的</a></li>
	</ul>
	<br>
	 <div class="container">
        <video src="<%=real%>"></video>
        <div class="control">
            <i class="icon icon-play switch" id="switch">播放</i>
            <div class="process">
                <div class="bar"></div>
            </div>
            <div class="time">
                <span>00:00:00</span> /
                <span>00:00:00</span> 
            </div>
        </div>
    </div>
    <script>    
        var btn = document.querySelector('#switch');
        var video = document.querySelector('video');
        var spans = document.querySelectorAll('.control .time span');
        var process = document.querySelector('.process');
        var bar = document.getElementsByClassName('bar')[0];
        var full = document.querySelector('#full');
        // console.log(spans[0]);
        var total = 0;
        var processWidth = process.offsetWidth;
        // console.log(processWidth);
        var currenttime = undefined;
        var endbarwidth = undefined;

        var num = 1;
        
        //视频开始和暂停切换
        btn.onclick = function (){
            // console.log(video.paused);
            if(video.paused) {
                video.play();
                this.classList.remove('icon-play');
                this.classList.add('icon-pause');
            } else {
                video.pause();
                this.classList.remove('icon-pause');
                this.classList.add('icon-play');
            }
        }
        
        //获取视频时间
        //当视频可以播放的时候才可以获取不然获取不到
        video.oncanplay = function (){
            total = video.duration;
            
            // console.log(total); //以秒为单位
            spans[1].innerHTML = getTime(total);
            // console.log(spans[1]);
        }
        //当视频播放
        video.ontimeupdate = function(){
            currenttime = video.currentTime;
            spans[0].innerHTML = getTime(currenttime);
            barWidth    = processWidth * currenttime / total; // 当前时间
            endbarwidth = processWidth * currenttime / total; // 记录最长时间
            bar.style.width = barWidth + 'px';
        }

        //点击进度条下面的凹槽 也算是障眼法
        process.onclick = function (e) {
            num += 1;
            if ( num == 2) {
                localStorage.setItem('endbarwidth', endbarwidth);
            }
            console.log(e.offsetX);
            var losW = undefined;
            if (localStorage.getItem('endbarwidth')) {
                losW = parseFloat(localStorage.getItem('endbarwidth'))
            }
            console.log(losW);
            if (e.offsetX < losW) { // 
                video.currentTime = total * e.offsetX / processWidth;
            } else if (e.offsetX > barWidth) {
                return;
            } else {
                video.currentTime = total * e.offsetX / processWidth;
            }
        }

        //视频结束时
        video.onended = function (){
            video.currentTime = 0;
            btn.classList.remove('icon-pause');
            btn.classList.add('icon-play');
        }
        
        //全屏开启
        full.onclick = function(){
            if(video.webkitRequestFullScreen){
                video.webkitRequestFullScreen();
            } else if (video.mozRequestFullScreen){
                video.mozRequestFullScreen();
            } else if (video.msRequestFullScreen) {
                video.msRequestFullScreen();
            } else if (video.oRequestFullScreen){
                video.oRequestFullScreen();
            } else {
                video.requestFullScreen();
            }
            
        }
        

        function getTime(time){
            var hours = Math.floor(time%86400/3600);

            var minutes = Math.floor(time%86400%3600/60);

            var seconds = Math.floor(time%60);
            // console.log(seconds);

            hours = hours > 10 ? hours : '0' + hours;
            minutes = minutes > 10 ? minutes : '0' + minutes;
            seconds = seconds > 10 ? seconds : '0' + seconds;

            var str = '';
            str = hours + ':' + minutes + ':' + seconds;
            // console.log(str);
            return str;
        }
    </script>
</body>
</html>