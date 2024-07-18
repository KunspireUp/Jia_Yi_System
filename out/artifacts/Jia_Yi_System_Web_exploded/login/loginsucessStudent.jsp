<%@page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录成功</title>
    <link href="<c:url value="/css/loginsucess.css" />" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="loginsucess">
    <div class="center">
        <div class="box-1">
            <img src="${pageContext.request.contextPath}/img/学生.png" alt="" width="100px" height="100px">
            <p>LOGIN SUCESSFUL</p>
            <p>欢迎<span>【<%=session.getAttribute("name") %>同学】</span>登录教务系统</p>
            <h3>页面加载中，<span id="second">5</span>秒后跳转...</h3>
        </div>
    </div>
</div>
<%
    String username = request.getParameter("username");
    session.setAttribute("username", username);
    session.getAttribute("username");
%>
<script>
    var Os = document.getElementById("second");
    var num = 5;
    var timer = setInterval(function () {
        num--;
        Os.innerText = num;
        if (num == 0) {
            window.location.href = "user/student.jsp";
        }
    }, 1000)

    function stop() {
        clearInterval(timer);
    }

</script>
</body>

</html>