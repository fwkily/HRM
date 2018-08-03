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
                        $("#j_id").append("<option value='0'>职位</option>");
                        $(jobs).each(function (i) {
                            $("#j_id").append("<option value="+jobs[i].j_id+">"+jobs[i].j_name+"</option>");
                        })
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#deld").click(function () {
                var d_id=parseInt($("#d_id").val());
                if(d_id==0){
                    alert("未选择部门");
                    return false;
                }
                if(!confirm("确认删除该部门")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"deld",
                    data:{d_id:d_id},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#delj").click(function () {
                var j_id=parseInt($("#j_id").val());
                if(j_id==0){
                    alert("未选择职位");
                    return false;
                }
                if(!confirm("确认删除该职位")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"delj",
                    data:{j_id:j_id},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#saved").click(function () {
                var d_id=parseInt($("#d_id").val());
                var d_name=$("#d_name").val();
                if (d_name==null||d_name==""){
                    alert("部门名不能为空");
                    return false;
                }
                if(d_id==0){
                    if(!confirm("确认添加该部门")){
                        return false;
                    }
                    $.ajax({
                        type:"post",
                        url:"addd",
                        data:{d_name:d_name},
                        success:function (obj) {//成功后回调函数
                            alert(obj);
                            location.reload(true);
                        },
                        error:function (obj) {

                        }
                    })
                }else{
                    if(!confirm("确认修改该部门")){
                        return false;
                    }
                    $.ajax({
                        type:"post",
                        url:"updated",
                        data:{d_id:d_id,d_name:d_name},
                        success:function (obj) {//成功后回调函数
                            alert(obj);
                            location.reload(true);
                        },
                        error:function (obj) {

                        }
                    })
                }
            })
            $("#savej").click(function () {
                var d_id=parseInt($("#d_id").val());
                var j_id=parseInt($("#j_id").val());
                var j_name=$("#j_name").val();
                var j_salary=parseFloat($("#j_salary").val());
                if (j_name==null||j_name==""){
                    alert("部门名不能为空");
                    return false;
                }
                if(d_id==0){
                    alert("必须选择部门")
                    return false;
                }
                if(j_id==0){
                    if(!confirm("确认添加该职位")){
                        return false;
                    }
                    $.ajax({
                        type:"post",
                        url:"addj",
                        data:{d_id:d_id,j_name:j_name,j_salary:j_salary},
                        success:function (obj) {//成功后回调函数
                            alert(obj);
                            location.reload(true);
                        },
                        error:function (obj) {

                        }
                    })
                }else{
                    if(!confirm("确认修改该职位")){
                        return false;
                    }
                    $.ajax({
                        type:"post",
                        url:"updatej",
                        data:{j_id:j_id,j_name:j_name,j_salary:j_salary},
                        success:function (obj) {//成功后回调函数
                            alert(obj);
                            location.reload(true);
                        },
                        error:function (obj) {

                        }
                    })
                }
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
            <a href="organizationalManagement" style="color: red">组织管理&emsp;</a>
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
                    <td>
                        <select name="d_id" id="d_id">
                        <option value="0">部门</option>
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.d_id}">${department.d_name}</option>
                        </c:forEach>
                    </select>
                    </td><td><input type="button" value="删除部门" id="deld">部门名：<input type="text" name="d_name" id="d_name"><input type="button" value="添加修改部门" id="saved"></td>
                </tr>
                <tr style="background-color: #faebd7">
                    <td>
                        <select name="j_id" id="j_id">
                            <option value="0">职位</option>
                        </select>
                    </td><td><input type="button" value="删除职位" id="delj">职位名：<input type="text" name="j_name" id="j_name">基本工资：<input type="number" step="0.1" name="j_salary" id="j_salary"><input type="button" value="添加修改职位" id="savej"></td>
                </tr>
            </table>
        </div>

    </div>
</div>
</body>
</html>
