package autobazar.filter;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 22.03.2017.
 */
@WebFilter(urlPatterns = {"/submit", "/dashboard", "/registration", "/login"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        UserAuthenticationDto userData = (UserAuthenticationDto) request.getSession().getAttribute("user");
        if(request.getRequestURI().contains("/submit") && userData == null) {
            servletRequest.getRequestDispatcher(ConfigurationManager.getInstance().getProperty("path.page.login"))
                    .forward(servletRequest, servletResponse);
        } else  if(request.getRequestURI().contains("/dashboard") && (userData == null || (userData.getRole().equalsIgnoreCase("user")))) {
            servletRequest.getRequestDispatcher(ConfigurationManager.getInstance().getProperty("path.page.login"))
                    .forward(servletRequest, servletResponse);        } else  if((request.getRequestURI().contains("/registration") || request.getRequestURI().contains("/login"))
        && (userData != null)) {
            servletRequest.getRequestDispatcher(ConfigurationManager.getInstance().getProperty("path.page.profile"))
                    .forward(servletRequest, servletResponse);        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}