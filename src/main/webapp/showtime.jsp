<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Tekin
  Date: 2018/5/7
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Format and Show Now Time</title>
</head>
<body>
<h1>格式化输入当前时间</h1>
<%
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat(request.getServletContext().getInitParameter("DATE_FORMAT"));
    String now=simpleDateFormat.format(new java.util.Date());

    out.println("Hello world! 当前时间是："+ now);
%>
</body>
</html>
