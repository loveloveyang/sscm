<%--
  Created by IntelliJ IDEA.
  User: 李洋
  Date: 2019/8/9
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script language="JavaScript">
    function ShowMenu(obj, noid) {
        var block = document.getElementById(noid);
        var n = noid.substr(noid.length - 1);
        if (noid.length == 4) {
            var ul = document.getElementById(noid.substring(0, 3)).getElementsByTagName("ul");
            var h2 = document.getElementById(noid.substring(0, 3)).getElementsByTagName("h2");
            for (var i = 0; i < h2.length; i++) {
                h2[i].innerHTML = h2[i].innerHTML.replace("+", "-");
                h2[i].style.color = "";
            }
            obj.style.color = "#0000FF";
            for (var i = 0; i < ul.length; i++) {
                if (i != n) {
                    ul[i].className = "no";
                }
            }
        } else {
            var span = document.getElementById("menu").getElementsByTagName("span");
            var h1 = document.getElementById("menu").getElementsByTagName("h1");
            for (var i = 0; i < h1.length; i++) {
                h1[i].innerHTML = h1[i].innerHTML.replace("+", "-");
                h1[i].style.color = "";
            }
            obj.style.color = "#0000FF";
            for (var i = 0; i < span.length; i++) {
                if (i != n) {
                    span[i].className = "no";
                }
            }
        }
        if (block.className == "no") {
            block.className = "";
            obj.innerHTML = obj.innerHTML.replace("-", "+");
        } else {
            block.className = "no";
            obj.style.color = "";
        }
    }

</script>
<div id="menu">
    <hr>
    <h1 onClick="javascript:ShowMenu(this,'NO0')"> - 管理员 </h1>
    <hr>
    <span id="NO0" class="no ">
                    <h2 > <a href="adminPage">主页</a></h2>
                    <h2><a href="queryPageAdmin"> 选课信息查询 </a></h2>
                    <h2 onClick="javascript:ShowMenu(this,'NO00')"> - 个人信息</h2>
                    <ul id="NO00" class="no">
                        <li><a href="updateAdminPassPage">修改账号</a></li>
                        <li><a href="adminInfo">身份信息</a></li>
                        <li><a href="#">消息</a></li>
                    </ul>
                    <h2 onClick="javascript:ShowMenu(this,'NO01')"> - 老师管理</h2>
                    <ul id="NO01" class="no">
                        <li><a href="insertTeaPage">添加老师</a></li>
                        <li><a href="selectTeaPage">老师信息查询</a></li>
                    </ul>
                    <h2 onClick="javascript:ShowMenu(this,'NO02')"> - 学生管理</h2>
                    <ul id="NO02" class="no">
                        <li><a href="insertStuPageAdmin"> 添加学生 </a></li>
                        <li><a href="selectStuPageAdmin"> 学生信息查询 </a></li>
                    </ul>
                    <h2 onClick="javascript:ShowMenu(this,'NO03')"> - 课程管理</h2>
                    <ul id="NO03" class="no">
                        <li><a href="InsertCouPageAdmin"> 添加课程 </a></li>
                        <li><a href="selectCouPageAdmin"> 课程信息查询 </a></li>
                    </ul>

                </span>
    <%--<h1 onClick="javascript:ShowMenu(this,'NO1')"> - 老师</h1>
    <hr>
    <span id="NO1" class="no">
        <h2><a href="queryPageAdmin"> 选课信息查询 </a></h2>
        </span>
    <h1 onClick="javascript:ShowMenu(this,'NO2')"> - 学生</h1>
    <hr>
    <span id="NO2" class="no">
        <h2><a href="choiceCouPageAdmin"> 选择课程 </a></h2>
        <h2><a href="showCouPageAdmin"> 已选课程 </a></h2>
    </span>--%>
</div>
