<%@ page import="com.gwy.util.DateAndString" %>
<%@ page import="com.gwy.model.Job" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/24/0024
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="resources/css/index.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $("#on").click(function () {
                $.ajax({
                    type:"post",
                    url:"on",
                    data:{},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#off").click(function () {
                $.ajax({
                    type:"post",
                    url:"off",
                    data:{},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="staffDetail">&emsp;${staff.s_username}</a>
        </div>
        <div id="d12">
            <a href="staff" style="color: red">员工信息&emsp;</a>
            <a href="cultivateMessage" >培训通知&emsp;</a>
            <a href="rapMessage">奖惩&emsp;</a>
            <a href="attendanceMessage">考勤&emsp;</a>
            <a href="payMessage">薪资&emsp;</a>
        </div>
    </div>
    <div id="d4">
        <input type="button" value="上班打卡" id="on"/>
        <input type="button" value="下班打卡" id="off"/>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">考勤ID</th>
                    <th width="40px">考勤日期</th>
                    <th width="40px">上班时间</th>
                    <th width="40px">下班时间</th>
                    <th width="40px">状态</th>
                </tr>
                <c:forEach items="${attendances}" var="attendance" varStatus="loop">
                    <tr >
                        <td>${attendance.a_id}</td>
                        <td>${DateAndString.dateToString(attendance.a_date)}</td>
                        <td>${DateAndString.dateToStringTime(attendance.on_time)}</td>
                        <td>${attendance.off_time==null?null:DateAndString.dateToStringTime(attendance.off_time)}</td>
                        <td>${attendance.a_state==0?"上班中":attendance.a_state==1?"正常":"离职"}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="attendanceMessage?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="attendanceMessage?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="attendanceMessage?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="attendanceMessage" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
