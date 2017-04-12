package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.services.CarService;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class LoginCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = UserService.getInstance().getLoggedUser(login, password);
        if (user != null) {
            UserAuthenticationDto userAuthenticationDto = new UserAuthenticationDto();
            userAuthenticationDto.setId(user.getId());
            userAuthenticationDto.setLogin(user.getLogin());
            userAuthenticationDto.setPassword(user.getPassword());
            userAuthenticationDto.setRole(user.getRole().toString());
            request.getSession().setAttribute("user", userAuthenticationDto);
        }
        request.getSession().removeAttribute("pageDetails");
        List<Car> carsList = CarService.getInstance().getLimitAmount();
        request.setAttribute("list", carsList);
        request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
        String page = ConfigurationManager.getInstance().getProperty("path.page.index");
        forward(page);
    }
}