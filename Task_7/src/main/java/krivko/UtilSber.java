package krivko;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Задание 7
 * <br> Тестируем скорость функций поиска Дубликатов
 */
public class UtilSber {
    /**
     * 1. Поиск дубликатов используя: HashSet, retainAll
     * <br>Скорость -> Норм
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> setCollA = new HashSet<>(collA);
        Set<UserSber> setCollB = new HashSet<>(collB);

        setCollA.retainAll(setCollB);
        return new ArrayList(setCollA);
    }

    /**
     * 2. Поиск дубликатов используя: HashSet, for, contains
     * <br>Скорость -> Норм
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> setCollA = new HashSet<>(collA);
        Set<UserSber> setCollB = new HashSet<>(collB);
        List<UserSber> list = new ArrayList<>();

        for (UserSber user : setCollA) {
            if (setCollB.contains(user)) {
                list.add(user);
            }
        }
        return list;
    }

    /**
     * 3. Поиск дубликатов используя: HashSet, stream.filter, contains
     * <br>Скорость -> Норм
     */
    public static List<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> setCollA = new HashSet<>(collA);
        Set<UserSber> setCollB = new HashSet<>(collB);

        return setCollA.stream().filter(s -> setCollB.contains(s)).collect(Collectors.toList());
    }

    /**
     * 4. Поиск дубликатов используя: Collection, stream.filter, contains
     * <br>Скорость -> Отстой
     */
    public static List<UserSber> findDuplicates4(Collection<UserSber> collA, Collection<UserSber> collB) {
        return collA.stream().filter(collB::contains).collect(Collectors.toList());
    }

    /**
     * 5. Поиск дубликатов используя: ArrayList, retainAll
     * <br>Скорость -> Отстой
     */
    public static List<UserSber> findDuplicates5(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> listCollA = new ArrayList<>(collA);
        List<UserSber> listCollB = new ArrayList<>(collB);

        listCollA.retainAll(listCollB);
        return listCollA;
    }

    /**
     * 6. Поиск дубликатов используя: Collections.frequency
     * <br>Скорость -> Полный Отстой
     */
    public static List<UserSber> findDuplicates6(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> list = new ArrayList<>();

        for (UserSber userA : collA)
            if (Collections.frequency(collB, userA) > 0)
                list.add(userA);
        return list;
    }
}
