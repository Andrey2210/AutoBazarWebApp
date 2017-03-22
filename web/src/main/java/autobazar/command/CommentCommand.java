package autobazar.command;

import autobazar.ConfigurationManager;
import by.autobazar.services.CarService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 22.03.2017.
 */
public class CommentCommand extends FrontCommand  {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getParameter("comment") != null) {
            CarService.getInstance().createComment(request.getParameter("comment"),
                    Long.parseLong(request.getParameter("carId")), Long.parseLong(request.getParameter("userId")));
        }
        request.setAttribute("commentsList",
                CarService.getInstance().getAllCommentsByCar(Long.parseLong(request.getParameter("carId"))));

    forward(ConfigurationManager.getInstance().getProperty("path.page.comments"));
    }
}
