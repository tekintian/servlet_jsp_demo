package cn.tekin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tekin.myshopping.service.MyCart;

//防止重复刷新
@WebServlet(name = "/myshopping/GoShowMycart", value = "/myshopping/GoShowMycart")
public class GoShowMycart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获得登陆时创建的购物车
		MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
		//把要显示的数据放入request，准备显示
		request.setAttribute("booklist", myCart.showMyCart());
		request.setAttribute("toltalPrice", myCart.getTotalPrice());
		//跳转到 显示我的购物车去
		request.getRequestDispatcher("/WEB-INF/myshopping/ShowMyCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
