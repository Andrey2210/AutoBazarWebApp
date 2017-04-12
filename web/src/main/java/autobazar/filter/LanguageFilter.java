package autobazar.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Andrey
 * Date: 11.04.2017.
 * Time: 18:04
 */
@WebFilter(urlPatterns = { "/*" },
        initParams = {
                @WebInitParam(name = "language", value = "en_US") })
public class LanguageFilter implements Filter {

    private String language;

    @Override
    public void init(FilterConfig config) throws ServletException {
        language = config.getInitParameter("language");
        if (language == null) {
            language = "en_US";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("language") == null) {
            ((HttpServletRequest)servletRequest).getSession().setAttribute("language", language);
        } else {
            language = servletRequest.getParameter("language");
            ((HttpServletRequest)servletRequest).getSession().setAttribute("language", language);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}