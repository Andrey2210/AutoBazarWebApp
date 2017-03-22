package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.CarDto;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.services.CarService;
import by.autobazar.services.UserService;

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
        List<CarDto> carDtoList = new LinkedList<>();
        for (Car car : carsList) {
            carDtoList.add(new CarDto(car.getId(), car.getMark(), car.getModel(), car.getImage(), car.getPrice(), car.getYear(),
                    car.getTransmission()));
        }
        request.setAttribute("list", carDtoList);

        long id = Long.parseLong(request.getParameter("id"));

        request.setAttribute("car", CarService.getInstance().getCarById(id));
        request.setAttribute("commentsList",
                CarService.getInstance().getAllCommentsByCar(id));
        forward(ConfigurationManager.getInstance().getProperty("path.page.detail"));

    }
}
