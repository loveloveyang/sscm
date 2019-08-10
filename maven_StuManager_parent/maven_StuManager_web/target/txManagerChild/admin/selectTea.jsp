<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生选课信息管理系统-正在选课</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style_admin.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
    <script src="<%=basePath%>bootstrap/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
</head>


<body id="body">
<c:if test="${empty sessionScope.admin}">
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
                    <li><a href="#">账号设置</a></li>
                    <li><a href="#">个人中心</a></li>
                    <li><a href="#">帮助</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">注销</a></li>
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
            <p>亲爱的${admin.aname}管理员，下午好</p>
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
            <%@include file="/page/adminMenuPage.jsp"%>
        </div>

    </div>
    <div class="content-right-contain">
        <div class="box">
            <div class="function"><p>[通知]选课系统已开放</p></div>
            <div class="function-right">
                <form action="teacherQuery" method="post">
                    <label for="queryKey" class="label-query">老师查询</label>
                    <input type="text" name="queryKey" id="queryKey" placeholder="请输入查询项" class="querykey">
                    <select name="choiceType">
                        <option value="1">老师工号</option>
                        <option value="2">老师名字</option>
                        <option value="3">老师学院</option>
                        <option value="4">性别</option>
                    </select>
                    <input type="submit" value="查询" class="submit">
                </form>
            </div>
            <div class="form">
                <table>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>老师编号</td>
                        <td>老师名</td>
                        <td>登录密码</td>
                        <td>老师性别</td>
                        <td>老师电话</td>
                        <td>老师学院</td>
                        <td>老师邮箱</td>
                    </tr>
                    <c:forEach items="${teachers}" var="teachers">
                        <tr>
                            <td>${teachers.tno}</td>
                            <td>${teachers.tname}</td>
                            <td>${teachers.tpassword}</td>
                            <td>${teachers.tsex}</td>
                            <td>${teachers.ttelephone}</td>
                            <td>${teachers.tcollege}</td>
                            <td>${teachers.temail}</td>
                            <td><input class="btn" type="button" value="修改信息"
                                       onclick="window.location.href=('updateTeaPage?tno=${teachers.tno}')">
                            </td>
                            <td>
                                <form action="deleteTea?tno=${teachers.tno}" method="post"><input
                                        class="btn" type="submit" value="删除信息"></form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="page-break">
                    <%@include file="/page/pagination.jsp" %>
                </div>
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
