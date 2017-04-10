package by.autobazar.dao;

import by.autobazar.entity.Image;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by Andrey
 * Date: 31.03.2017.
 * Time: 0:14
 */
public class ImageDao extends BaseDao<Image> {

    private static Logger log = Logger.getLogger(ImageDao.class);
    private static ImageDao INSTANCE = null;

    private ImageDao() {
    }

    public static ImageDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ImageDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageDao();
                }
            }
        }
        return INSTANCE;
    }

}
