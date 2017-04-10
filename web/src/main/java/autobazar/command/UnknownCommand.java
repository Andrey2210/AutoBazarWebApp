package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.CarDto;
import by.autobazar.entity.Car;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 15.03.2017.
 */
public class UnknownCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {

        String uri = request.getRequestURI();
        FrontCommand command;
        switch (uri) {
            case "/autobazar/registration":
                forward(ConfigurationManager.getInstance().getProperty("path.page.registration"));
                break;
            case "/autobazar/login":
                forward(ConfigurationManager.getInstance().getProperty("path.page.login"));
                break;
            case "/autobazar/submit":
                 command = new SubmitCommand();
                command.init(context, request, response);
                command.process();
                return;
            case "/autobazar/dashboard":
                 command = new DashboardCommand();
                command.init(context, request, response);
                command.process();
                return;
            default:
                request.getSession().removeAttribute("pageDetails");
                List<Car> carsList = CarService.getInstance().getLimitAmount();
                request.setAttribute("list", carsList);
                request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
                String page = ConfigurationManager.getInstance().getProperty("path.page.index");
                forward(page);
        }
    }
}