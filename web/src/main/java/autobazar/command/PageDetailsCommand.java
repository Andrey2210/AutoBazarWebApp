package autobazar.command;

import autobazar.dto.PageDetailsDto;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 21.03.2017.
 */
public class PageDetailsCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");

        if (request.getParameter("sort") != null) {
            pageDetails.setSort(request.getParameter("sort"));
        }
        if (request.getParameter("pageNumber") != null) {
            pageDetails.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
        }
        if (request.getParameter("itemsOnPage") != null) {
            pageDetails.setItemsOnPage(Integer.parseInt(request.getParameter("itemsOnPage")));
        }

        if (request.getParameter("pageType") != null) {
            pageDetails.setPageType(request.getParameter("pageType"));
        }
        request.getSession().setAttribute("pageDetails", pageDetails);
        forward("/controller?command=Search");
    }
}
