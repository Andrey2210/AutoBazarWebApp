package autobazar;

import java.util.ResourceBundle;

/**
 * Created by Andrey on 18.03.2017.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    private static ConfigurationManager INSTANCE = null;

    public static ConfigurationManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ConfigurationManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConfigurationManager();
                }
            }
        }
        return INSTANCE;
    }
    private ConfigurationManager() { }
    public  String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
