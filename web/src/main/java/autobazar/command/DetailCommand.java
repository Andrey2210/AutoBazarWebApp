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
 * Created by Andrey on 21.03.2017.
 */
public class DetailCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {

        List<Car> carsList = CarService.getInstance().getLimitAmount();
        request.setAttribute("list", carsList);

        long id = Long.parseLong(request.getParameter("id"));

        Car car = CarService.getInstance().getCarById(id);
        request.setAttribute("car", car);
        request.setAttribute("commentsList", car.getCommentList());
        forward(ConfigurationManager.getInstance().getProperty("path.page.detail"));

    }
}
