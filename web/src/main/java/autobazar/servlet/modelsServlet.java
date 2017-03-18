package autobazar.servlet;



import by.autobazar.dao.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 23.02.2017.
 */
@WebServlet(urlPatterns = "/models")
public class modelsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String make = req.getParameter("make");
        if(make != null) {
            List<String> modelList = CarDAO.getInstance().getCarModels(make);
            resp.setContentType("text/xml");
            StringBuilder result = new StringBuilder("<?xml version=\"1.0\" ?><models>");
            for(String model : modelList) {
                result.append("<model>" + model + "</model>");
            }
            result.append("</models>");
            resp.getWriter().println(result);
        }
    }
}
