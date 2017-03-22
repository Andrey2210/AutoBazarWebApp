package autobazar.filter;

import autobazar.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 22.03.2017.
 */
@WebFilter(value = "/submit")
public class AuthenticationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        Object userData = request.getSession().getAttribute("user");
            if (userData == null) {
                servletRequest.getRequestDispatcher(ConfigurationManager.getInstance().getProperty("path.page.login"))
                        .forward(servletRequest, servletResponse);
            }
        filterChain.doFilter(servletRequest, servletResponse);
    }



    @Override
    public void destroy() {

    }
}