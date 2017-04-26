package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.ServiceException;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 27.03.2017.
 */
public class DashboardCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        try {
//            request.setAttribute("users", UserService.getInstance().getAll());
//        } catch (ServiceException e) {
//            request.setAttribute("errorUsersMessage", e.getMessage());
//        }
//        forward(ConfigurationManager.getInstance().getProperty("path.page.dashboard"));
    }
}
