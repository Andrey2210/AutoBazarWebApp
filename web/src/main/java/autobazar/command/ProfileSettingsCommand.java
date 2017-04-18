package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.User;
import by.autobazar.services.ServiceException;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 28.03.2017.
 */
public class ProfileSettingsCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        UserAuthenticationDto userADto = (UserAuthenticationDto) request.getSession().getAttribute("user");
        if(request.getParameter("type") != null) {
            request.setAttribute("user", UserService.getInstance().getUserById(userADto.getId()));
            forward(ConfigurationManager.getInstance().getProperty("path.page.profileSettings"));
        } else if (request.getParameter("password").isEmpty() || request.getParameter("name").isEmpty()
                || request.getParameter("phone").isEmpty()) {
            request.setAttribute("errorEmptyMessage", "All fields must be filled");
            forward(ConfigurationManager.getInstance().getProperty("path.page.profileSettings"));
        } else {
            User user = UserService.getInstance().getUserById(userADto.getId());
            user.setPassword(request.getParameter("password"));
            user.setName(request.getParameter("name"));
            user.setPhone(request.getParameter("phone"));
            try {
                UserService.getInstance().updateUser(user);
            } catch (ServiceException e) {
                request.setAttribute("errorRegistrationMessage", e.getMessage());
                forward(ConfigurationManager.getInstance().getProperty("path.page.profileSettings"));
            }
            request.setAttribute("user", user);
            request.setAttribute("list", UserService.getInstance().getCarsByUserId(userADto.getId()));
            forward(ConfigurationManager.getInstance().getProperty("path.page.profile"));
        }
    }
}
