package autobazar.servlet;

import by.autobazar.dao.CarDAO;
import autobazar.dto.PageDetailsDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 21.02.2017.
 */
//@WebServlet(urlPatterns = "/autobazar/carsTable")
//public class carsTableServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getSession().getAttribute("pageDetails") == null){
//            PageDetailsDto pageDetails = new PageDetailsDto(CarDAO.getInstance().getAmountOfCars());
//            req.getSession().setAttribute("pageDetails", pageDetails);
//            req.setAttribute("list",CarDAO.getInstance().getLimitOrderBy(pageDetails.getSort(), 0, pageDetails.getItemsOnPage()));
//        } else if(req.getParameter("page") != null) {
//            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
//            pageDetails.setPageNumber(Integer.parseInt(req.getParameter("page")));
//            req.setAttribute("list",CarDAO.getInstance().getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
//        } else if(req.getParameter("sort") != null) {
//            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
//            pageDetails.setSort(req.getParameter("sort"));
//            req.setAttribute("list",CarDAO.getInstance().getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
//        } else  {
//            PageDetailsDto pageDetails = (PageDetailsDto) req.getSession().getAttribute("pageDetails");
//            req.setAttribute("list",CarDAO.getInstance().getLimitOrderBy(pageDetails.getSort(), 0, pageDetails.getItemsOnPage()));
//        }
//        req.setAttribute("allMakes", CarDAO.getInstance().getCarsMakes());
//        getServletContext().getRequestDispatcher("/WEB-INF/jsp/carsTable.jsp").forward(req, resp);
//    }
//}
