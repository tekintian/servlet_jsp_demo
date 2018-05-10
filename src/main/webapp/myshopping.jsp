<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>My Page Title</title>
</head>

<body>
<jsp:forward page="WEB-INF/myshopping/Login.jsp"></jsp:forward>
</body>
</html>