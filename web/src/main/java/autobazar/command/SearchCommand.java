package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.PageDetailsDto;
import by.autobazar.entity.carEnum.*;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Andrey on 15.03.2017.
 */
public class SearchCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        String page;
        if (request.getSession().getAttribute("pageDetails") == null) {
            PageDetailsDto pageDetails = new PageDetailsDto(CarService.getInstance().getAmountOfCars(getSearchOptions()));
            pageDetails.setSearchParameters(getSearchOptions());
            request.getSession().setAttribute("pageDetails", pageDetails);
            request.setAttribute("list", CarService.getInstance()
                    .searchCars(getSearchOptions(), pageDetails.getSort(), 0, pageDetails.getItemsOnPage()));
            request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
            page = ConfigurationManager.getInstance().getProperty("path.page.carsList");
        } else {
            PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
            pageDetails.setAmountOfItems(CarService.getInstance().getAmountOfCars(getSearchOptions()));
            pageDetails.setSearchParameters(getSearchOptions());
            request.setAttribute("list", CarService.getInstance()
                    .searchCars(getSearchOptions(), pageDetails.getSort(),
                            (pageDetails.getPageNumber() - 1) * pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
            request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
            page = ConfigurationManager.getInstance().getProperty("path.page.carsList");
        }
        forward(page);
    }


    private HashMap<String, String> getSearchOptions() {
        Enumeration e = request.getParameterNames();
        HashMap<String, String> serchMap = new HashMap<>();
        while (e.hasMoreElements()) {
            String q = (String) e.nextElement();
            String str = request.getParameter(q);
            if (!str.equals("")) {
                serchMap.put(q, str);
            }
        }
        serchMap.remove("command");
        return serchMap;
    }
}