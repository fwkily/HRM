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
    <div id="d4">
        <a href="check?r_state=0&ri_id=${ri_id}"
                <c:if test="${r_state eq 0}">
                    style="color: red"
                </c:if>>未读&emsp;</a>
        <a href="check?r_state=1&ri_id=${ri_id}"
                <c:if test="${r_state eq 1}">
                    style="color: red"
                </c:if>>已读&emsp;</a>
        <a href="check?r_state=2&ri_id=${ri_id}"
                <c:if test="${r_state eq 2}">
                    style="color: red"
                </c:if>>面试&emsp;</a>
        <a href="check?r_state=3&ri_id=${ri_id}"
                <c:if test="${r_state eq 3}">
                    style="color: red"
                </c:if>>拒绝&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <c:if test="${!empty recruitInformation}" >
        <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="80px">部门</th>
                    <th width="120px">职位</th>
                    <th width="100px">基本工资</th>
                    <th width="60px">人数</th>
                    <th width="150px">简介</th>
                    <th width="200px">发布时间</th>
                </tr>
                <tr >
                        <td>${recruitInformation.ri_id}</td>
                        <td>${recruitInformation.department.d_name}</td>
                        <td>${recruitInformation.job.j_name}</td>
                        <td>${recruitInformation.job.j_salary}</td>
                        <td>${recruitInformation.ri_num}</td>
                        <td>${recruitInformation.ri_intro}</td>
                        <td>${DateAndString.dateToStringTime(recruitInformation.ri_date)}</td>
                    </tr>
            </table>
            </c:if>
            <c:forEach items="${recruits}" var="recruit" varStatus="loop">
                <c:if test="${r_state eq 0||r_state eq 1}">
                    <a href="interview?r_id=${recruit.r_id}">面试&emsp;</a><a href="refuse?r_id=${recruit.r_id}&ri_id=${recruitInformation.ri_id}" id="del">拒绝&emsp;</a>
                </c:if>

                <table >
                    <tr><th colspan="4" id="resumename">
                            ${recruit.resume.resumename}</th></tr>
                    <tr><td colspan="4">个人信息</td></tr>
                    <tr>
                        <td>姓名</td><td>${recruit.resume.re_name}</td>
                        <td>性别</td><td>${recruit.resume.re_sex}</td>
                    </tr>
                    <tr>
                        <td>身份证号</td><td>${recruit.resume.re_idcardno}</td>
                        <td>出生时间</td><td>${DateAndString.dateToString(recruit.resume.re_birthday)}</td>
                    </tr>
                    <tr><td colspan="4">教育情况</td></tr>
                    <tr>
                        <td>学历</td><td>${recruit.resume.re_education}</td>
                        <td>毕业院校</td><td>${recruit.resume.re_college}</td>
                    </tr>
                    <tr>
                        <td>专业</td><td>${recruit.resume.re_major}</td>
                        <td>毕业时间</td><td>${DateAndString.dateToString(recruit.resume.re_graduate)}</td>
                    </tr>
                    <tr><td colspan="4">联系方式</td></tr>
                    <tr>
                        <td>手机</td><td>${recruit.resume.re_phone}</td>
                        <td>电子邮箱</td><td>${recruit.resume.re_email}</td>
                    </tr>
                    <tr>
                        <td>地址</td><td>${recruit.resume.re_address}</td>
                        <td>邮编</td><td>${recruit.resume.re_post}</td>
                    </tr>
                    <tr><td colspan="4">简介</td></tr>
                    <tr>
                        <td colspan="4">${recruit.resume.re_intro}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <div id="d32" >
            <a href="check?r_state=${r_state}&ri_id=${ri_id}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="check?r_state=${r_state}&ri_id=${ri_id}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="check?r_state=${r_state}&ri_id=${ri_id}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="check?r_state=${r_state}&ri_id=${ri_id}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
