<%--
  Created by IntelliJ IDEA.
  User: 李洋
  Date: 2019/8/2
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生选课信息管理系统-课程信息</title>
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
<c:if test="${empty sessionScope.teacher}">
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
            <p>亲爱的${teacher.tname}老师，下午好</p>
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
            <%@include file="/page/teaMenuPage.jsp"%>
        </div>
    </div>
    <div class="content-right-contain">
        <div class="box">
            <div class="function"><p>[通知]选课系统已开放</p></div>
            <div class="form">
                <div class="form_1">
                    <form action="updateStu" method="post">
                        <table>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td>学生学号</td>
                                <td><input class="text" type="text" name="sno" value="${students.sno}"
                                           readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>学生姓名</td>
                                <td><input class="text" type="text" name="sname" value="${students.sname}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>学生密码</td>
                                <td><input class="text" type="text" name="spassword"
                                           value="${students.spassword}"/></td>
                            </tr>
                            <tr>
                                <td>学生班级</td>
                                <td><input class="text" type="text" name="sclass" value="${students.sclass}"/>
                                </td>
                            <tr>
                                <td>学生性别</td>
                                <td><input class="text" type="text" name="ssex" value="${students.ssex}"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="btn" type="submit" value="确认修改"/> <input class="btn" type="reset"
                                                                                           value="取消修改"
                                                                                           onClick="window.location.href=('selectStuPage')"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>

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