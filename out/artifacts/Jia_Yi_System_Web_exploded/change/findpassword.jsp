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
    <link href="<c:url value="/css/findpwd.css" />" rel="stylesheet"  type="text/css" />
</head>

<body>
    <div class="login">
        <div class="left">
            <div class="user">
                <p class="text"><br><%=session.getAttribute("name") %>教师界面</p>
                <img src="/img/老师.png" alt="" width="100px" height="100px" class="img">
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
                <h1 class="h3">找回学生密码界面</h1>
            </div>
            <div class="show1">
                <form action="<%=request.getContextPath()%>/FindPasswordServlet" method="post">
                	<span class="text3">选择找回密码类型</span>
                <select name="option_value_find" class="option">
                    <option value="1">学号</option>
                    <option value="2">姓名</option>
                </select>
                <input class="button1" type="text"
                       value=""
                       name="find_user"
                       style="padding-left: 40px;"
                       maxlength="15"
                       placeholder="请输入删除的学号或者姓名"
                       onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g,'') "
                       onblur="value=value.replace(/[^\w\u4E00-\u9FA5]/g,'')"

                >
                <p class="input_p"><input type="submit" value="找回">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="reset()"></p>
                    <%
                        String find_user = request.getParameter("find_user");
                        session.setAttribute("find_user", find_user);
                    %>
                </form>
               
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
        history.go(-2);
    }
</script>

</html>