package pelipenko;

import java.util.*;

public class UtilClass {

    /**
     * Поиск дубликатов с использованием HashSet и цикла for
     * @param collA Первая коллекция с объектами UserSber
     * @param collB Вторая коллекция с объектами UserSber
     * @return Коллекция с дубликатами
     */
    public static List<UserSber> findDuplicatesFast(Collection<UserSber> collA, Collection<UserSber> collB) {
        if (collA.isEmpty() || collB.isEmpty()) {
            return Collections.emptyList();
        }
        Set<UserSber> duplicates = new HashSet<>();
        Set<UserSber> setCollA = new HashSet<>(collA);
        for (UserSber user : collB) {
            if (setCollA.contains(user)) {
                duplicates.add(user);
            }
        }
        return new ArrayList<>(duplicates);
    }

    /**
     * Поиск дубликатов с использованием ArrayList и цикла for
     * @param collA Первая коллекция с объектами UserSber
     * @param collB Вторая коллекция с объектами UserSber
     * @return Коллекция с дубликатами
     */
    public static List<UserSber> findDuplicatesSlow(Collection<UserSber> collA, Collection<UserSber> collB) {
        if (collA.isEmpty() || collB.isEmpty()) {
            return Collections.emptyList();
        }
        Set<UserSber> duplicates = new HashSet<>();
        List<UserSber> setCollA = new ArrayList<>(collA);
        for (UserSber user : collB) {
            if (setCollA.contains(user)) {
                duplicates.add(user);
            }
        }
        return new ArrayList<>(duplicates);
    }

    /**
     * Поиск дубликатов с помощью HashSet и встроенного метода retainAll()
     * @param collA Первая коллекция с объектами UserSber
     * @param collB Вторая коллекция с объектами UserSber
     * @return Коллекция с дубликатами
     */
    public static List<UserSber> findDuplicatesGood(Collection<UserSber> collA, Collection<UserSber> collB){
        Set<UserSber> setCollA = new HashSet<>(collA);
        Set<UserSber> setCollB = new HashSet<>(collB);
        setCollA.retainAll(setCollB);
        return new ArrayList<>(setCollA);
    }
}
