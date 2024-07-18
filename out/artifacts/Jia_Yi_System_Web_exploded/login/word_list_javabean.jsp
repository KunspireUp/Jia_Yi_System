<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="yangsenxi.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="pages" scope="page" class="yangsenxi.dao.SplitPage"/>
<%!
	//每页显示的记录数
	int pageSize = 10;
	String sqlStr = "";
	//当前页
	int showPage = 1;
	String userName = "root";
	String userPassword="root";
	//数据库的url
	String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
	//定义连接对象
	Connection dbcon;
	 %>
	 <%
	 try{
	 //加载驱动程序
	 Class.forName("com.mysql.jdbc.Driver");
	 //获得数据库连接对象
	 dbcon = DriverManager.getConnection(url,userName,userPassword);
	 }
	 catch(SQLException ex){
	 
 	System.out.println(ex.toString());
 	}
 	catch(ClassNotFoundException ex){
 	
 	System.out.println(ex.toString());
 	}
 	//给page中参数con赋值
 	pages.setCon(dbcon);
 	sqlStr = "select * from tb_source order by sno";
 	//查询数据表
 	String strPage = null;
 	//获取目的界面
 	strPage = request.getParameter("showPage");
 	if(strPage == null){
 	showPage = 1;
 	}
 	else{
 	
 		try{
 			showPage=Integer.parseInt(strPage);
 			}
 			catch(NumberFormatException e){
 			
 			showPage = 1;
 			}
 			if(showPage<1){
 			
 			showPage=1;
 	}
 	}
 	
 	pages.initialize(sqlStr,pageSize,showPage);
 	//获取要显示的命令集
	 	Vector vData = pages.getPage();
	 	
	  %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信息添加成功</title>
    <style>
    </style>
    <link href="<c:url value="/css/showall.css" />" rel="stylesheet"  type="text/css" />
</head>

<body>
    <div class="login">
        <div class="left">
            <div class="user">
                <p class="text"><br>教师界面</p>
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
            <div class="text1">
                <h1 class="h3">所有学生信息界面</h1>
            </div>
            <div class="show1">
                <div align = center class="show3">
                    <table border="1" cellspacing="0" cellpadding="0" width="80%">
                            <tr>
                                <th width="10%">学号</th>
                                <th width="10%">姓名</th>
                                <th width="10%">成绩</th>
                                <th width="10%">语文</th>
                                <th width="10%">数学</th>
                                <th width="10%">英语</th>
                                <th width="10%">物理</th>
                                <th width="10%">化学</th>
                            </tr>
                            
                            <%
                                for(int i = 0;i <vData.size();i++){
                                    //显示数据
                                    String[] sData=(String[])vData.get(i);
                                 %>  
                      <tr>
                          <td><%=sData[0] %><%String sh_sno = sData[0]; session.setAttribute(sh_sno, sh_sno); %></td>
                          <td align=left><%=sData[1] %></td>
                          <td align=left><%=sData[2] %></td>
                          <td align=left><%=sData[3] %></td>
                          <td align=left><%=sData[4] %></td>
                          <td align=left><%=sData[5] %></td>
                          <td align=left><%=sData[6] %></td>
                          <td align=left><%=sData[7] %></td>
                          
                          
                      </tr>
                      <!--  获取对应修改的数据 -->
                      <%
                      } %>
                          </table>
                              <form action="word_list_javabean.jsp" method="get" target="_self">
                              共<font color = red><%=pages.getRowCount()%></font>条&nbsp;
                              <%=pageSize%>条/页&nbsp;
                              第<font color = red><%=showPage%></font>页/共
                              <font color = red><%=pages.getPageCount()%></font>页&nbsp;
                              <a href="word_list_javabean.jsp?showPage=1" target="_self">[首页]</a>&nbsp;
                              <%
                                  //判断“上一页”链接是否要显示
                                  if(showPage>1){
                                  
                               %>
                                      <a
                                          href="word_list_javabean.jsp?showPage
                                          =<%=showPage-1%>"target="_self">[上一页]
                                      </a>&nbsp;
                                          
                                          <%
                                          }else{ 
                                          %>
                                              [上一页]
                              
                              <%
                          } 
                          //判断下一页链接是否要显示
                              if(showPage<pages.getPageCount())
                              {    	
                          %>
                          
                          <a 
                              href="word_list_javabean.jsp?showPage=<%=showPage+1 %>"
                               target="_self">[下一页]</a>
                              &nbsp;
                          
                          <%
                          }else{
                           %>
                           [下一页]&nbsp;
                           <%
                           } 
                           %>
                           <a href="word_list_javabean.jsp?showPage=<%=pages.getPageCount()%>"
                               target="_self">[尾页]</a>&nbsp;
                               
                               转到
                               <select name = "showPage">
                               <%
                                   for(int x = 1;x <= pages.getPageCount();x++){
                                   
                                %>
                                <option value="<%=x %>"<%if(showPage==x)%>>
                                        <%=x %></option>
                                        <%
                                        }
                                         %>
                                </select>
                                页&nbsp;
                                <input type="submit" name="go" value="提交"/>
                                
                          </form>
                          <%
                          //关闭数据库连接
                          dbcon.close();
                           %>
                      </div>
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