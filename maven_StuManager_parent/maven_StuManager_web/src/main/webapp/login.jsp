<%--
  Created by IntelliJ IDEA.
  User: 李洋
  Date: 2019/7/18
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课信息管理系统</title>
    <link href="style.css" type="text/css" rel="stylesheet"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<div class="login_bg">
    <div class="login_box">
        <div class="login_logo">
            <img class="login_logo_icon" src="img/Slogo.png" alt=""/>
            <img class="login_logo_text" src="img/StudentSelection.png" alt=""/>
        </div>
        <div class="login_line"></div>
        <div class="login_content">
            <h2>学生选课信息管理系统</h2>
            <p>Student Selection Management System</p>
            <form action="dologin/login?type=stu" method="post">
                <div class="login_input">
                    <input type="text" placeholder="请输入学号" class="login_username" name="username">
                </div>
                <div class="login_input">
                    <input type="password" placeholder="请输入密码" class="login_password" name="password">
                </div>
                <div class="">
                    <input class="login_btn sure" type="submit" value="登录">
                    <input class="login_btn cancle" type="button" value="教师入口 "
                           onclick="window.location.href='tea/teaLogin.jsp'">
                </div>
            </form>
        </div>
    </div>
    <div class="text"><p>版权所有 ©2017-2018 学生选课信息系统 保留所有权利</p></div>
</div>
</body>
</html>
