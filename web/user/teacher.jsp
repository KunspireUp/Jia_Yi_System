<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>教师操作界面</title>
    <style></style>
    <link href="<c:url value="/css/teacher.css" />" rel="stylesheet"  type="text/css" />
</head>

<body>
    <div class="login">
        <div class="left">
            <div class="user">
                <p class="text"><br><%=session.getAttribute("name") %>教师界面</p>
                <img src="${pageContext.request.contextPath}/img/老师.png" alt="" width="100px" height="100px" class="img">
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
            <h2> 欢迎来到教师操作界面</h2>
            <p class="ability">教师操作权限</p>
            <img src="${pageContext.request.contextPath}/img/权限.png" alt="" width="500px" height="420px" class="img2">

        </div>
    </div>
    <hr />
    <p class="copyright">Copyright 2022-06-16 杨森喜 0411200429 软件A2004 All Rights Reserved</p>
</body>
<script>
function logout(){
    if (confirm("您确定要退出教师界面吗？")){
    	location.href=window.location.origin + '/Jia_Yi_System/login.jsp';
    }
     return false;
}
function back(){
    history.go(-2);
}
</script>

</html>