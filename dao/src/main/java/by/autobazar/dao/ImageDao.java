package by.autobazar.dao;

import by.autobazar.entity.Image;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class contains special methods for working with the entity Image
 *
 */
@Repository
public class ImageDao extends BaseDao<Image> implements IImageDao{

    private static Logger log = Logger.getLogger(ImageDao.class);

    @Autowired
    private ImageDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
