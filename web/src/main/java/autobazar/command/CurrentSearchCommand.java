package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.PageDetailsDto;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Andrey on 28.03.2017.
 */
public class CurrentSearchCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
        HashMap<String, String> searchParameters = pageDetails.getSearchParameters();
        request.setAttribute("list", CarService.getInstance()
                .searchCars(searchParameters, pageDetails.getSort(),
                        (pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
        request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
        String page = ConfigurationManager.getInstance().getProperty("path.page." + pageDetails.getPageType());
        forward(page);

    }
}
