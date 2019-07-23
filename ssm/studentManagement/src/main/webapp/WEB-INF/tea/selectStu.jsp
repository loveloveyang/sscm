<%@page import="com.daoimpl.StuDaoImpl"%>
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
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-学生信息</title>
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
  <%
  	Teacher tea = null;
    	if(session.getAttribute("teacher")==null){
    	response.sendRedirect("../Login.jsp");
    	}else{
    	tea = (Teacher) session.getAttribute("teacher");
    	}
  %>
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
						if(request.getParameter("sumary")!=null&&request.getParameter("maxscore")!=null){
												Student.summary = Float.parseFloat(request.getParameter("sumary"));
												Student.MAXscore = Float.parseFloat(request.getParameter("maxscore"));
												}
												SqlSession mysession=MybatisSessionFactory.getSession();
												StuDaoImpl studao=mysession.getMapper(StuDaoImpl.class);
												List<Student> list1=studao.selectStu();
												/* List<Student> list2=null;
												for(int i=0;i<list1.size();i++){
												list2.add(new Student(list1.get(i).getSname(),list1.get(i).getSpassword()));
												} */
												Iterator<Student> ite1 = list1.iterator();
					%>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= tea.getTname() %>老师，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>学生编号</td><td>学生名称</td><td>登录密码</td><td>所在班级</td><td>学生性别</td><td>学分数</td>
  						<td><input class="btn" type="button" value="添加学生" onclick="window.location.href=('/studentManagerMybatis/tea/InsertStu.jsp')"/></td>
  					</tr>
			  		<%
			   			while(ite1.hasNext()){
						Student stu = ite1.next();
			   		%>
  					<tr>
  					<td><%= stu.getSno() %></td>
  					<td><%= stu.getSname() %></td>
  					<td><%= stu.getSpassword() %></td>
  					<td><%= stu.getSclass() %></td>
  					<td><%= stu.getSsex() %></td>
  					<td><%= stu.getScredit() %></td>
  					<td><input class="btn" type="button" value="修改信息"  onclick="window.location.href=('/studentManagerMybatis/tea/updateStu.jsp?id=<%= stu.getSno() %>')"></td>
  					<td><form action="student/DeleteStuAction?student.sno=<%=stu.getSno()%>" method="post"><input class="btn" type="submit" value="删除信息"></form> </td>
  					</tr>
  					<%} %>
  				</table>
  			<div class="form_1">
  				<form action="tea/selectStu.jsp" method="post">
				<table>
				<tr><td>最低修读学分</td><td><input class="text" type="text" name="student.sumary" value="<%= Student.summary %>"/></td><td></td>
				</tr>
				<tr><td>最高修读学分</td><td><input class="text" type="text" name="student.maxscore" value="<%= Student.MAXscore %>"/></td><td></td>
				</tr>
				<tr><td><input  class="btn" type="submit" value="确认修改"/></td></tr>
				</table>
				</form>
				
				<%
				Iterator<Student> ite2 = list1.iterator();%>
				<table>
				<tr><th>学分总数低于<%= Student.summary %>的学生:</th></tr>
				<tr>
  						<td>学生编号</td><td>学生名称</td><td>登录密码</td><td>所在班级</td><td>学生性别</td><td>学分数</td>
  						
  					</tr>
  				<%
				while(ite2.hasNext()){
				Student stu = ite2.next();
				if(stu.getScredit()<Student.summary){
				 %>
  					<tr>
  					<td><%= stu.getSno() %></td>
  					<td><%= stu.getSname() %></td>
  					<td><%= stu.getSpassword() %></td>
  					<td><%= stu.getSclass() %></td>
  					<td><%= stu.getSsex() %></td>
  					<td><%= stu.getScredit() %></td>
  					</tr>
  					<%
  					}
  					} %>
				</table>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
