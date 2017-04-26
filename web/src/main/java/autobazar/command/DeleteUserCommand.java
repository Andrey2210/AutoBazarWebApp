package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.ServiceException;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey
 * Date: 10.04.2017.
 * Time: 0:20
 */
public class DeleteUserCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        long id = Long.parseLong(request.getParameter("id"));
//        if(id != 0) {
//            try {
//                UserService.getInstance().deleteUser(id);
//            } catch (ServiceException e) {
//                request.setAttribute("errorUsersMessage", e.getMessage());
//            }
//        }
//        try {
//            request.setAttribute("users", UserService.getInstance().getAll());
//        } catch (ServiceException e) {
//            request.setAttribute("errorUsersMessage", e.getMessage());
//        }
//        forward(ConfigurationManager.getInstance().getProperty("path.page.dashboard"));
    }
}