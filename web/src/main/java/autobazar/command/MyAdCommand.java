package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.services.CarService;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 28.03.2017.
 */
public class MyAdCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        UserAuthenticationDto userADto = (UserAuthenticationDto) request.getSession().getAttribute("user");
//        request.setAttribute("list", UserService.getInstance().getCarsByUserId(userADto.getId()));
//        forward(ConfigurationManager.getInstance().getProperty("path.page.myAd"));
    }
}
