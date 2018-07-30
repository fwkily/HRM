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
            $(".hire").click(function () {
                var i_id=parseInt($(this).prev().val());
                alert(i_id)
                if (!confirm("确认录用")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"hire",
                    data:{i_id:i_id},
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
        <a href="interviewManage?i_state=0&ri_id=${ri_id}"
                <c:if test="${i_state eq 0}">
                    style="color: red"
                </c:if>>邀请中&emsp;</a>
        <a href="interviewManage?i_state=1&ri_id=${ri_id}"
                <c:if test="${i_state eq 1}">
                    style="color: red"
                </c:if>>参加&emsp;</a>
        <a href="interviewManage?i_state=2&ri_id=${ri_id}"
                <c:if test="${i_state eq 2}">
                    style="color: red"
                </c:if>>拒绝&emsp;</a>
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
                    <th width="150px">招聘简介</th>
                    <th width="200px">面试时间</th>
                    <th width="200px">面试地址</th>
                    <th width="80px">面试官</th>
                    <c:if test="${i_state eq 0}">
                        <th width="80px">面试官</th>
                    </c:if>
                </tr>
                <c:forEach items="${interviews}" var="interview" varStatus="loop">
                    <tr >
                        <td>${interview.i_id}</td>
                        <td>${interview.recruit_Information.department.d_name}</td>
                        <td>${interview.recruit_Information.job.j_name}</td>
                        <td>${interview.recruit_Information.job.j_salary}</td>
                        <td>${interview.recruit_Information.ri_num}</td>
                        <td>${interview.recruit_Information.ri_intro}</td>
                        <td>${DateAndString.dateToStringTime(interview.i_date)}</td>
                        <td>${interview.i_address}</td>
                        <td>${interview.staff.s_name}</td>
                        <c:if test="${i_state eq 1}">
                            <td><input type="hidden" name="i_id" value="${interview.i_id}" id="i_id">
                                <input type="button" value="录用" class="hire">
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="interviewManage?i_state=${i_state}&ri_id=${ri_id}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="interviewManage?i_state=${i_state}&ri_id=${ri_id}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="interviewManage?i_state=${i_state}&ri_id=${ri_id}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="interviewManage?i_state=${i_state}&ri_id=${ri_id}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
