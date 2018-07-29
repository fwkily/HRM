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
                return confirm("确认添加或更改");
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
            <form action="update" method="post">
                <table >
                    <tr>
                        <td>部门</td><td>
                        <select name="department.d_id" id="d_id">
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.d_id}"
                                    <c:if test="${department.d_id eq recruitInformation.department.d_id}">
                                        selected = "selected"
                                    </c:if>
                            >${department.d_name}</option>
                        </c:forEach>
                    </select></td>
                    </tr>
                    <tr> <td>职位</td><td>
                        <select name="job.j_id" id="j_id">
                            <c:forEach items="${jobs}" var="job">
                                <option value="${job.j_id}"
                                <c:if test="${job.j_id eq recruitInformation.job.j_id}">
                                    selected = "selected"
                                </c:if>
                                >${job.j_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    </tr>
                    <tr>
                        <td>人数</td><td><input type="number" name="ri_num" value="${recruitInformation.ri_num}"></td>
                    </tr>
                    <tr><td >简介</td><td ><input type="text" name="ri_intro" value="${recruitInformation.ri_intro}"></td></tr>

                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="ri_id" min="1" value="${recruitInformation.ri_id==null?0:recruitInformation.ri_id}">
                            <input type="submit" value="确认" id="update"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
