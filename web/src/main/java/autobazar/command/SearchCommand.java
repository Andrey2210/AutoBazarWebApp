package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.CarDto;
import autobazar.dto.PageDetailsDto;
import by.autobazar.dao.CarDAO;
import by.autobazar.entity.Car;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 15.03.2017.
 */
public class SearchCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        if(request.getParameter("sort") != null) {
            PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
            pageDetails.setSort(request.getParameter("sort"));
            request.setAttribute("list",CarDAO.getInstance().getLimitOrderBy(pageDetails.getSort(),(pageDetails.getPageNumber()-1)*pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage()));
        } else {
            Enumeration<String> e = request.getParameterNames();
            HashMap<String, String> search = new HashMap<>();
            while (e.hasMoreElements()) {
                String q = e.nextElement();
                String str = request.getParameter(q);
                System.out.println(q + ": " + str);
                if (!str.equals("")) {
                    search.put(q, str);
                }
            }
            request.setAttribute("list", CarDAO.getInstance().searchCars(search));
            request.setAttribute("allMakes", CarDAO.getInstance().getCarsMakes());
        }
        String page = ConfigurationManager.getInstance().getProperty("path.page.carsList");
        forward(page);
    }
    }
//        List<Car> carsList = CarService.getInstance().getLimitAmount();
//        List<CarDto> carDtoList = new LinkedList<>();
//        for (Car car : carsList) {
//            carDtoList.add(new CarDto(car.getMark(), car.getModel(), car.getImage(), car.getPrice(), car.getYear(),
//                    car.getTransmission()));
//        }
//        request.setAttribute("list", carDtoList);
//        request.setAttribute("allMakes", CarDAO.getInstance().getCarsMakes());
//
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
//
//
//        forward("autoBazar");
//
//    }
//}
