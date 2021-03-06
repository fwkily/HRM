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
            <a href="myResume" >薪资管理&emsp;</a>
            <a href="organizationalManagement" >组织管理&emsp;</a>
            <a href="myInterview">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="myInterview">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr><td colspan="4">个人信息</td></tr>
                <tr>
                    <td>姓名</td><td>${staff.s_name}</td>
                    <td>性别</td><td>${staff.s_sex}</td>
                </tr>
                <tr>
                    <td>身份证号</td><td>${staff.s_idcardno}</td>
                    <td>出生时间</td><td>${DateAndString.dateToString(staff.s_birthday)}</td>
                </tr>
                <tr>
                    <td>部门</td><td>${staff.department.d_name==null?"离职":staff.department.d_name}</td>
                    <td>职位</td><td>${staff.job.j_name==null?"离职":staff.job.j_name}</td>
                </tr>
                <tr><td colspan="4">教育情况</td></tr>
                <tr>
                    <td>学历</td><td>${staff.s_education}</td>
                    <td>毕业院校</td><td>${staff.s_college}</td>
                </tr>
                <tr>
                    <td>专业</td><td>${staff.s_major}</td>
                    <td>毕业时间</td><td>${DateAndString.dateToString(staff.s_graduate)}</td>
                </tr>
                <tr><td colspan="4">联系方式</td></tr>
                <tr>
                    <td>手机</td><td>${staff.s_phone}</td>
                    <td>电子邮箱</td><td>${staff.s_email}</td>
                </tr>
                <tr>
                    <td>地址</td><td>${staff.s_address}</td>
                    <td>邮编</td><td>${staff.s_post}</td>
                </tr>
                <tr><td colspan="4">简介</td></tr>
                <tr>
                    <td colspan="4">${staff.s_intro}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
