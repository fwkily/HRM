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
            $(".dimission").click(function () {
                var s_id=parseInt($(this).siblings().eq(0).val());
                var s_intro=prompt("请输入离职理由","");
                if (s_intro==null){
                    return false;
                }
                alert(s_intro);
                $.ajax({
                    type:"post",
                    url:"dimission",
                    data:{s_id:s_id,s_intro:s_intro},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $(".positive").click(function () {
                var s_id=parseInt($(this).siblings().eq(0).val());
                var s_intro=prompt("请输入评价","");
                if (s_intro==""){
                    alert("评价为空");
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"positive",
                    data:{s_id:s_id,s_intro:s_intro},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $(".change").click(function () {
                var s_id=parseInt($(this).siblings().eq(0).val());
                var d_id=parseInt($("#d_id").val());
                var j_id=parseInt($("#j_id").val());
                if (d_id==0||j_id==0){
                    alert("请选择部门职位");
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"change",
                    data:{s_id:s_id,d_id:d_id,j_id:j_id},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#payCalculation").click(function () {
                $.ajax({
                    type:"post",
                    url:"payCalculation",
                    data:{},
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
            <a href="admin" style="color: red">员工管理&emsp;</a>
            <a href="pay" >薪资管理&emsp;</a>
            <a href="organizationalManagement" >组织管理&emsp;</a>
            <a href="attendanceInformation">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="rap">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d4">
        <form action="admin" method="post">
            <select name="d_id" id="d_id">
                <option value="0">部门</option>
                <c:forEach items="${departments}" var="department">
                    <option value="${department.d_id}">${department.d_name}</option>
                </c:forEach>
            </select>
            <select name="j_id" id="j_id">
                <option value="0">职位</option>
            </select>
            <input type="submit" value="确认"/>
        </form>
        <input type="button" id="payCalculation" value="工资结算"/>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">薪资ID</th>
                    <th width="40px">结算日期</th>
                    <th width="40px">员工ID</th>
                    <th width="40px">基本工资</th>
                    <th width="40px">绩效</th>
                    <th width="40px">加班</th>
                    <th width="40px">奖惩</th>
                    <th width="40px">社保</th>
                    <th width="40px">实际工资</th>
                    <th width="80px">状态</th>
                    <th width="120px">说明</th>
                    <th width="60px">操作</th>
                </tr>
                <c:forEach items="${pays}" var="pay" varStatus="loop">
                    <tr >
                        <td>${pay.p_id}</td>
                        <td>${DateAndString.dateToString(pay.p_date)}</td>
                        <td>${pay.staff.s_id}</td>
                        <td>${pay.p_base}</td>
                        <td>${pay.p_performance}</td>
                        <td>${pay.p_overtime}</td>
                        <td>${pay.p_rap}</td>
                        <td>${pay.p_ss}</td>
                        <td>${pay.p_pay}</td>
                        <td>${pay.p_state==0?"待确定":pay.p_state==0?"正常":"待处理"}</td>
                        <td>${pay.p_intro}</td>
                        <td><input type="hidden" name="p_id" value="${pay.p_id}">
                            <c:if test="${pay.p_state eq 0}">
                                <input type="button" value="无误" class="right">
                                <input type="button" value="处理" class="dispose">
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="pay?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="pay?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="pay?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="pay?d_id=${d_id}&j_id=${j_id}&s_state=${s_state}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
