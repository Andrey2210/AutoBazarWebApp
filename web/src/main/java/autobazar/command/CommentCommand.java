package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.CarService;
import by.autobazar.services.CommentService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 22.03.2017.
 */
public class CommentCommand extends FrontCommand  {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getParameter("comment") != null) {
            CommentService.getInstance().createComment(request.getParameter("comment"),
                    Long.parseLong(request.getParameter("carId")), Long.parseLong(request.getParameter("userId")));
        }
        request.setAttribute("commentsList",
                CarService.getInstance().getCarById(Long.parseLong(request.getParameter("carId"))).getCommentList());
    forward(ConfigurationManager.getInstance().getProperty("path.page.comments"));
    }
}
