package autobazar.command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Andrey on 15.03.2017.
 */
public class UnknownCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        forward("unknown");
    }
}