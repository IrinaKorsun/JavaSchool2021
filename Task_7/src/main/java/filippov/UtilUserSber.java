package filippov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Класс принимает коллекции объектов UserSber
 */

public class UtilUserSber {
    private final HashSet<UserSber> collA = new HashSet<>();

    /**
     * Конструктор без параметров заполняет коллекцию случайными рандомными именами в количестве COLLECTION_SIZE
     */
    public UtilUserSber(int collectionSize) {
        while (collA.size() < collectionSize) {
            UserSber userSber = new UserSber("name" + ((int) (Math.random() * collectionSize * 10)), "black-stripe@ya.ru");
            collA.add(userSber);
        }
    }

    /**
     * @return Метод возвращает размер коллекции
     */
    public int getCollectionSize() {
        return collA.size();
    }

    /**
     * @return Метод возвращает коллекцию
     */
    public HashSet<UserSber> getCollection() {
        return collA;
    }


    /**
     * @param inputList Конструктор принимает готовый массив для дальнейшего сравнения
     */
    public UtilUserSber(List<UserSber> inputList) {
        collA.addAll(inputList);
    }

    /**
     * Метод поиска №2 - самый медленный - для разнообразия, в тестах не используется, запуск приведет к зависанию надолго
     *
     * @param collA коллекция 1
     * @param collB коллекция 2
     * @return коллекция состоящая из дубликатов
     */
    public static List<UserSber> findDuplicatesByEqualsSlowly(Collection<UserSber> collA, Collection<UserSber> collB) {
        ArrayList<UserSber> duplicates = new ArrayList<>();
        for (UserSber i : collA) {
            for (UserSber j : collB) {
                if (i.equals(j)) {
                    duplicates.add(i);
                }
            }
        }
        return duplicates;
    }

    /**
     * Метод для поиска дубликатов в двух коллекциях
     *
     * @param collB Метод принимает коллекцию для сравнения
     * @return коллекцию состоящую из найденных дубликатов
     */
    public List<UserSber> findDuplicates(Collection<UserSber> collB) {
        ArrayList<UserSber> duplicates = new ArrayList<>();
        for (UserSber i : collA) {
            if (collB.contains(i)) {
                duplicates.add(i);
            }
        }
        return duplicates;
    }

}
