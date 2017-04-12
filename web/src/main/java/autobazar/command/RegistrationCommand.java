package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.entity.carEnum.Role;
import by.autobazar.services.CarService;
import by.autobazar.services.ServiceException;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

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
            User user = null;
            try {
                user = UserService.getInstance().createUser(new User(request.getParameter("login"), request.getParameter("email"),
                        request.getParameter("password"), request.getParameter("name"), request.getParameter("phone"), Role.USER));
            } catch (ServiceException e) {
                forward(ConfigurationManager.getInstance().getProperty("path.page.registration"));
            }
            UserAuthenticationDto userAuthenticationDto = new UserAuthenticationDto();
            userAuthenticationDto.setId(user.getId());
            userAuthenticationDto.setLogin(user.getLogin());
            userAuthenticationDto.setPassword(user.getPassword());
            userAuthenticationDto.setRole(user.getRole().toString());
            request.getSession().setAttribute("user", userAuthenticationDto);


            request.getSession().removeAttribute("pageDetails");
            List<Car> carsList = CarService.getInstance().getLimitAmount();
            request.setAttribute("list", carsList);
            request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
            String page = ConfigurationManager.getInstance().getProperty("path.page.index");
            forward(page);        }
    }
}

