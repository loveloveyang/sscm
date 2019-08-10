<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <meta charset="UTF-8">
    <title>学生选课信息管理系统-信息查询</title>
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
    <div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
<div class="main">
    <div class="main_left">
        <div class="main_left_class00"><img src=img/touxiang.png></div>
        <div class="main_left_class01"><a href="selectCouPage">选课管理</a></div>
        <div class="main_left_class02"><a href="selectStuPage">学生信息</a></div>
        <div class="main_left_class03"><a href="queryPage">信息查询</a></div>
        <div class="main_left_class100">
            <input class="reset" type="button" value="注销"
                   onClick="window.location.href=('/maven_StuManager_web/logout')">
        </div>
    </div>
    <c:if test="${empty sessionScope.teacher}">
        <c:redirect url="/login.jsp"></c:redirect>
    </c:if>
    <div class="main_right">
        <div class="info">
            <p>亲爱的${teacher.tname}老师，下午好</p>
        </div>
        <div class="box">
            <div class="function"><p>[通知]选课系统已开放</p></div>
            <div class="form">
                <div class="form_1">

                    <form action="query" method="post">
                        <table class="form_1_table">
                            <tr>
                                <td><input class="text" type="text" name="queryKey" placeholder="请输入查询项"/></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <select name="choiceType">
                                        <option value="1">学号</option>
                                        <option value="2">姓名</option>
                                        <option value="3">班级</option>
                                        <option value="4">课程名</option>
                                        <option value="5">课程号</option>
                                        <option value="6">上课教室</option>
                                    </select>
                                </td>
                                <td><input class="btn" type="submit" value="查询"/></td>
                            </tr>
                        </table>
                    </form>

                    <c:if test="${not empty quertResults}">
                        <c:forEach items="${quertResults}" var="quertResult">
                            <table>
                                <tr>
                                    <td>学号</td>
                                    <td>学生姓名</td>
                                    <td>学生班级</td>
                                    <td>课程号</td>
                                    <td>课程名</td>
                                    <td>上课教室</td>
                                </tr>
                                <tr>
                                    <td>${quertResult.sno}</td>
                                    <td>${quertResult.sname}</td>
                                    <td>${quertResult.sclass}</td>
                                    <td>${quertResult.cno}</td>
                                    <td>${quertResult.cname}</td>
                                    <td>${quertResult.cclassroom}</td>
                                </tr>

                            </table>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty choiceResult}">
                        <table><p>结果为空，选课关系不存在 或输入项错误</p></table>
                    </c:if>


                </div>
            </div>



            <div class="form_1">
                <form action="tea/selectStu.jsp" method="post">
                    <table>
                        <tr>
                            <td>最低修读学分</td>
                            <td><input class="text" type="text" name="minScredit"
                                       value="${MinScredit}"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>最高修读学分</td>
                            <td><input class="text" type="text" name="minScredit"
                                       value="${MaxScredit}"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input class="btn" type="submit" value="确认修改"/></td>
                        </tr>
                    </table>
                </form>
                <table>
                    <tr>
                        <th>学分总数低于${MinScredit}的学生:</th>
                    </tr>
                    <tr>
                        <td>学生编号</td>
                        <td>学生名称</td>
                        <td>登录密码</td>
                        <td>所在班级</td>
                        <td>学生性别</td>
                        <td>学分数</td>
                    </tr>
                    <c:forEach items="#{students}" var="stu">
                        <c:if test="${Float.parseFloat(stu.scredit)<MinScredit}">
                            <tr>
                                <td>${stu.sno}</td>
                                <td>${stu.sname}</td>
                                <td>${stu.spassword}</td>
                                <td>${stu.sclass}</td>
                                <td>${stu.ssex}</td>
                                <td>${stu.scredit}</td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>
            </div>



        </div>
    </div>
</div>
</body>
</html>

