<%@page import="com.daoimpl.CouDaoImpl"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.util.MybatisSessionFactory"%>
<%@ page language="java" import="java.util.*,com.vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-课程信息</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  </head>
  <body>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
			<div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class03"><a href="tea/Query.jsp">信息查询</a></div>
			<div class="main_left_class100">
		<form action="login/DoLogoutAction" method="post"><input class="reset" type="submit" value="注销"></form>
		</div>
	</div>
					<%
	  	Teacher tea = null;
	  	if(session.getAttribute("teacher")==null){
	  		response.sendRedirect("/Ten/Login.jsp");
	  	}else{
	  		tea = (Teacher)session.getAttribute("teacher");
	   %>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= tea.getTname() %>老师，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<%
				SqlSession mysession=MybatisSessionFactory.getSession();
				CouDaoImpl coudao=mysession.getMapper(CouDaoImpl.class);
				List<Course> list1=coudao.selectCou();
				Iterator<Course> list=list1.iterator();
			%>
			<div class="form">
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>教室</td><td>修改课程</td><td>删除课程</td>
  						<td><input class="btn" type="button" value="添加课程" onclick="window.location.href=('/studentManagerMybatis/tea/InsertCou.jsp')"/></td>
  					</tr>
			  		<%
			   			while(list.hasNext()){
						Course cou = list.next();
			   		%>
  					<tr>
  					<td><%= cou.getCno() %></td>
  					<td><%= cou.getCname() %></td>
  					<td><%= cou.getCcredit() %></td>
  					<td><%= cou.getCclassroom() %></td>  					
  					<td><input  class="btn" type="button" value="修改课程" onClick="window.location.href=('/studentManagerMybatis/tea/updateCou.jsp?course.cno=<%= cou.getCno() %>')"></td>
  					<td><form action="course/DeleteCou?course.cno=<%= cou.getCno() %>" method="post"><input class="btn" type="submit" value="删除课程"></form> </td>
  					</tr>
		  				<%
		   			}
		   		}
		    %>
  				</table>
				
			</div>
		</div>
	</div>
</div>
</body>
</html>
