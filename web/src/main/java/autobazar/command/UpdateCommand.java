package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.services.CarService;
import by.autobazar.services.ServiceException;
import by.autobazar.services.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Andrey
 * Date: 09.04.2017.
 * Time: 23:37
 */
public class UpdateCommand extends FrontCommand {
    private HashMap<String, String> parametersMap = new HashMap<>();

    @Override
    public void process() throws ServletException, IOException {
        Enumeration e = request.getParameterNames();
        HashMap<String, String> parametersMap = new HashMap<>();
        while (e.hasMoreElements()) {
            String q = (String) e.nextElement();
            String str = request.getParameter(q);
            if (!str.equals("")) {
                parametersMap.put(q, str);
            }
        }
        parametersMap.remove("command");

        try {
            long flag = CarService.getInstance().updateCar(parametersMap);
        } catch (ServiceException e1) {
            request.setAttribute("errorMessage", e1.getMessage());
        }
        UserAuthenticationDto userADto = (UserAuthenticationDto) request.getSession().getAttribute("user");
        request.setAttribute("list", UserService.getInstance().getCarsByUserId(userADto.getId()));
        forward(ConfigurationManager.getInstance().getProperty("path.page.profile"));
    }
}
