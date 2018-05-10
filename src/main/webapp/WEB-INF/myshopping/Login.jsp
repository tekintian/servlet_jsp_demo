<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<section class="container">
<h1>登陆界面</h1>
<form action="<%=path %>/myshopping/GoHallUI" method="post"><!-- 注意ＡＣＴＩＯＮ的值 -->
    <div class="login">
        <table border="1px" align="center" >
            <tr><td>用户名：</td><td><input type="text" name="name"/></td></tr>
            <tr><td>密　码：</td><td><input type="password" name="pwd"/></td></tr>
            <tr><td><input type="submit" value="登陆"/></td><td><input type="reset" value="清空"/></td></tr>
        </table>
    </div>
</form>
<%
    if (request.getAttribute("error") != null) out.println(request.getAttribute("error"));
%>
</section>
</body>
</html>