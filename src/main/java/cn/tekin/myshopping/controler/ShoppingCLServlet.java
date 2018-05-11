package cn.tekin.controller;

import cn.tekin.myshopping.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应用户购买商品的请求,处理用户购物行为
 */
@WebServlet(name = "/myshopping/ShoppingCLServlet", value = "/myshopping/ShoppingCLServlet")
public class ShoppingCLServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String CPATH = request.getServletContext().getInitParameter("CPATH");


        String type = request.getParameter("type");
        String id = request.getParameter("id");
        if (type.equals("del")) {
            //*******响应购物车商品删除*********

            //获得登陆时创建的购物车
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            myCart.del(id);

            //把要显示的商品信息放入request
            request.setAttribute("booklist", myCart.showMyCart());
            request.setAttribute("toltalPrice", myCart.getTotalPrice());
            request.getRequestDispatcher("/WEB-INF/myshopping/ShowMyCart.jsp").forward(request, response);

        }
        else if (type.equals("add")) {
            //******响应购物车的商品添加******


            //获得登陆时创建的购物车
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            //把商品添加到购物车中
            myCart.addBook(id);
            //为了防止某个页面重复刷新，我们可以sendredirect
            response.sendRedirect(CPATH + "/myshopping/GoShowMycart");
        }
        else if (type.equals("update")) {
            //得到用户希望得到的书号和数量
            String bookIds[] = request.getParameterValues("id");
            String nums[] = request.getParameterValues("booknum");

            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            for (int i = 0; i < bookIds.length; i++) {
                //更新整个购物车
                myCart.updateBook(bookIds[i], nums[i]);
            }
            //调回我的购物车
            //把要显示的商品信息放入request
            request.setAttribute("booklist", myCart.showMyCart());
            request.setAttribute("toltalPrice", myCart.getTotalPrice());
            request.getRequestDispatcher("/WEB-INF/myshopping/ShowMyCart.jsp").forward(request, response);
        }
        else if (type.equals("show")) {

            //为了防止某个页面重复刷新，我们可以sendredirect
            response.sendRedirect(CPATH + "/myshopping/GoShowMycart");
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
