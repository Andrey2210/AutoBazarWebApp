package autobazar.servlet;

import autobazar.command.FrontCommand;
import autobazar.command.UnknownCommand;
import by.autobazar.entity.Car;
import by.autobazar.services.CarService;
import by.autobazar.services.ICarService;
import by.autobazar.services.IService;
import by.autobazar.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 15.03.2017.
 */
//@WebServlet(urlPatterns = {"/controller", "/registration", "/login", "/submit", "/dashboard"})
//public class FrontControllerServlet extends HttpServlet {
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        AbstractService.session = HibernateUtil.getHibernateUtil().getSession();
//        FrontCommand command = getCommand(req);
//        command.init(getServletContext(), req, resp);
//        command.process();
//        HibernateUtil.getHibernateUtil().closeSession(AbstractService.session);
//    }
//
//    private FrontCommand getCommand(HttpServletRequest request) {
//        try {
//            Class type = Class.forName(String.format("autobazar.command.%sCommand", request.getParameter("command")));
//            return (FrontCommand) type
//                    .asSubclass(FrontCommand.class)
//                    .newInstance();
//        } catch (Exception e) {
//            return new UnknownCommand();
//        }
//    }
//
//}
@Controller
public class FrontControllerServlet {

    private ICarService carService;

    @Autowired
    public FrontControllerServlet(ICarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = {"/controller"})
    public String homePage(ModelMap modelMap) {
        List<Car> carsList = carService.getLimitAmount();
        modelMap.addAttribute("list", carsList);
        modelMap.addAttribute("allMakes", carService.getCarsMakes());
        return "autoBazar";
    }
}