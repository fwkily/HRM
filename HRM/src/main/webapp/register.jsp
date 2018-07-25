<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/25/0025
  Time: 11:09
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
    <link rel="stylesheet" href="resources/css/register.css" type="text/css"/>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            var p1;
            var p2;
            var flag1 = false;
            var flag2 = false;
            var flag3 = false;
            $("#uname").focus(function () {
                $("#name").html("瀛楁瘝寮�澶达紝6-16浣嶅瓧姣嶃�佹暟瀛�");
            })
            $("#pwd1").focus(function () {
                $("#pass").html("6-16浣嶅瓧姣嶃�佹暟瀛�");
            })
            $("#pwd2").focus(function () {
                $("#pass1").html("璇峰啀娆¤緭鍏ヤ綘鐨勫瘑鐮�");
            })
            $("#pwd2").blur(function () {
                p1 = $("#pwd1").val();
                p2 = $("#pwd2").val();
                if(p1==p2&&flag2){
                    $("#pass1").html("瀵嗙爜鐩稿悓涓旂鍚堣姹�");
                    flag3 = true;
                    ff();
                }else{
                    $("#pass1").html("瀵嗙爜涓嶇浉鍚屾垨涓嶇鍚堣姹�");
                    flag3 = false;
                }
            })
            $("#pwd1").blur(function () {
                p1 = $("#pwd1").val();
                var reg=/[A-z0-9]{6,16}/;
                if (p1.length<6){
                    $("#pass").html("瀵嗙爜灏忎簬6浣�");
                    flag2 = false;
                }else if(p1.length>16){
                    $("#pass").html("瀵嗙爜澶т簬16浣�");
                    flag2 = false;
                }else if(!reg.test(p1)){
                    $("#pass").html("瀵嗙爜璁剧疆涓嶇鍚堣姹�");
                    flag2 = false;
                }else {
                    $("#pass").html("瀵嗙爜鍛藉悕绗﹀悎瑕佹眰");
                    flag2 = true;
                    ff();
                }
            })
            $("#uname").blur(function () {
                uname = $("#uname").val();
                var reg=/[A-z][A-z0-9]{5,15}/;
                if (uname.length<6){
                    $("#name").html("鐢ㄦ埛鍚嶅皬浜�6浣�");
                    flag1 = false;
                }else if(uname.length>16){
                    $("#name").html("鐢ㄦ埛鍚嶅ぇ浜�16浣�");
                    flag1 = false;
                }else if(!reg.test(uname)){
                    $("#name").html("鐢ㄦ埛鍚嶅懡鍚嶄笉绗﹀悎瑕佹眰");
                    flag1 = false;
                }else {
                    $.ajax({
                        type:"get",
                        url:"checkName",
                        data:{uname:$("#uname").val()},
                        success:function (obj) {//鎴愬姛鍚庡洖璋冨嚱鏁�
                            $("#name").text(obj);
                        },
                        error:function (obj) {
                            $("#name").text(obj);
                        }
                    })
                    flag1 = true;
                    ff();
                }
            })
            function ff() {
                if (flag1&&flag2&&flag3){
                    $("#register").attr("disabled",false);
                    $("#uname").attr("readonly",true);
                    $("#pwd1").attr("readonly",true);
                    $("#pwd2").attr("readonly",true);
                }else{
                    $("#register").attr("disabled",true);
                }
            }
            $("#rt").click(function () {
                $("#register").attr("disabled",true);
                $("#uname").attr("readonly",false);
                $("#pwd1").attr("readonly",false);
                $("#pwd2").attr("readonly",false);
                flag1 = false;
                flag2 = false;
                flag3 = false;
            })
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1" >
        <img src="resources/images/6.jpg">
    </div>
    <hr/>
    <div id="d2">
            <div id="d21">
                <form method="post" action="register">
                    <div>
                        <span >姓名</span><input type="text" name="uname" style="height:40px;width:200px " id="uname"/><span id="name" style="width: 300px;text-align: left;color: red">${error}</span>
                    </div>
                    <div>
                        <span >鐢ㄦ埛瀵嗙爜</span><input type="password" name="upass" style="height:40px;width:200px " id="pwd1"/><span id="pass" style="width: 300px;text-align: left;color: red"></span>
                    </div>
                    <div>
                        <span >纭瀵嗙爜</span><input type="password" name="pass1" style="height:40px;width:200px " id="pwd2"/><span id="pass1" style="width: 300px;text-align: left;color: red"></span>
                    </div>
                    <div style="margin-left: 0px">
                        <span >鎬у埆</span><input type="radio" style="width: 10px" name="sex" checked="checked" value="鐢�"/>鐢�<input type="radio" style="width: 10px" name="sex" value="濂�"/>濂�
                    </div>
                    <div style="text-align: left;margin-top: 25px">
                        <input disabled="true" id="register" type="submit" value="鎻愪氦" style="background-color: orangered;height:40px;width:80px;margin-left: 100px;color: white"/>
                        <input id="rt" type="reset" value="閲嶇疆" style="background-color: orangered;height:40px;width: 80px;margin-left: 30px;color: white"/>
                    </div>
                    <span style="color: red;float: left">
                        ${str}</span>
                </form>
            </div>
    </div>
</div>
</body>
</html>
