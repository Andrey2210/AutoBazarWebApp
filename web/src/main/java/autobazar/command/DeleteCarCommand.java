package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.services.CarService;
import by.autobazar.services.ServiceException;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey
 * Date: 10.04.2017.
 * Time: 0:12
 */
public class DeleteCarCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        long id = Long.parseLong(request.getParameter("id"));
//        if (id != 0) {
//            CarService.getInstance().deleteCar(id);
//        }
//        String type = request.getParameter("type");
//        if (type.equals("profile")) {
//            UserAuthenticationDto userADto = (UserAuthenticationDto) request.getSession().getAttribute("user");
//            request.setAttribute("list", UserService.getInstance().getCarsByUserId(userADto.getId()));
//            forward(ConfigurationManager.getInstance().getProperty("path.page.profile"));
//        } else {
//            try {
//                request.setAttribute("users", UserService.getInstance().getAll());
//            } catch (ServiceException e) {
//                request.setAttribute("errorUsersMessage", e.getMessage());
//            }
//            forward(ConfigurationManager.getInstance().getProperty("path.page.dashboard"));
//        }
    }
}
