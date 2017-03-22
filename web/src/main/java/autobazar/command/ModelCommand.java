package autobazar.command;

import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class ModelCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        String make = request.getParameter("make");
        List<String> modelList = null;
        if (make != null) {
            modelList = CarService.getInstance().getCarsModels(make);
        } else {
            make = request.getParameter("allMake");
           modelList = CarService.getInstance().getAllCarModels(make);

        }
            response.setContentType("text/xml");
            StringBuilder result = new StringBuilder("<?xml version=\"1.0\" ?><models>");
            for (String model : modelList) {
                result.append("<model>" + model + "</model>");
            }
            result.append("</models>");
            response.getWriter().println(result);
    }
}
