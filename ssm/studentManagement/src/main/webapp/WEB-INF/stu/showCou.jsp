<%@page import="com.vo.Course"%>
<%@page import="com.daoimpl.ScDaoImpl"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.util.MybatisSessionFactory"%>
<%@ page language="java" import="java.util.*,com.vo.Student" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-显示已选课程</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
		<div class="main_left_class01"><a href="stu/choiceCou.jsp">学生选课</a></div>
		<div class="main_left_class02"><a href="stu/showCou.jsp">课程查询</a></div>
		<div class="main_left_class03"><a href="stu/stuInfo.jsp">学籍信息</a></div>
		<div class="main_left_class100">
		<form action="login/DoLogoutAction" method="post"><input class="reset" type="submit" value="注销"></form>
		</div>
	</div>
					<%
			    	Student stu = null;
			    	if(session.getAttribute("student")==null){
			    		response.sendRedirect("/Ten/Login.jsp");
			    	}else{
			    		stu = (Student)session.getAttribute("student");%>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= stu.getSname() %>同学，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>上课教室</td><td>取消选课</td>
  						
  					</tr>
			  		<%
			  			SqlSession mysession=MybatisSessionFactory.getSession();
			  			ScDaoImpl scdao=mysession.getMapper(ScDaoImpl.class);
			  			List<Course> list1=scdao.selectSc(stu.getSno());
			  			Iterator<Course> list=list1.iterator();
			  			   	Course cou = null;
			  			   	while(list.hasNext()){
			  			   		cou = list.next();
			  		%>
  					<tr>
  					<td><%= cou.getCno() %></td>
  					<td><%= cou.getCname() %></td>
  					<td><%= cou.getCcredit() %></td>
  					<td><%= cou.getCclassroom() %></td>
  					<td><form action="sc/DeleteScAction?sc.cno=<%= cou.getCno() %>" method="post"><input class="cancle" type="submit" value="取消"></form></td>
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
