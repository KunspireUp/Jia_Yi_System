<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
</style>
<link href="<c:url value="/css/insertstudent.css" />" rel="stylesheet"type="text/css" />
</head>

<body>
	<div class="login">
		<div class="left">
			<div class="user">
				<p class="text">
					<br><%=session.getAttribute("name")%>教师界面
				</p>
				<img src="${pageContext.request.contextPath}/img/老师.png" alt="" width="100px"
					height="100px" class="img">
			</div>
			<div class="menu">
				<input class="button show" type="button" value="查询学生信息" style="padding-left: 5px;" onclick='location.href=window.location.origin + "/Jia_Yi_System/user/findstudent.jsp"'>
				<input class="button insert" type="button" value="添加学生成绩" style="padding-left: 5px;" onclick='location.href=window.location.origin +"/Jia_Yi_System/user/insertstudent.jsp"'>
				<input class="button delete" type="button" value="删除学生信息" style="padding-left: 5px;" onclick='location.href=window.location.origin + "/Jia_Yi_System/user/findstudent_del.jsp"'>
				<input class="button find" type="button" value="找回用户密码" style="padding-left: 5px;" onclick='location.href=window.location.origin + "/Jia_Yi_System/change/findpassword.jsp"'>
				<input class="button show" type="button" value="浏览学生成绩" style="padding-left: 5px;" onclick='location.href=window.location.origin + "/Jia_Yi_System/login/word_list_javabean.jsp"'>
				<input class="button back" type="button" value="返回上一界面" style="padding-left: 5px;" onclick="back()">
				<input class="button quit" type="button" value="退出教师界面" style="padding-left: 5px;" onclick="logout()">
			</div>
		</div>
		<div class="right">
			<div class="text1">
				<h1 class="h3">查询到的学生信息</h1>
			</div>
			<div class="show1">
				<form action="<%=request.getContextPath()%>/ChnageStudentInfoServlet" method="post" onsubmit="return check()">
					<span>学号</span><input class="button1" id="st_sno" type="text"  readonly="readonly" value="<%=session.getAttribute("st_sno") %>" name="st_sno" readonly unselectable="on">
					<span>姓名</span><input class="button1" id="st_name" type="text" readonly="readonly" value="<%=session.getAttribute("st_name") %>" name="st_name"
					onkeyup="value=value.replace(/[^\u4e00-\u9fa5]/g,'')"
					onblur="value=value.replace(/[^\u4e00-\u9fa5]/g,'')"
					placeholder="请输入中文">
					<span>班级</span><input class="button1" id="st_classz" type="text" value="<%=session.getAttribute("st_classz") %>" name="st_classz"
					placeholder="请输入中文">
					<span>语文</span><input class="button1" id="st_chinese" type="text" value="<%=session.getAttribute("st_chinese") %>" name="st_chinese"
					onkeyup="value=value.replace(/[^\d]/g,'') "      
       				onblur="value=value.replace(/[^\d]/g,'')" 
       				ng-model="schedule.round"
       				placeholder="请输入数字">
					<span>英语</span><input class="button1" id="st_math" type="text" value="<%=session.getAttribute("st_english") %>" name="st_math"
					onkeyup="value=value.replace(/[^\d]/g,'') "      
       				onblur="value=value.replace(/[^\d]/g,'')" 
       				ng-model="schedule.round"
       				placeholder="请输入数字">
					<span>数学</span><input class="button1" id="st_english" type="text" value="<%=session.getAttribute("st_math") %>" name="st_english"
					onkeyup="value=value.replace(/[^\d]/g,'') "      
       				onblur="value=value.replace(/[^\d]/g,'')" 
       				ng-model="schedule.round"
       				placeholder="请输入数字">
					<span>物理</span><input class="button1" id="st_physics" type="text" value="<%=session.getAttribute("st_physics") %>" name="st_physics"
					onkeyup="value=value.replace(/[^\d]/g,'') "      
       				onblur="value=value.replace(/[^\d]/g,'')" 
       				ng-model="schedule.round"
       				placeholder="请输入数字">
					<span>化学</span><input class="button1" id="st_chemistry" type="text" value="<%=session.getAttribute("st_chemistry") %>" name="st_chemistry"
					onkeyup="value=value.replace(/[^\d]/g,'') "      
       				onblur="value=value.replace(/[^\d]/g,'')" 
       				ng-model="schedule.round"
       				placeholder="请输入数字">
					<p class="input_p">
						<input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
				</form>

			</div>
		</div>
	</div>
	<hr />
	<p class="copyright">Copyright 2022-06-16 杨森喜 0411200429 软件A2004
		All Rights Reserved</p>
</body>
<script>
	function logout() {
		if (confirm("您确定要退出教师界面吗？")) {
			self.location = '/login.jsp';
		}
		return false;
	}
	function back() {
		history.go(-1);
	}
	
	function check() {
		var st_sno = document.getElementById("st_sno").value;
		var st_name = document.getElementById("st_name").value;
		var st_classz = document.getElementById("st_classz").value;
		var st_chinese = document.getElementById("st_chinese").value;
		var st_math = document.getElementById("st_math").value;
		var st_english = document.getElementById("st_english").value;
		var st_physics = document.getElementById("st_physics").value;
		var st_chemistry = document.getElementById("st_chemistry").value;
		if (st_sno == "" || st_name == "" || st_classz == ""|| st_chinese == "" || st_math == "" || st_english == ""|| st_physics == "" || st_chemistry == "") {
			alert("选项不能为空");
			return false;
		}else {
			return true;
		}

	}
</script>

</html>