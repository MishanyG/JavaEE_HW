package HomeWork_2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainPage", urlPatterns = "/main")
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<HEAD><TITLE>Главная страница</TITLE></HEAD>");
        menu(req, resp);
        out.write("<h1><p align=\"center\">Главная страница</p></h1>");
    }

    static void menu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.print("<a href = "+ req.getContextPath() + "/main" + "><h1><font color=\"LIME\">Главная страница</font></h1></a>");
        out.print("<a href = "+ req.getContextPath() + "/catalog" + "><h1><font color=\"GREEN\">Каталог товаров</font></h1></a>");
        out.print("<a href = "+ req.getContextPath() + "/product" + "><h1><font color=\"PURPLE\">Товар</font></h1></a>");
        out.print("<a href = "+ req.getContextPath() + "/cart" + "><h1><font color=\"TEAL\">Корзина</font></h1></a>");
        out.print("<a href = "+ req.getContextPath() + "/order" + "><h1><font color=\"RED\">Оформление заказа</font></h1></a>");
    }
}
