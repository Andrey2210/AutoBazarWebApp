package autobazar.command;

import autobazar.ConfigurationManager;
import autobazar.dto.UserAuthenticationDto;
import by.autobazar.entity.User;
import by.autobazar.services.CarService;
import by.autobazar.services.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Andrey on 21.03.2017.
 */
public class SubmitCommand extends FrontCommand {
    private HashMap<String, String> parametersMap = new HashMap<>();

    @Override
    public void process() throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            UserAuthenticationDto userAuthenticationDto = (UserAuthenticationDto) request.getSession().getAttribute("user");
            User userData = UserService.getInstance().getLoggedUser(userAuthenticationDto.getLogin(), userAuthenticationDto.getPassword());

            request.setAttribute("allMakes", CarService.getInstance().getAllCarsMakes());
            request.setAttribute("userData", userData);
            forward(ConfigurationManager.getInstance().getProperty("path.page.submit"));
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();


        factory.setSizeThreshold(1024 * 1024);

        File tempDir = (File) request.getSession().getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        ServletFileUpload upload = new ServletFileUpload(factory);


        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (item.isFormField()) {
                    processFormField(item);
                } else {
                    processUploadedFile(item);
                }
            }
            UserAuthenticationDto userAuthenticationDto = (UserAuthenticationDto) request.getSession().getAttribute("user");
            boolean flag = CarService.getInstance().createCar(parametersMap, userAuthenticationDto.getId());
            response.sendRedirect("/autobazar/controller");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
    }


    private void processUploadedFile(FileItem item) throws Exception {
        File uploadetFile = null;
        Random random = new Random();
        do {
            String path = context.getRealPath(File.separator + "media" + File.separator + "237x202" + File.separator + random.nextInt() + item.getName());
            parametersMap.put("image_path", path);
            uploadetFile = new File(path);
        } while (uploadetFile.exists());

        uploadetFile.createNewFile();

        item.write(uploadetFile);
    }


    private void processFormField(FileItem item) {
        parametersMap.put(item.getFieldName(), item.getString());
    }

}
