package autobazar.servlet;

import autobazar.command.FrontCommand;
import autobazar.command.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 15.03.2017.
 */
@WebServlet(urlPatterns = "/sss")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        try {
            System.out.println(Class.forName(String.format(
                    "autobazar.command.%sCommand",
                    request.getParameter("command"))));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        FrontCommand command = getCommand(request);
//        command.init(getServletContext(), request, response);
//        command.process();
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
