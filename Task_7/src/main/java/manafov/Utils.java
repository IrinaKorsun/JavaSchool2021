package manafov;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Utils {
    private Utils() {
    }

    /**
     * Находит дубликаты в двух коллекциях. Используется метод <code>contains(Object o)</code> коллекции HashSet.
     *
     * @param collA первая коллекция.
     * @param collB вторая коллекция.
     * @return список дубликатов.
     */
    public static List<UserSber> findDuplicates(Collection<UserSber> collA, Collection<UserSber> collB) {
        if (collA.isEmpty() || collB.isEmpty())
            return Collections.emptyList();
        Set<UserSber> duplicates = new HashSet<>();
        Set<UserSber> setOfCollA = new HashSet<>(collA);
        for (UserSber user : collB) {
            if (setOfCollA.contains(user))
                duplicates.add(user);
        }
        return new ArrayList<>(duplicates);
    }

    /**
     * Находит дубликаты в двух коллекциях. С помощью Stream API подсчитывается количество повторов элементов,
     * и в список записываются элементы с количеством повторов > 1.
     *
     * @param collA первая коллекция.
     * @param collB вторая коллекция.
     * @return список дубликатов.
     */
    public static List<UserSber> findDuplicatesNotBad(Collection<UserSber> collA, Collection<UserSber> collB) {
        if (collA.isEmpty() || collB.isEmpty())
            return Collections.emptyList();
        Set<UserSber> setOfCollA = new HashSet<>(collA);
        Set<UserSber> setOfCollB = new HashSet<>(collB);
        return Stream.of(setOfCollA, setOfCollB)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Находит дубликаты в двух коллекциях. Используется метод <code>contains(Object o)</code> коллекции ArrayList.
     *
     * @param collA первая коллекция.
     * @param collB вторая коллекция.
     * @return список дубликатов.
     */
    public static List<UserSber> findDuplicatesBad(Collection<UserSber> collA, Collection<UserSber> collB) {
        if (collA.isEmpty() || collB.isEmpty())
            return Collections.emptyList();
        Set<UserSber> duplicates = new HashSet<>();
        List<UserSber> listOfCollA = new ArrayList<>(collA);
        for (UserSber user : collB) {
            if (listOfCollA.contains(user))
                duplicates.add(user);
        }
        return new ArrayList<>(duplicates);
    }
}
