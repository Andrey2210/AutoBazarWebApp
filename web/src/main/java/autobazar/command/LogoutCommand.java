package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.entity.Car;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class LogoutCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        request.getSession().invalidate();
        request.getSession().removeAttribute("pageDetails");
        List<Car> carsList = CarService.getInstance().getLimitAmount();
        request.setAttribute("list", carsList);
        request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
        forward(ConfigurationManager.getInstance().getProperty("path.page.index"));
    }
}
