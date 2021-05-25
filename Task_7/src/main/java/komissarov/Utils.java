package komissarov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {

    /**
     * Поиск дубликатов в двух коллекциях с помощью метода retainAll
     *
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return - список дубликатов
     */
    public static List<UserSber> findDuplicates(Collection<UserSber> collA, Collection<UserSber> collB) {
        collA.retainAll(collB);
        return new ArrayList<>(collA);
    }

    /**
     * Поиск дубликатов в двух коллекциях с помощью метода forEach
     *
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return - список дубликатов
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        ArrayList<UserSber> listDuplicates = new ArrayList<>();
        collA.forEach(userSber -> {
            if (collB.contains(userSber)) {
                listDuplicates.add(userSber);
            }
        });
        return listDuplicates;
    }
}
