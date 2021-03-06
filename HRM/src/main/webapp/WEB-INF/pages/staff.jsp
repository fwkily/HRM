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
    <div id="d4">
        <form action="staff" method="post">
            <select name="d_id" id="d_id">
                <option value="0">部门</option>
                <c:forEach items="${departments}" var="department">
                    <option value="${department.d_id}">${department.d_name}</option>
                </c:forEach>
            </select>
            <select name="j_id" id="j_id">
                <option value="0">职位</option>
            </select>
            <select name="s_state" id="s_state">
                <option value="-1">在职状态</option>
                <option value="1">在职</option>
                <option value="0">实习</option>
                <option value="2">离职</option>
            </select>
            <input type="submit" value="确认"/>
        </form>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">员工ID</th>
                    <th width="40px">姓名</th>
                    <th width="40px">性别</th>
                    <th width="40px">入职状态</th>
                    <th width="40px">生日</th>
                    <th width="40px">手机号</th>
                    <th width="40px">email</th>
                    <th width="80px">部门</th>
                    <th width="120px">职位</th>
                </tr>
                <c:forEach items="${staffs}" var="staff" varStatus="loop">
                    <tr >
                        <td>${staff.s_id}</td>
                        <td>${staff.s_name}</td>
                        <td>${staff.s_sex}</td>
                        <td>${staff.s_state==1?"在职":staff.s_state==0?"实习":"离职"}</td>
                        <td>${DateAndString.dateToStringTime(staff.s_birthday)}</td>
                        <td>${staff.s_phone}</td>
                        <td>${staff.s_email}</td>
                        <td>${staff.department.d_name}</td>
                        <td>${staff.job.j_name}</td>
                    </tr>
                </c:forEach>
                <tr><td colspan="6">
                </td>
                    <td colspan="2" id="str" style="color: red"></td>
                </tr>
            </table>
        </div>
        <div id="d32" >
            <a href="staff?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="staff?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="staff?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="staff?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
