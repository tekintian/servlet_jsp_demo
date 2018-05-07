<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Tekin
  Date: 2018/5/7
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
  <head>
    <title>My Jsp Learning Demo Project</title>
  </head>
  <body>
  <h1>JSP Demo Project</h1>
  <%-- JSp 专用注释
  config  相当于 request.getServletContext()
  --%>
  <%
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat(config.getInitParameter("DATE_FORMAT"));
    String now=simpleDateFormat.format(new java.util.Date());

    out.println("Hello world! 当前时间是："+ now);
  %>
  </body>
</html>
