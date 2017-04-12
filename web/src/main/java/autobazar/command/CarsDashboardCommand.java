package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 28.03.2017.
 */
public class CarsDashboardCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("cars", CarService.getInstance().getAllCars("id", 0, 100));
        forward(ConfigurationManager.getInstance().getProperty("path.page.carsDashboard"));
    }
}
