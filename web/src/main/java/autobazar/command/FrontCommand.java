package autobazar.command;

import autobazar.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 15.03.2017.
 */
public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
    }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String target) throws ServletException, IOException {
        if (target != null) {
            target = String.format("%s", target);
            RequestDispatcher dispatcher = context.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(ConfigurationManager.getInstance().getProperty("path.page.error"));
        }
    }
}
