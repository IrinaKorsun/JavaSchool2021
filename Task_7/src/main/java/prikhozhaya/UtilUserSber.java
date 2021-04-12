package prikhozhaya;

import java.util.*;

public class UtilUserSber {

    /*
     *Утилитный метод, возвращающий дубликаты юзеров, которые присутствуют в обеих коллекциях, поданных на вход функции.
     * Реализовано с использованием списков ArrayList.
     *
     * @param collA - первая коллекция объектов UserSber, collB - вторая коллекция объектов UserSber.
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> newCollA = new ArrayList<>(collA);
        List<UserSber> newCollB = new ArrayList<>(collB);
        newCollA.retainAll(newCollB);
        Set<UserSber> set = new HashSet<>(newCollA);
        return new ArrayList<>(set);
    }

    /*
     *Утилитный метод, возвращающий дубликаты юзеров, которые присутствуют в обеих коллекциях, поданных на вход функции.
     * Реализовано с использованием множества HashSet.
     *
     * @param collA - первая коллекция объектов UserSber, collB - вторая коллекция объектов UserSber.
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> newCollA = new HashSet<>(collA);
        Set<UserSber> newCollB = new HashSet<>(collB);
        List<UserSber> result = new ArrayList<>();
        for (UserSber user : newCollA) {
            if (newCollB.contains(user)) {
                result.add(user);
            }
        }
        return result;
    }
}
