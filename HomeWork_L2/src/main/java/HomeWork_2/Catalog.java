package HomeWork_2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static HomeWork_2.Main.menu;

@WebServlet(name = "ProductCatalog", urlPatterns = "/catalog")
public class Catalog extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<HEAD><TITLE>Каталог товаров</TITLE></HEAD>");
        menu(req, resp);
        out.write("<h1><p align=\"center\">Каталог товаров</p></h1>");
    }
}
