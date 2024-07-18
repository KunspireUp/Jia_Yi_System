<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<link href="<c:url value="/css/login.css" />" rel="stylesheet"  type="text/css" />
<style>
</style>
<body>
	<div class="login">
        <div class="left"></div>
        <div class="right">
            <form action="<%=request.getContextPath()%>/LoginServlet" method="post" onsubmit="return check()">
                <h2>佳 一 教 务 系 统</h2>
                <input class="userinfo" type="text" name="username" id="username" placeholder="用户名" style="padding-left: 35px; font-weight: bold;" >
                <input class="pwdinfo" type="password" name="password" id="password" placeholder="密码" style="padding-left: 35px; font-weight: bold;" >
                <div class="conceal" id="conceal"></div>
                <input class="submit" type="submit" name=""value="登录" onclick="check()" >
                <input class="reset" type="button" name="" value="重置" onclick="reset()" >
            </form>
        </div>
    </div>
    <div class="footer">
        <hr>
        <div class="top_content">Copyright 2022-06-16 杨森喜 0411200429 软件A2004 All Rights Reserved</div>
    </div>
<script src="<c:url value="/js/login.js" />"></script>
</body>
<script type="text/javascript">
	//表单重置
	function reset(){
	    document.getElementById("username").value="";
	    document.getElementById("password").value="";
	}
	//表单不能为空
	function check(){
	    var username=document.getElementById("username").value;
	    var password=document.getElementById("password").value;
	    if(username==""||password==""){
	        alert("用户名或密码不能为空！");
	        return false;
	    }
	    return true;
	}
</script>
</html>