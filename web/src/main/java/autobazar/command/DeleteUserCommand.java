package autobazar.command;

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
        long id = Long.parseLong(request.getParameter("id"));
        if(id != 0) {
            UserService.getInstance().deleteUser(id);
        }
        forward("/autobazar/dashboard");
    }
}