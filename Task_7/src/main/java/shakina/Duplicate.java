package shakina;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Duplicate {

    /**
     * Поиск дубликатов в двух коллекциях с помощью Set и цикла For
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return список дублирующихся в коллекциях элементов (пересечение коллекций)
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
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
     * Поиск дубликатов в двух коллекциях с помощью Set и Stream
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return список дублирующихся в коллекциях элементов (пересечение коллекций)
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> uniqUsers = new HashSet<>(collA);
        return collB.stream().filter(user -> !uniqUsers.add(user)).collect(Collectors.toList());
    }

    /**
     * Поиск дубликатов в двух коллекциях с помощью Stream
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return список дублирующихся в коллекциях элементов (пересечение коллекций)
     */
    public static List<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {
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
