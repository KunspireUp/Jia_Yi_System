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
    <title>查找成功</title>
    <link href="<c:url value="/css/loginsucess.css" />" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="loginsucess">
    <div class="center">
        <div class="box-1">
            <img src="/img/老师.png" alt="" width="100px" height="100px">
            <p>FIND SUCESS</p>
            <p>查找 <span>【<%=session.getAttribute("find_stu_sno") %> 学号学生信息成功】</span></p>
            <h3>页面加载中，<span id="second">3</span>秒后跳转...</h3>
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
    var num = 3;
    var timer = setInterval(function () {
        num--;
        Os.innerText = num;
        if (num == 0) {
            location.href=window.location.origin + "/Jia_Yi_System/user/studentshow_change.jsp";
        }
    }, 1000)

    function stop() {
        clearInterval(timer);
    }

</script>
</body>
