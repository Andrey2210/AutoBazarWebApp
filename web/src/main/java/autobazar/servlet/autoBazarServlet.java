package autobazar.servlet;



import autobazar.dto.CarDto;
import by.autobazar.dao.CarDAO;
import by.autobazar.entity.Car;
import by.autobazar.services.CarService;
import autobazar.dto.PageDetailsDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 21.02.2017.
 */
@WebServlet(urlPatterns = "/autobazar")
public class autoBazarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAO carDAO = new CarDAO();
        List<Car> carsList = CarService.getInstance().getLimitAmount();
        List<CarDto> carDtoList = new LinkedList<>();
        for (Car car : carsList) {
            carDtoList.add(new CarDto(car.getMark(), car.getModel(), car.getImage(), car.getPrice(), car.getYear(),
                    car.getTransmission()));
        }

        req.setAttribute("list", carDtoList);
        req.setAttribute("allMakes", carDAO.getCarsMakes());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/autoBazar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAO carDAO = new CarDAO();
        if(req.getParameter("sort") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
            pageDetails.setSort(req.getParameter("sort"));
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
        } else if(req.getParameter("page") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
            pageDetails.setItemsOnPage(Integer.parseInt(req.getParameter("page")));
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));

        } else if(req.getParameter("pageNumber") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
            pageDetails.setPageNumber(Integer.parseInt(req.getParameter("pageNumber")));
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));

        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/items.jsp").include(req, resp);

    }
}