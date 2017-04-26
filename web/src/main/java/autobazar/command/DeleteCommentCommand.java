package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.entity.Car;
import by.autobazar.services.CarService;
import by.autobazar.services.CommentService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey
 * Date: 11.04.2017.
 * Time: 23:17
 */
public class DeleteCommentCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        CommentService.getInstance().deleteComment(Long.parseLong(request.getParameter("id")));
//        Car car = CarService.getInstance().getCarById(Long.parseLong(request.getParameter("carId")));
//        request.setAttribute("car", car);
//        request.setAttribute("commentsList", car.getCommentList());
//        forward(ConfigurationManager.getInstance().getProperty("path.page.comments"));
    }
}
