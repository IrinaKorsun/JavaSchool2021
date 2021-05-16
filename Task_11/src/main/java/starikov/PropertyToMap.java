package starikov;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Класс, читающий проперти в карту
 */
public class PropertyToMap {
    private static final String FILE_PATH = "src/test/resources/starikov";
    private static final Properties property = new Properties();
    private Map<String, String> propertyMap;

    public PropertyToMap(String fileName) {
        propertyMap = getPropertyFromFile(fileName);
    }

    /**
     * Считывает данные из properties-файла в HashMap
     *
     * @param fileName имя файла свойств
     * @return HashMap со свойствами из properties-файла
     */
    private static Map<String, String> getPropertyFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH + "/" + fileName)) {
            property.load(fis);
        } catch (IOException e) {
            System.err.println("Невозможно прочитать файл");
            e.printStackTrace();
        }

        Map<String, String> propertyMap = new HashMap<>();
        for (String name : property.stringPropertyNames()) {
            propertyMap.put(name, property.getProperty(name));
        }
        return propertyMap;
    }

    /**
     * Возвращает значение property из карты
     *
     * @param propertyName имя property, значение которого нужно получить
     * @return значение property
     */
    public String getProperty(String propertyName) {
        return propertyMap.get(propertyName);
    }
}
