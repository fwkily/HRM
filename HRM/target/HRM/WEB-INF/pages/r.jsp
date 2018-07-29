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
            <a href="admin" >员工管理&emsp;</a>
            <a href="myResume" >薪资管理&emsp;</a>
            <a href="myInterview">考勤管理&emsp;</a>
            <a href="myInterview">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="myInterview">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="80px">部门</th>
                    <th width="120px">职位</th>
                    <th width="100px">基本工资</th>
                    <th width="60px">人数</th>
                    <th width="150px">简介</th>
                    <th width="200px">发布时间</th>
                    <th width="180px">操作</th>
                </tr>
                <c:forEach items="${recruitInformations}" var="recruitInformation" varStatus="loop">
                    <tr >
                        <td>${recruitInformation.ri_id}</td>
                        <td>${recruitInformation.department.d_name}</td>
                        <td>${recruitInformation.job.j_name}</td>
                        <td>${recruitInformation.job.j_salary}</td>
                        <td>${recruitInformation.ri_num}</td>
                        <td>${recruitInformation.ri_intro}</td>
                        <td>${DateAndString.dateToStringTime(recruitInformation.ri_date)}</td>
                        <td>
                            <a href="check?ri_id=${recruitInformation.ri_id}">查看简历</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="r?ri_state=${ri_state}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="r?ri_state=${ri_state}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="r?ri_state=${ri_state}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="r?ri_state=${ri_state}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
