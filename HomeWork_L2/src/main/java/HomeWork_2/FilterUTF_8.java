package HomeWork_2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterUTF_8 implements Filter {

    private String encod;

    public void init(FilterConfig config) throws ServletException {
        encod = config.getInitParameter("requestEncoding");
        if (encod == null)
            encod = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html; charset=" + encod);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}