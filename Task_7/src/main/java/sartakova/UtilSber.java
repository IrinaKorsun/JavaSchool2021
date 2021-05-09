package sartakova;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilSber {
    /**
     * Метод, возвращающий дубликаты в двух коллекциях с помощью Set и цикла For
     * @param collA - первая коллекция объектов UserSber
     * @param collB - вторая коллекция объектов UserSber
     * @return список дублирующихся в коллекциях элементов
     */
    public static List<UserSber> findDuplicatesSetFor(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> uniqElementsCollectionA = new HashSet<>(collA);
        List<UserSber> duplicates = new ArrayList<>();
        for (UserSber userSber : collB) {
            if (!uniqElementsCollectionA.add(userSber)) {
                duplicates.add(userSber);
            }
        }
        return duplicates;
    }

    /**
     * Метод, возвращающий дубликаты в двух коллекциях с помощью Set и Stream
     * @param collA - первая коллекция объектов UserSber
     * @param collB - вторая коллекция объектов UserSber
     * @return список дублирующихся в коллекциях элементов
     */
    public static List<UserSber> findDuplicatesSetStream(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> uniqUsers = new HashSet<>(collA);
        return collB.stream().filter(user -> !uniqUsers.add(user)).collect(Collectors.toList());
    }

    /**
     * Метод, возвращающий дубликаты в двух коллекциях с помощью Stream
     * @param collA - первая коллекция объектов UserSber
     * @param collB - вторая коллекция объектов UserSber
     * @return список дублирующихся в коллекциях элементов
     */
    public static List<UserSber> findDuplicatesStream(Collection<UserSber> collA, Collection<UserSber> collB) {
        return Stream.of(collA, collB)
                .flatMap(col -> col.stream().distinct())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
