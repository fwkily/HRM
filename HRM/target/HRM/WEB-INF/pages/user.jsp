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
            $("#send").click(function () {
                var hh=$(this).prev().val();
                alert(hh);
                return false;
            })
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;${user.uname}</a>
        </div>
        <div id="d12">
            <a href="myResume" >我的简历&emsp;</a>
            <a href="myInterview">面试管理&emsp;</a>
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
                    <th width="80px">投递简历</th>
                </tr>
                <c:forEach items="${recruitInformations}" var="recruitInformation" varStatus="loop">
                    <tr >
                            <td>${recruitInformation.riid}</td>
                            <td>${recruitInformation.department.dname}</td>
                            <td>${recruitInformation.job.jname}</td>
                            <td>${recruitInformation.job.jsalary}</td>
                            <td>${recruitInformation.riNum}</td>
                            <td>${recruitInformation.riIntro}</td>
                            <td>${DateAndString.dateToStringTime(recruitInformation.riDate)}</td>
                            <td><input type="hidden" name="riid" value="${recruitInformation.riid}" id="riid">
                                <a href="sendResume?reid=${resume.reid}" id="send">投递简历&emsp;</a>
                                </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="user?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="user?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="user?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="user" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
