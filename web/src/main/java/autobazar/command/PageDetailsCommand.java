package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.PageDetailsDto;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Andrey on 21.03.2017.
 */
public class PageDetailsCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
//        PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
//        if (request.getParameter("sort") != null) {
//            pageDetails.setSort(request.getParameter("sort"));
//        }
//        if (request.getParameter("pageNumber") != null) {
//            pageDetails.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
//        }
//        if (request.getParameter("itemsOnPage") != null) {
//            pageDetails.setItemsOnPage(Integer.parseInt(request.getParameter("itemsOnPage")));
//        }
//        if (request.getParameter("pageType") != null) {
//            pageDetails.setPageType(request.getParameter("pageType"));
//        }
//        HashMap<String, String> searchParameters = pageDetails.getSearchParameters();
//        request.setAttribute("list", CarService.getInstance()
//                .searchCars(searchParameters, pageDetails.getSort(),
//                        (pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
//        request.setAttribute("allMakes", CarService.getInstance().getCarsMakes());
//        String page = ConfigurationManager.getInstance().getProperty("path.page." + pageDetails.getPageType());
//        forward(page);
    }
}
