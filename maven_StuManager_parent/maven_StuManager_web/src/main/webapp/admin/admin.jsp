1<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
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
            <div class="form">
                <table class="news">
                    <tr>
                        <td><h2>关于本学期校级任选课相关事宜安排的通知</h2></td>
                    </tr>
                    <tr>
                        <td>各学院及相关单位:</td>
                    </tr>
                    <tr>
                        <td>根据学校教学安排，本学期全校任选课定于6月20日（星期五） 正式开课，选课工作将从6月16日开始。现将有关事项通知如下：</td>
                    </tr>
                    <tr>
                        <td>一、选课时间：6月16日----6月20日</td>
                    </tr>
                    <tr>
                        <td>二、学生登录选课信息管理系统后进入学生选课进行选课。学生选课前请认真阅读选课公告，再进行“网上选课”。</td>
                    </tr>
                    <tr>
                        <td>三、教师可登陆选课信息管理系统后进入选课管理增删课程， 6月15日14:00之后各位教师及学生登录教务处网站查询自己申报的课程是否停开。</td>
                    </tr>
                    <tr>
                        <td>四、选课退课均须在选课时间内完成，选课结束后不再进行补退选，请学生注意选课时间。</td>
                    </tr>
                    <tr>
                        <td>五、请各学院通知并组织学生进行选课，同时请各学院及相关单位通知任课教师按时上课。教务处将组织相关人员对上课情况进行不定期的检查。</td>
                    </tr>
                    <tr>
                        <td align="right">2019-06-10</td>
                    </tr>
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
