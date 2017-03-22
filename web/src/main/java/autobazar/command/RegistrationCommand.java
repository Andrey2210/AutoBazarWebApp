package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.User;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 21.03.2017.
 */
public class RegistrationCommand extends FrontCommand{



    @Override
    public void process() throws ServletException, IOException {
        if (request.getParameter("login").isEmpty() || request.getParameter("email").isEmpty()
                || request.getParameter("password").isEmpty() || request.getParameter("name").isEmpty()
                || request.getParameter("phone").isEmpty()) {
            forward(ConfigurationManager.getInstance().getProperty("path.page.registration"));
        } else {
            User user = UserService.getInstance().createUser(new User(request.getParameter("login"), request.getParameter("email"),
                    request.getParameter("password"), request.getParameter("name"), request.getParameter("phone")));
            UserAuthenticationDto userAuthenticationDto = new UserAuthenticationDto();
            userAuthenticationDto.setId(user.getId());
            userAuthenticationDto.setLogin(user.getLogin());
            userAuthenticationDto.setPassword(user.getPassword());
            userAuthenticationDto.setRole(user.getRole());
            request.getSession().setAttribute("user", userAuthenticationDto);
            forward("/autobazar/controller");
        }
    }
}

