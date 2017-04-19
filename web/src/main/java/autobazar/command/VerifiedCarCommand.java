package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey
 * Date: 10.04.2017.
 * Time: 0:50
 */
public class VerifiedCarCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String flag = request.getParameter("verified");
        long id = Long.parseLong(request.getParameter("id"));
        CarService.getInstance().verifiedCar(id, flag);
        request.setAttribute("cars", CarService.getInstance().getAllCars("id", 0, 100));
        forward(ConfigurationManager.getInstance().getProperty("path.page.carsDashboard"));
    }
}
