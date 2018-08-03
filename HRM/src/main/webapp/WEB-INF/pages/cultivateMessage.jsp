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
            $("#d_id").change(function () {
                var d_id=parseInt($(this).val());
                $.ajax({
                    type:"post",
                    url:"loadJob",
                    data:{d_id:d_id},
                    success:function (jobs) {//成功后回调函数
                        $("#j_id").empty();
                        $("#j_id").append("<option value='0'>部门</option>");
                        $(jobs).each(function (i) {
                            $("#j_id").append("<option value="+jobs[i].j_id+">"+jobs[i].j_name+"</option>");
                        })
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
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="80px">主题</th>
                    <th width="120px">内容</th>
                    <th width="100px">开始时间</th>
                    <th width="60px">结束时间</th>
                    <th width="150px">地点</th>
                    <th width="200px">发布时间</th>
                </tr>
                <c:forEach items="${cultivates}" var="cultivate" varStatus="loop">
                    <tr >
                        <td>${cultivate.c_id}</td>
                        <td>${cultivate.c_theme}</td>
                        <td>${cultivate.c_content}</td>
                        <td>${DateAndString.dateToStringTime(cultivate.c_begintime)}</td>
                        <td>${DateAndString.dateToStringTime(cultivate.c_endtime)}</td>
                        <td>${cultivate.c_address}</td>
                        <td>${DateAndString.dateToStringTime(cultivate.c_issuetime)}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="cultivateMessage?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="cultivateMessage?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="cultivateMessage?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="cultivateMessage" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
