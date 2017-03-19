package by.autobazar.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Andrey on 10.01.2017.
 */

/**
 * @author Andrey
 * Class to get the connection object from the HikariPool
 */
public class DbConnection {

    private static final Logger log = Logger.getLogger(DbConnection.class);


    private static HikariConfig config;
    private static HikariDataSource  dataSource;
    private static Properties properties;
    static {
        log.info("Creation HikariPool: ");

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

    /**
     * Function to get the connection object
     *
     * @return Returns the connection object
     */
    public static Connection getConnection() {
        try {
            log.info("Getting Connection: ");
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Connection error: " + e);
        }
        return null;
    }
}
