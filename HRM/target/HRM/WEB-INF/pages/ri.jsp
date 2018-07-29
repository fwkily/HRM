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
            $(".recall").click(function () {
                var ri_id=parseInt($(this).prev().val());
                if (!confirm("确认撤回")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"recall",
                    data:{ri_id:ri_id},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $(".issue").click(function () {
                var ri_id=parseInt($(this).prev().val());
                if (!confirm("确认发布")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"issue",
                    data:{ri_id:ri_id},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $(".delete").click(function () {
                var ri_id=parseInt($(this).siblings().eq(0).val());
                 if (!confirm("确认删除")){
                     return false;
                 }
                $.ajax({
                    type:"post",
                    url:"delete",
                    data:{ri_id:ri_id},
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
        <a href="ri?ri_state=0">未发布&emsp;</a>
        <a href="ri?ri_state=1">已发布&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <a href="addRi">添加</a>
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
                        <td><input type="hidden" name="ri_id" value="${recruitInformation.ri_id}" id="ri_id">
                            <c:if test="${recruitInformation.ri_state eq 1}">
                                <input type="button" value="撤回" class="recall">
                            </c:if>
                            <c:if test="${recruitInformation.ri_state eq 0}">
                                <input type="button" value="发布" class="issue"/>
                                <a href="alter?ri_id=${recruitInformation.ri_id}">修改</a>
                                <input type="button" value="删除" class="delete"/>
                            </c:if>
                        </td>

                    </tr>
                </c:forEach>
                    <tr>
                        <td colspan="8" id="str" style="color: red"></td>
                    </tr>
            </table>
        </div>
        <div id="d32" >
            <a href="ri?ri_state=${ri_state}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="ri?ri_state=${ri_state}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="ri?ri_state=${ri_state}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="ri?ri_state=${ri_state}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
