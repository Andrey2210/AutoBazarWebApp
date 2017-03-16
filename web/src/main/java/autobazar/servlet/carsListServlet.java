package autobazar.servlet;

import by.autobazar.dao.CarDAO;
import autobazar.dto.PageDetailsDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Andrey on 21.02.2017.
 */
@WebServlet(urlPatterns = "/autobazar/carsList")
public class carsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAO carDAO = new CarDAO();
        if(req.getSession().getAttribute("pageDetails") == null){
            PageDetailsDto pageDetails = new PageDetailsDto(carDAO.getAmountOfCars());
            req.getSession().setAttribute("pageDetails", pageDetails);
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(), 0, pageDetails.getItemsOnPage()));
        } else if(req.getParameter("page") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
            pageDetails.setPageNumber(Integer.parseInt(req.getParameter("page")));
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
        } else if(req.getParameter("sort") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
            pageDetails.setSort(req.getParameter("sort"));
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
        } else if(req.getParameter("onPage") != null) {

        }
        req.setAttribute("allMakes", carDAO.getCarsMakes());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/carsList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAO carDAO = new CarDAO();
        if(req.getParameter("sort") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
            pageDetails.setSort(req.getParameter("sort"));
            req.setAttribute("list",carDAO.getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
        } else {
            Enumeration<String> e = req.getParameterNames();
            HashMap<String, String> search = new HashMap<>();
            while (e.hasMoreElements()) {
                String q = e.nextElement();
                String str = req.getParameter(q);
                System.out.println(q + ": " + str);
                if (!str.equals("")) {
                    search.put(q, str);
                }
            }
            req.setAttribute("list", carDAO.searchCars(search));
            req.setAttribute("allMakes", carDAO.getCarsMakes());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/carsList.jsp").forward(req, resp);
    }


}
