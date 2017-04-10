package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 28.03.2017.
 */
public class UsersDashboardCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("users", UserService.getInstance().getAll());
        forward(ConfigurationManager.getInstance().getProperty("path.page.usersDashboard"));
    }
}
