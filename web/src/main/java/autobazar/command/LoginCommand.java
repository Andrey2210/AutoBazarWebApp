package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.User;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 19.03.2017.
 */
public class LoginCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String page;
        User user = UserService.getInstance().getLoggedUser(login, password);
        if (user != null) {
            UserAuthenticationDto userAuthenticationDto = new UserAuthenticationDto();
            userAuthenticationDto.setLogin(user.getLogin());
            userAuthenticationDto.setPassword(user.getPassword());
            userAuthenticationDto.setRole(user.getRole());
            request.getSession().setAttribute("user", userAuthenticationDto);
        }
            page = ConfigurationManager.getInstance().getProperty("path.page.index");

        forward(page);
    }
}