package sartakova;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Получение данных из файла сonfig.properties
 */

public class Properties {
    protected static FileInputStream fileInputStream;
    protected static java.util.Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/sartakova/config.properties");
            properties = new java.util.Properties();
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
     * Возвращение значений параметров из файла сonfig.Properties в соответствии значеням их ключей.
     * @param key ключ параметра.
     * @return значение параметра.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
