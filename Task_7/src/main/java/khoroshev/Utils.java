package khoroshev;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    /**
     * Поиск дубликатов в двух коллекциях с помощью Set и Stream.
     * @param collA - первая коллекция из UserSber.
     * @param collB - вторая коллекция из UserSber.
     * @return список дублирующихся в коллекциях элементов.
     */
    public static List<UserSber> findDuplicates(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> users = new HashSet<>(collA);
        return collB.stream().filter(user -> !users.add(user)).collect(Collectors.toList());
    }

    /**
     * Плохой вариант поиска дубликатов.
     * Медленный поиск дубликатов в двухколлекциях с помощью перебора каждого элемента из первой коллекции
     * с каждым элементом из второй коллекции.
     * @param collA - первая коллекция из UserSber.
     * @param collB - вторая коллекция из UserSber.
     * @return список дублирующихся в коллекциях элементов.
     */
    public static List<UserSber> findDuplicatesVeryLong(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber>  users = new ArrayList<>();
        for (UserSber userSber : collA) {
            if (collB.stream().anyMatch(i -> i.equals(userSber))) {
                users.add(userSber);
            }
        }
        return users;
    }

    /**
     * Поиск дубликатов в двухколлекциях с помощью HashSet и его метода retainAll().
     * @param collA - первая коллекция из UserSber.
     * @param collB - вторая коллекция из UserSber.
     * @return список дублирующихся в коллекциях элементов.
     */
    public static List<UserSber> findDuplicatesWithHashSet(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> userSberSetA = new HashSet<>(collA);
        Set<UserSber> userSberSetB = new HashSet<>(collB);
        userSberSetA.retainAll(userSberSetB);
        return new ArrayList<>(userSberSetA);
    }
}
