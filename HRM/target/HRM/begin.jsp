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
            $(".a1").click(function(){
                alert("使用前请登录");
            });
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;亲，请登录</a>
            <a href="register.jsp">&emsp;免费注册</a>
        </div>
        <div id="d12">
            <a href="staffLogin.jsp" >员工登录&emsp;</a>
            <a href="adminLogin.jsp">管理员登录&emsp;</a>
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
                            <td>${recruitInformation.ri_id}</td>
                            <td>${recruitInformation.department.d_name}</td>
                            <td>${recruitInformation.job.j_name}</td>
                            <td>${recruitInformation.job.j_salary}</td>
                            <td>${recruitInformation.ri_Num}</td>
                            <td>${recruitInformation.ri_Intro}</td>
                            <td>${DateAndString.dateToStringTime(recruitInformation.ri_Date)}</td>
                            <td><input style="width: 80px" class="a1" type="button" value="投递简历"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="index?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="index?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="index?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="index" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
