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
                <p class="text"><br><%=session.getAttribute("name") %>学生界面</p>
                <img src="${pageContext.request.contextPath}/img/学生.png" alt="" width="100px" height="100px" class="img">
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
                <h1 class="h3">修改密码界面</h1>
            </div>
            <div class="show1">
                <form action="<%=request.getContextPath()%>/ChangePwdServlet" method="post">
                	<span class="text3">选择修改密码类型</span>
                <select name="option_value_change" class="option">
                    <option value="1">学号</option>
                    <option value="2">姓名</option>
                </select>
                <input class="button1"
                       type="text"
                       value=""
                       name="change_user"
                       style="padding-left: 40px;"
                       placeholder="请输入学号或姓名"
                       maxlength="15"
                       onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g,'') "
                       onblur="value=value.replace(/[^\w\u4E00-\u9FA5]/g,'')"
                >
                <input class="button1" type="text" value="" name="new_userpassword" style="padding-left: 40px;" placeholder="新密码(不超过20位)" maxlength="15">
                <input class="button1" type="text" value="" name="re_password" style="padding-left: 40px;" placeholder="重复密码" maxlength="15">
                <p class="input_p"><input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="reset()"></p>
                    <%
                        String new_userpassword = request.getParameter("new_userpassword");
                        session.setAttribute("new_userpassword", new_userpassword);
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
        if (confirm("您确定要退出学生界面吗？")) {
            self.location = '/login.jsp';
        }
        return false;
    }
    function back() {
        history.go(-2);
    }
</script>

</html>