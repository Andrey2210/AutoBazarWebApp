package by.autobazar.util;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created by Andrey
 * Date: 29.03.2017.
 * Time: 13:52
 */
public class CustomNamingStrategy extends DefaultNamingStrategy {
    @Override
    public String classToTableName(String className) {
        return "T_" + super.classToTableName(className).toUpperCase();
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return "F_" + super.propertyToColumnName(propertyName).toUpperCase();
    }

    @Override
    public String tableName(String tableName) {
        return tableName;
    }

    @Override
    public String columnName(String columnName) {
        return columnName;
    }
}
