package prikhozhaya;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Необходим для получения данных из файла сonfig.properties
 */
public class ConfigProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/prikhozhaya/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Возвращает значения параметров из файла сonfig.properties в соответствии значеням их ключей.
     * @param key ключ параметра.
     * @return значение параметра.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

