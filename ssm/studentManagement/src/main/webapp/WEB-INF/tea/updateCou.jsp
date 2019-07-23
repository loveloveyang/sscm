<%@page import="com.daoimpl.CouDaoImpl"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.util.MybatisSessionFactory"%>
<%@ page language="java"
	import="java.util.*,com.vo.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>学生选课信息管理系统-修改课程信息</title>
<link href="style_1.css" type="text/css" rel="stylesheet" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<%
		Teacher tea = null;
		if (session.getAttribute("teacher") == null) {
			response.sendRedirect("/Ten/Login.jsp");
		} else {
			tea = (Teacher) session.getAttribute("teacher");
		}
	%>
	<div class="top">
		<div class="title">
			<p>学生选课信息管理系统</p>
		</div>
	</div>
	<div class="main">
		<div class="main_left">
			<div class="main_left_class00">
				<img src=img/touxiang.png>
			</div>
			<div class="main_left_class01">
				<a href="tea/selectCou.jsp">选课管理</a>
			</div>
			<div class="main_left_class02">
				<a href="tea/selectStu.jsp">学生信息</a>
			</div>
			<div class="main_left_class03">
				<a href="Query.jsp">信息查询</a>
			</div>
			<div class="main_left_class100">
				<form action="login/DoLogoutAction" method="post"><input class="reset" type="submit" value="注销"></form>
			</div>
		</div>
		<div class="main_right">
			<div class="info">
				<p>
					亲爱的<%=tea.getTname()%>老师，下午好
				</p>
			</div>
			<div class="box">
				<div class="function">
					<p>[通知]选课系统已开放</p>
				</div>
				<div class="form">
					<div class="form_1">
						<form action="course/DoUpdateCou" method="post">
							<%
							SqlSession mysession=MybatisSessionFactory.getSession();
							CouDaoImpl coudao=mysession.getMapper(CouDaoImpl.class);
							Course cou=coudao.selectCouCno(Integer.parseInt(request.getParameter("course.cno")));
							if (cou != null) {
							%>
							<table>
								<tr><td></td></tr>
								<tr>
									<td>课程编号</td>
									<td><input class="text" type="text" name="course.cno"
										value="<%=cou.getCno()%>" readonly="true" /></td>
								</tr>
								<tr>
									<td>课程名称</td>
									<td><input class="text" type="text" name="course.cname"
										value="<%=cou.getCname()%>" /></td>
									<td><span><s:fielderror><s:param>course.cname</s:param></s:fielderror></span></td>
								</tr>
								<tr>
									<td>课程学分</td>
									<td><input class="text" type="text" name="course.ccredit"
										value="<%=cou.getCcredit()%>" /></td>
									<td><span><s:fielderror><s:param>course.ccredit</s:param></s:fielderror></span></td>
								</tr>
								<tr>
									<td>课程教室</td>
									<td><input class="text" type="text" name="course.cclassroom"
										value="<%=cou.getCclassroom()%>" /></td>
									<td><span><s:fielderror><s:param>course.cclassroom</s:param></s:fielderror></span></td>
								</tr>
								<tr>
									<td></td>
									<td><input class="btn" type="submit" value="确认修改" /> 
									<input class="btn" type="button" value="取消修改" onClick="window.location.href=('/studentManagerMybatis/tea/selectCou.jsp')"></td>
								</tr>
								<%
			   			}else {request.getRequestDispatcher("SelectCou?page="+null+"").forward(request, response);	}	
			   		%>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
