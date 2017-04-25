package autobazar.servlet;

import autobazar.command.FrontCommand;
import autobazar.command.UnknownCommand;
import by.autobazar.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 15.03.2017.
 */
@WebServlet(urlPatterns = {"/controller", "/registration", "/login", "/submit", "/dashboard"})
public class FrontControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractService.session = HibernateUtil.getHibernateUtil().getSession();
        FrontCommand command = getCommand(req);
        command.init(getServletContext(), req, resp);
        command.process();
        HibernateUtil.getHibernateUtil().closeSession(AbstractService.session);
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(String.format("autobazar.command.%sCommand", request.getParameter("command")));
            return (FrontCommand) type
                    .asSubclass(FrontCommand.class)
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }

}
