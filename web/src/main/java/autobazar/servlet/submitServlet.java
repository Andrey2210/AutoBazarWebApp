package autobazar.servlet;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Created by Andrey on 25.02.2017.
 */
@WebServlet(urlPatterns = "/autobazar/submit")
public class submitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/submit1.jsp").forward(req, resp);
    }

    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration<String> e = req.getParameterNames();
//        HashMap<String, String> search = new HashMap<>();
//        while (e.hasMoreElements()) {
//            String q = e.nextElement();
//            String str = req.getParameter(q);
//            System.out.println(q + ": " + str);
//        }
////        getServletContext().getRequestDispatcher("/WEB-INF/jsp/submit3.jsp").include(req, resp);
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //проверяем является ли полученный запрос multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Создаём класс фабрику
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Максимальный буфера данных в байтах,
        // при его привышении данные начнут записываться на диск во временную директорию
        // устанавливаем один мегабайт
        factory.setSizeThreshold(1024 * 1024);

        // устанавливаем временную директорию
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        //Создаём сам загрузчик
        ServletFileUpload upload = new ServletFileUpload(factory);

        //максимальный размер данных который разрешено загружать в байтах
        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт.
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (item.isFormField()) {
                    //если принимаемая часть данных является полем формы
                    processFormField(item);
                } else {
                    //в противном случае рассматриваем как файл
                    processUploadedFile(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
    }


    private void processUploadedFile(FileItem item) throws Exception {
        File uploadetFile = null;
        Random random = new Random();
        //выбираем файлу имя пока не найдём свободное
        do {
            String path = "C:" + File.separator +"Users" + File.separator + "Andrey" + File.separator +
                    "IdeaProjects" + File.separator + "AutoBazar" + File.separator + "web" + File.separator +
                    "media" + File.separator + "237x202" + File.separator + random.nextInt() + item.getName();
            uploadetFile = new File(path);
        } while (uploadetFile.exists());

        //создаём файл
        uploadetFile.createNewFile();
        //записываем в него данные
        item.write(uploadetFile);
    }


    private void processFormField(FileItem item) {
        System.out.println(item.getFieldName() + "=" + item.getString());
    }
}

