<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信息添加成功</title>
    <style>
    </style>
    <link href="<c:url value="/css/showchangestudent.css" />" rel="stylesheet"  type="text/css" />
</head>

<body>
    <div class="login">
        <div class="left">
            <div class="user">
                <p class="text"><br><%=session.getAttribute("name") %>学生界面</p>
                <img src="${pageContext.request.contextPath}/img/老师.png" alt="" width="100px" height="100px" class="img">
            </div>
            <div class="menu">
                <input type="text" name="ss" value="<%=session.getAttribute("username") %>"  readonly unselectable="on" style = "display:none">
                <input class="button show" type="button" value="查看本人成绩" style="padding-left: 5px;" onclick='location.href=("/FindStudentServlet3")'>
                <input class="button insert" type="button" value="修改学生密码" style="padding-left: 5px;" onclick='location.href=window.location.origin + "/Jia_Yi_System/change/changepassword.jsp"'>
                <input class="button back" type="button" value="返回上一界面" style="padding-left: 5px;" onclick="back()">
                <input class="button quit" type="button" value="退出学生界面" style="padding-left: 5px;" onclick="logout()">
            </div>
        </div>
        <div class="right">
            <div class="text1">
                <h1 class="h3">学生信息查看成功</h1>
            </div>
            <div class="show1">
                <span>学号</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_sno") %>">
                <span>姓名</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_name") %>">
                <span>班级</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_classz") %>">
                <span>语文</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_chinese") %>">
                <span>英语</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_math") %>">
                <span>数学</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_english") %>">
                <span>物理</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_physics") %>">
                <span>化学</span><input class="button1" type="text" readonly="readonly" value="<%=session.getAttribute("st_chemistry") %>">
               
            </div>
        </div>
    </div>
    <hr />
    <p class="copyright">Copyright 2022-06-16 杨森喜 0411200429 软件A2004 All Rights Reserved</p>
    <script src="./login.js"></script>
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
</script>

</html>