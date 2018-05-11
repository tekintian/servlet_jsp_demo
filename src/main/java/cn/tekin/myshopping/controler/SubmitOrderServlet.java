package cn.tekin.controller;

import cn.tekin.myshopping.domain.Users;
import cn.tekin.myshopping.service.MyCart;
import cn.tekin.myshopping.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/myshopping/SubmitOrderServlet", value = "/myshopping/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //该Servlet处理下订单的请求
        try {
            OrderService orderservice = new OrderService();
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            Users user = (Users) request.getSession().getAttribute("loginUser");
            orderservice.submitOrder(myCart, user);

        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/myshopping/errInfo.jsp");
            // TODO: handle exception
        }


        request.getRequestDispatcher("/WEB-INF/myshopping/OrderOK.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
