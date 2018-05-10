<%@ page language="java" import="java.util.*,cn.tekin.myshopping.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Hall.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center; margin:0 auto; ">
    <h1>欢迎来到购物大厅</h1>
    <table border="1"style="border-collapse: collapse; width: 500px"  align="center">
    <tr><th>书名</th><th>价格</th><th>出版社</th><th>点击购买</th></tr>
    <%
    //取出request中的那个Araylist
    ArrayList al=(ArrayList)request.getAttribute("books");
    for(int i=0;i<al.size();i++){
    Book book=(Book)al.get(i);
    %>
    
    <%--这里的百分号后面有个等号是因为，百分号标签里面必须存放表达式，而不是句子，故后面不应该有分号！ --%>
    <tr><td><%=book.getName() %></td><td><%=book.getPrice() %></td><td><%=book.getPublishHouse() %></td><td><a href="<%=path%>/myshopping/ShoppingCLServlet?type=add&id=<%=book.getId()%>" >点击购买</a></td></tr>
    
    <%
        }
     %>
    
   
    <tr align="center"><td colspan="4"><input type="button" value="查看购物车"  onclick="window.location.href='<%=path%>/myshopping/ShoppingCLServlet?type=show';"></td></tr>
    
    </table>
    <hr/>
    <a href="<%=basePath%>Logout.do">返回重新登录</a>
  </body>
</html>
