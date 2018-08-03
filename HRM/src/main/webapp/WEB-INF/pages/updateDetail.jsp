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

        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="staffDetail" style="color: red">&emsp;${staff.s_username}</a>
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
            <form action="updateD" method="post">
                <table >
                    <tr><td colspan="4">个人信息</td></tr>
                    <tr>
                        <td>姓名</td><td><input type="text" name="s_name" value="${staff.s_name}"></td>
                        <td>性别</td><td><input type="text" name="s_sex" value="${staff.s_sex}"></td>
                    </tr>
                    <tr>
                        <td>身份证号</td><td><input type="text" name="s_idcardno" value="${staff.s_idcardno}"></td>
                        <td>出生时间</td><td><input type="date" name="s_birthday" value="${DateAndString.dateToString(staff.getS_birthday())}"></td>
                    </tr>
                    <tr><td colspan="4">教育情况</td></tr>
                    <tr>
                        <td>学历</td><td><input type="text" name="s_education" value="${staff.s_education}"></td>
                        <td>毕业院校</td><td><input type="text" name="s_college" value="${staff.s_college}"></td>
                    </tr>
                    <tr>
                        <td>专业</td><td><input type="text" name="s_major" value="${staff.s_major}"></td>
                        <td>毕业时间</td><td><input type="date" name="s_graduate" value="${DateAndString.dateToString(staff.getS_graduate())}"></td>
                    </tr>
                    <tr><td colspan="4">联系方式</td></tr>
                    <tr>
                        <td>手机</td><td><input type="text" name="s_phone" value="${staff.s_phone}"></td>
                        <td>电子邮箱</td><td><input type="text" name="s_email" value="${staff.s_email}"></td>
                    </tr>
                    <tr>
                        <td>地址</td><td><input type="text" name="s_address" value="${staff.s_address}"></td>
                        <td>邮编</td><td><input type="text" name="s_post" value="${staff.s_post}"></td>
                    </tr>
                    <tr><td colspan="4">简介</td></tr>
                    <tr>
                        <td colspan="4"><input type="text" name="s_intro" value="${staff.s_intro}"></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="hidden" name="s_id" value="${staff.s_id}">
                            <input type="submit" value="修改" ></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
