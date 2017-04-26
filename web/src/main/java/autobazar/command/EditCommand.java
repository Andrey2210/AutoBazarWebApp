package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.User;
import by.autobazar.services.CarService;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 28.03.2017.
 */
public class EditCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        UserAuthenticationDto userAuthenticationDto = (UserAuthenticationDto) request.getSession().getAttribute("user");
//        User userData = UserService.getInstance().getLoggedUser(userAuthenticationDto.getLogin(), userAuthenticationDto.getPassword());
//        request.setAttribute("car", CarService.getInstance().getCarById(Long.parseLong(request.getParameter("id"))));
//        request.setAttribute("userData", userData);
//        forward(ConfigurationManager.getInstance().getProperty("path.page.edit"));
    }
}
