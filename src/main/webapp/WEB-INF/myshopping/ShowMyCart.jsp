<%@ page language="java" import="java.util.*,cn.tekin.myshopping.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowMyCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="comm.css">

  </head>
  
  <body style="text-align:center; margin:0 auto; ">
    <h1>我的购物车</h1>
    <a href="<%=path%>/myshopping/GoHallUI?id=<%=((Users)session.getAttribute("loginUser")).getId()%>&&password=<%=((Users)session.getAttribute("loginUser")).getPwd()%>">返回购物大厅</a>
    <form action="<%=path%>/myshopping/ShoppingCLServlet?type=update" method="post">
    <table border="1"style="border-collapse: collapse; width: 600px "  align="center">
    <tr><th>BookID</th><th>书名</th><th>价格</th><th>出版社</th><th>数量</th><th>是否删除</th></tr>
    
    <%
    //从request中取出要显示的商品信息
    ArrayList al=(ArrayList)request.getAttribute("booklist");
    for(int i=0;i<al.size();i++){
    
    Book book=(Book)al.get(i);
    %>
     <tr><td><%=book.getId() %><input type="hidden" name="id" value="<%=book.getId() %>"/></td><td><%=book.getName()%></td><td><%=book.getPrice() %></td>
     <td><%=book.getPublishHouse() %></td><td><input type="text" name="booknum" value="<%=book.getShoppingNum()%>"/>本
     </td><td><a href="<%=path%>/myshopping/ShoppingCLServlet?type=del&id=<%=book.getId()%>">删除</a></td></tr>
    <%
    }
    
     %>
   
    
    <tr><td colspan="6"><input type="submit" value="update"></td></tr>
    <tr><td colspan="6">购物车的总价格是 ：${toltalPrice}  元</td></tr>
    </table>
    </form>
    <a href="<%=path%>/myshopping/GoMyOrderServlet">提交订单</a>
  </body>
</html>
