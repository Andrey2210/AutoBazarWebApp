package by.autobazar.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Andrey on 10.01.2017.
 */
public class DbConnection {

    public static final Logger log = Logger.getLogger(DbConnection.class);

    private static HikariConfig config;
    private static HikariDataSource  dataSource;
    private static Properties properties;
    static {
        properties = new Properties();
        properties.setProperty("dataSourceClassName", "com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        properties.setProperty("dataSource.user", "root");
        properties.setProperty("dataSource.password", "root");
        properties.setProperty("dataSource.databaseName", "autobazar");

        config = new HikariConfig(properties);
        dataSource = new HikariDataSource(config);
    }

    private DbConnection() {
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
