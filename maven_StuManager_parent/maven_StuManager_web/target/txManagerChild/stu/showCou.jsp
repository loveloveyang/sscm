<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
	<%--<base href="<%=basePath%>">--%>
	<meta charset="UTF-8">
	<title>学生选课信息管理系统-正在选课</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style_tea.css">
	<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
	<script src="<%=basePath%>bootstrap/js/jquery-3.2.1.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
</head>


<body id="body">
<c:if test="${empty sessionScope.student}">
	<c:redirect url="/login.jsp"></c:redirect>
</c:if>
<div class="top">
	<div class="top-up"></div>
	<div class="top-left">
		<a class="top-left-a">
			<img src="<%=basePath%>imgs/Slogo.jpg" alt="logo" class="top-logo1">
		</a>
		<a class="top-left-a">
			<img src="<%=basePath%>imgs/StudentSelection.jpg" alt="logo" class="top-logo2">
		</a>
	</div>
	<div class="top-right">
		<div class="top-right-menu">
			<div class="dropdown" id="dropdown1">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
					个人中心
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li><a href="updateStuPassPage">账号设置</a></li>
					<li><a href="stuInfoPage">个人中心</a></li>
					<li><a href="#">帮助</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="logout">注销</a></li>
				</ul>
			</div>
		</div>
		<div class="top-right-messsge">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2">
					<a href="#">消息</a>
				</button>
			</div>
		</div>
		<div class="top-right-info">
			<p>亲爱的${student.sname}同学，下午好</p>
		</div>
	</div>
</div>
<div class="hr">
	<div class="hr-1"></div>
</div>
<div class="content">
	<div class="content-top-img">
		<img src="<%=basePath%>imgs/campus.jpg" alt="校园图">
	</div>
	<div class="content-left-menu">

		<div class="menu-top">
			<p>用户管理</p>
		</div>
		<div class="menu-content">
			<div class="menu-content-top"></div>
			<div id="menu">
				<hr>
				<h1><a href="studentPage"> 主页 </a></h1>
				<hr>
				<h1><a href="stuInfoPage"> 个人信息 </a></h1>
				<hr>
				<h1><a href="updateStuPassPage"> 修改密码 </a></h1>
				<hr>
				<h1><a href="choiceCouPage"> 选择课程 </a></h1>
				<hr>
				<h1><a href="showCouPage"> 已选课程 </a></h1>
				<hr>
			</div>
		</div>
	</div>
	<div class="content-right-contain">
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
				<table>
					<tr><td></td></tr>
					<tr>
						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>上课教室</td><td>取消选课</td>

					</tr>
					<c:forEach items="${courses}" var="courses" >
						<tr>
							<td> ${courses.cno}</td>
							<td>${courses.cname}</td>
							<td>${courses.ccredit}</td>
							<td>${courses.cclassroom}</td>
							<td><form action="delectSc?cno=${courses.cno}" method="post"><input class="cancle" type="submit" value="取消"></form></td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>


	</div>
</div>
<div class="bottom">
	<table class="bottom-table">
		<tr>
			<td>管理员信箱：×××××××××@qq.com</td>
			<td>电话查号台：×××-×××××××</td>
			<td>地址：××市××区××大学</td>
		</tr>
	</table>
	<p>版权所有 &copy2019-2020 学生选课信息系统 保留所有权利</p>
</div>

</body>

</html>
