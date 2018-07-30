<%@ page import="com.gwy.model.Resume" %>
<%@ page import="com.gwy.util.DateAndString" %><%--
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
            $("#update").click(function () {
                return confirm("确定发送面试邀请？");
            })
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="adminLogin.jsp">&emsp;${admin.ad_name}</a>
        </div>
        <div id="d12">
            <a href="admin" >员工管理&emsp;</a>
            <a href="myResume" >薪资管理&emsp;</a>
            <a href="myInterview">考勤管理&emsp;</a>
            <a href="myInterview">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="myInterview">招聘管理&emsp;</a>
            <a href="myInterview">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="addInterview" method="post">
                <table >
                    <tr>
                        <td>面试人</td><td>
                        <select name="staff.s_id" id="s_id">
                            <c:forEach items="${staffs}" var="staff">
                                <option value="${staff.s_id}">${staff.s_name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr> <td>面试时间</td><td>
                        <input type="datetime-local" name="mi_date">
                    </td>
                    </tr>
                    <tr>
                        <td>面试地点</td><td><input type="text" name="i_address" value="公司5楼503会议室"></td>
                    </tr>
                    <tr><td colspan="2">简介</td></tr>
                    <tr><td colspan="2"><input type="text" name="i_intro" value="带好必要的资料"></td></tr>

                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="r_id"  value="${recruit.r_id}">
                            <input type="submit" value="确认" id="update"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
