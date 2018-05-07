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
      <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  <div class="container">
  <h1>JSP Demo Project</h1>
  <%-- JSp 专用注释 --%>
  <%

    SimpleDateFormat simpleDateFormat=new SimpleDateFormat(config.getServletContext().getInitParameter("DATE_FORMAT"));
    String now=simpleDateFormat.format(new java.util.Date());

    out.println("Hello world! 当前时间是："+ now);
  %>
      <hr style="margin: 2rem auto 1rem;">
      <ul class="navList">
          <li><a href="count.jsp">计算器测试</a></li>
      </ul>

  </div>
  </body>
</html>
