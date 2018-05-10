package cn.tekin.myshopping.controler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logout.do")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除SESSION
        request.getSession().removeAttribute("loginUser");

        Cookie cookie=new Cookie("loginUser","u");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        PrintWriter out=response.getWriter();
        out.println("成功退出！");
        response.setStatus(302);
        response.setHeader("Refresh","3;url="+request.getServletContext().getInitParameter("HOME_URL") + "myshopping.jsp");
       return;

    }
}
