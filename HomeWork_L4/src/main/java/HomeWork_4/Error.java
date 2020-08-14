package HomeWork_4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ErrorWeb")
public class Error extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        errorInfo(request, response);
    }

    private void errorInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<html><head><title>Ошибка!!!</title></head><body>");
            writer.write("<h2>Возникла ошибка!</h2>");
            Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
            writer.println("<h3>Status_code: " + code + "</h3>");
            String requestUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
            response.getWriter().println("<h3>Request_URI: " + requestUri + "</h3>");
        }
    }
}
