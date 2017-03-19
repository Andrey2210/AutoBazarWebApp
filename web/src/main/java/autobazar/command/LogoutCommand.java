package autobazar.command;

import autobazar.ConfigurationManager;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 19.03.2017.
 */
public class LogoutCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        request.getSession().invalidate();
        String page = ConfigurationManager.getInstance().getProperty("path.page.index");
        forward(page);
    }
}
