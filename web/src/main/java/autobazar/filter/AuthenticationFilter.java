package autobazar.filter;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Andrey on 22.03.2017.
 */
@WebFilter(urlPatterns = {"/submit", "/dashboard"})
public class AuthenticationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        UserAuthenticationDto userData = (UserAuthenticationDto) request.getSession().getAttribute("user");
            if (userData == null) {
                servletRequest.getRequestDispatcher(ConfigurationManager.getInstance().getProperty("path.page.login"))
                        .forward(servletRequest, servletResponse);
            } else if(request.getRequestURI().contains("/dashboard")) {
                if (userData.getRole().equals("user")) {
                    servletRequest.getRequestDispatcher("/controller").forward(servletRequest, servletResponse);
                }
            }
        filterChain.doFilter(servletRequest, servletResponse);
    }



    @Override
    public void destroy() {

    }
}