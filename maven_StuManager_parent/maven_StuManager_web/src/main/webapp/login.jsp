<%--
  Created by IntelliJ IDEA.
  User: 李洋
  Date: 2019/7/31
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课信息管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body >
<div class="container" id="back_imgs">
    <div class="row" >
        <div class="col-md-5 col-md-offset-4" style="margin-left:30%;" >
            <div class="loginForm" style="margin-top: 250px;">
                <form class="form-horizontal" action="loginUser" method="post">
                    <div class="form-group">
                        <label for="uname" class="col-sm-2 control-label" >用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="uname" name="username"
                                   placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upsw" class="col-sm-2 control-label">密&nbsp&nbsp&nbsp码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="upsw" name="password"
                                   placeholder="请输入密码" >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox1">
                                <input class="login_radio" type="radio" name="type" value="admin">管理员
                                <input class="login_radio" type="radio" name="type" value="tea">老师
                                <input class="login_radio" type="radio" name="type" value="stu">学生
                            </div>
                        </div>
                        <div class="col-sm-offset-2 col-sm-10" >
                            <div class="checkbox" id="remember_parent">
                                <label>
                                    <input type="checkbox" id="remember" name="remember"> 记住我
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10" id="login_parrent">
                                <button type="submit" class="btn btn-default" id="login">登录</button>
                            </div>

                        </div>

                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
