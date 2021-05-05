package ryzhenko;

import java.util.*;

public class Utils {

    /**
     * Утилитный метод, который возвращает дубликаты: юзеров, которые есть в обеих коллекциях.
     * Вариант 1 (Неудачный)
     * С использованием ArrayList, contains
     *
     * @param collA Первая коллекция
     * @param collB Вторая коллекция
     * @return Дубликаты
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> arrayListA = new ArrayList<>(collA);
        List<UserSber> arrayListB = new ArrayList<>(collB);
        List<UserSber> duplicates = new ArrayList<>();
        for (UserSber user : arrayListA) {
            if (arrayListB.contains(user)) {
                duplicates.add(user);
            }
        }
        return duplicates;
    }

    /**
     * Утилитный метод, который возвращает дубликаты: юзеров, которые есть в обеих коллекциях.
     * Вариант 2 (Неудачный)
     * С использованием ArrayList, retainAll
     *
     * @param collA Первая коллекция
     * @param collB Вторая коллекция
     * @return Дубликаты
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> arrayListA = new ArrayList<>(collA);
        List<UserSber> arrayListB = new ArrayList<>(collB);
        arrayListA.retainAll(arrayListB);
        return new ArrayList<>(arrayListA);
    }

    /**
     * Утилитный метод, который возвращает дубликаты: юзеров, которые есть в обеих коллекциях.
     * Вариант 3 (Удачный)
     * С ипользованием HashSet, contains
     *
     * @param collA Первая коллекция
     * @param collB Вторая коллекция
     * @return Дубликаты
     */
    public static List<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> setA = new HashSet<>(collA);
        Set<UserSber> setB = new HashSet<>(collB);
        List<UserSber> duplicates = new ArrayList<>();
        for (UserSber user : setA) {
            if (setB.contains(user)) {
                duplicates.add(user);
            }
        }
        return duplicates;
    }

    /**
     * Утилитный метод, который возвращает дубликаты: юзеров, которые есть в обеих коллекциях.
     * Вариант 4 (Удачный)
     * С ипользованием HashSet, retainAll
     *
     * @param collA Первая коллекция
     * @param collB Вторая коллекция
     * @return Дубликаты
     */
    public static List<UserSber> findDuplicates4(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> setA = new HashSet<>(collA);
        Set<UserSber> setB = new HashSet<>(collB);
        setA.retainAll(setB);
        return new ArrayList<>(setA);
    }
}
