package cn.tekin.myshopping.controler;

import cn.tekin.myshopping.domain.Users;
import cn.tekin.myshopping.service.BookService;
import cn.tekin.myshopping.service.MyCart;
import cn.tekin.myshopping.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "/myshopping/GoHallUI", value = "/myshopping/GoHallUI")
public class GoHallUI extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //得到从登陆传递过来的用户名和密码
        String username = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        //先判断该用户是否登录或此用户曾登录的session是否已经过期
        if (request.getSession().getAttribute("loginUser") != null) {
            //给下一个页面准备要显示的数据
            BookService bookservice = new BookService();
            ArrayList al = bookservice.getAllBook();

            //把要显示的数据放在request，原因是request的生命周期最短
            request.setAttribute("books", al);
            request.getRequestDispatcher("/WEB-INF/myshopping/Hall.jsp").forward(request, response);
            return;//不要往下走了！
        }

        //创建一个users对象
        Users loginuser = new Users(username, pwd);
        //使用业务逻辑类完成验证
        UsersService userservice = new UsersService();
        if (userservice.checkUser(loginuser)) {
            //说明是合法用户，跳转到购物大厅

            //因为在其他页面可以用到用户信息，因此把用户信息放入session中
            request.getSession().setAttribute("loginUser", loginuser);

            ////当用户登陆成功后，为他创建一个购物车
            MyCart myCart = new MyCart();
            request.getSession().setAttribute("myCart", myCart);


            //给下一个页面准备要显示的数据
            BookService bookservice = new BookService();
            ArrayList al = bookservice.getAllBook();

            //把要显示的数据放在request，原因是request的生命周期最短
            request.setAttribute("books", al);
            request.getRequestDispatcher("/WEB-INF/myshopping/Hall.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "用户认证失败！");
            //说明不合法，返回原页面
            request.getRequestDispatcher("/WEB-INF/myshopping/Login.jsp").forward(request, response);

        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}

