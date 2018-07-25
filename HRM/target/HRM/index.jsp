<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/24/0024
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
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
            <a href="index">淘宝网首页&emsp;</a>
            <a href="#" class="a1">我的淘宝&emsp;</a>
            <a href="#" class="a1">购物车&emsp;</a>
        </div>
    </div>
    <div id="d2">
        <div id="d21"><img src="resources/images/1.jpg"></div>
        <div id="d22">
            <span style="line-height: 100px">
            <form >
                <input type="text" name="name" style="height: 40px;width: 300px;margin-left: 100px">
                <input type="submit" class="a1" value="搜索" style="height: 40px">
            </form>
            </span>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="150px">商品</th>
                    <th width="80px">单价</th>
                    <th width="150px">类型</th>
                    <th width="170px">描述</th>
                    <th width="150px">厂商</th>
                    <th width="50px">库存</th>
                    <th width="50px">数量</th>
                    <th width="50px">价格</th>
                    <th width="60px">购物车</th>
                    <th width="50px">下单</th>
                </tr>
                <c:forEach items="${goods}" var="good" varStatus="loop">
                    <tr >
                        <form >
                            <td>${good.gid}</td>
                            <td>${good.gname}</td>
                            <td>${good.price}</td>
                            <td>${good.type}</td>
                            <td>${good.description}</td>
                            <td>${good.factory}</td>
                            <td>${good.stock.scount}</td>
                            <td><input style="width: 50px" class="number" name="gcount" type="number" value="1" min="1" max="${good.stock.scount}"></td>
                            <td>${good.price}</td>
                            <td><input type="button" class="a1" value="加入"></td>
                            <td>
                                <input type="hidden" class="a1" name="gid" value="${good.gid}" />
                                <input type="submit" class="a1" value="下单" />
                            </td>
                        </form>
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
