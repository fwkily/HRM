<%@ page import="com.gwy.util.DateAndString" %>
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
            <a href="admin">员工管理&emsp;</a>
            <a href="myResume" >薪资管理&emsp;</a>
            <a href="organizationalManagement" >组织管理&emsp;</a>
            <a href="myInterview">考勤管理&emsp;</a>
            <a href="cultivate" style="color: red">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="myInterview">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d4">
        <a href="cultivate?i_state=0"
                <c:if test="${c_state eq 0}">
                    style="color: red"
                </c:if>>未发布&emsp;</a>
        <a href="cultivate?c_state=1"
                <c:if test="${c_state eq 1}">
                    style="color: red"
                </c:if>>发布中&emsp;</a>
        <a href="addcultivate1" style="color: red">新增培训&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="addcultivate" method="post">
            <table >
                <tr >
                    <td>主题</td>
                    <td><input type="text" name="c_theme" value="${cultivate.c_theme}"></td>
                </tr>
                <tr >
                    <td>内容</td>
                    <td><input type="text" name="c_content" value="${cultivate.c_content}"></td>
                </tr>
                <tr >
                    <td>开始时间</td>
                    <td><input type="datetime-local" name="begintime" value="${DateAndString.dateToStringTime1(cultivate.c_begintime)}"></td>
                </tr>
                <tr >
                    <td>结束时间</td>
                    <td><input type="datetime-local" name="endtime" value="${DateAndString.dateToStringTime1(cultivate.c_endtime)}"></td>
                </tr>
                <tr >
                    <td>地点</td>
                    <td><input type="text" name="c_address" value="${cultivate.c_address}"></td>
                </tr>
                <tr><input type="hidden" name="c_id" value="${cultivate.c_id}">
                    <td colspan="2"><input type="submit" value="添加或修改"></td> </tr>
            </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
