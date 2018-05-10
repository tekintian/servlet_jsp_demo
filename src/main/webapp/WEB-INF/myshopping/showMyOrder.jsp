<%@page import="cn.tekin.myshopping.service.MyCart"%>
<%@ page language="java" import="java.util.*,cn.tekin.myshopping.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>showMyOrder</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

function goSubmitOrder(){
window.location.href="<%=path%>/myshopping/SubmitOrderServlet";
}

</script>
  </head>
  
  <body style="text-align:center; margin:0 auto; ">
    <h1>我的个人信息</h1>
    <table border="1"style="border-collapse: collapse; width: 600px"  align="center">
    <tr><td colspan="2">用户个人信息</td></tr>
    <tr><td>用户名:</td><td><%=((Users)session.getAttribute("loginUser")).getName() %></td></tr>
    <tr><td>邮箱:</td><td><%=((Users)session.getAttribute("loginUser")).getEmail() %></td></tr>
    <tr><td>用户级别：</td><td><%=((Users)session.getAttribute("loginUser")).getGrade() %></td></tr>
    </table>
    <br/>
    <hr/>
    <br/>
     <table border="1"style="border-collapse: collapse; width: 600px"  align="center">
    <tr><th>BookID</th><th>书名</th><th>价格</th><th>出版社</th><th>数量</th></tr>
     <%
    //从request中取出要显示的商品信息
    ArrayList al=(ArrayList)request.getAttribute("orderinfo");
    for(int i=0;i<al.size();i++){
    
    Book book=(Book)al.get(i);
    %>
     <tr><td><%=book.getId() %><input type="hidden" name="id" value="<%=book.getId() %>"/></td><td><%=book.getName()%></td><td><%=book.getPrice() %></td>
     <td><%=book.getPublishHouse() %></td><td><%=book.getShoppingNum()%>本</td></tr>
    <%
    }
    
     %>
     <td colspan="5">总价格：  <%=request.getAttribute("totalPrice")%></td>
     <tr><td colspan="1"><input type="button" onclick="goSubmitOrder()" value="提交订单"></td>
     <td colspan="4"><a href="<%=path%>/myshopping/GoHallUI?id=<%=((Users)session.getAttribute("loginUser")).getId()%>&&password=<%=((Users)session.getAttribute("loginUser")).getPwd()%>">返回购物大厅</a></td></tr>
    </table>
  </body>
</html>
