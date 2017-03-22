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

        switch (uri) {
            case "/autobazar/registration":
                forward(ConfigurationManager.getInstance().getProperty("path.page.registration"));
                break;
            case "/autobazar/login":
                forward(ConfigurationManager.getInstance().getProperty("path.page.login"));
                break;
            case "/autobazar/submit":
                FrontCommand command = new SubmitCommand();
                command.init(context, request, response);
                command.process();
                return;
            default:
                request.getSession().removeAttribute("pageDetails");
                List<Car> carsList = CarService.getInstance().getLimitAmount();
                List<CarDto> carDtoList = new LinkedList<>();
                for (Car car : carsList) {
                    carDtoList.add(new CarDto(car.getId(), car.getMark(), car.getModel(), car.getImage(), car.getPrice(), car.getYear(),
                            car.getTransmission()));
                }

                request.setAttribute("list", carDtoList);
                request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
                String page = ConfigurationManager.getInstance().getProperty("path.page.index");
                forward(page);
        }
    }
}