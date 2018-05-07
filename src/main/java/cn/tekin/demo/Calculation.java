package cn.tekin.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculation", value = "/calculation.do")
public class Calculation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        String num1=request.getParameter("num1");
        String num2=request.getParameter("num2");
        String oper=request.getParameter("oper");
        String t=request.getParameter("t");

        if (oper == null||num1==null||num2==null) {
            out.println("非法访问！");
            response.setStatus(302);
            response.setHeader("Refresh","3;url="+request.getServletContext().getInitParameter("HOME_URL"));
        }else {
            double res=0;
            double d_num1=Double.parseDouble(num1);
            double d_num2=Double.parseDouble(num2);

            switch (oper){
                case "+":
                    res=d_num1+d_num2;
                    break;
                case "-":
                    res=d_num1-d_num2;
                    break;
                case "*":
                    res=d_num1*d_num2;
                    break;
                case "/":
                    res=d_num1/d_num2;
                    break;
            }
            if (t!=null&&t.equals("json")){
                response.setContentType("application/json;charset=utf-8");
                out.println("{\"status\":\"ok\",\"result\":"+res+"}");
            }else{
                response.setContentType("text/html;charset=utf-8");
                out.println("计算结果为:"+res);
                out.println("<BR><a href='javascript:history.go(-1)'>点此放回上一页</a>");
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
