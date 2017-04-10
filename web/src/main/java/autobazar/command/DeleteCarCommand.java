package autobazar.command;

import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey
 * Date: 10.04.2017.
 * Time: 0:12
 */
public class DeleteCarCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        if(id != 0) {
            CarService.getInstance().deleteCar(id);
        }
      forward("/autobazar/dashboard");
    }
}
