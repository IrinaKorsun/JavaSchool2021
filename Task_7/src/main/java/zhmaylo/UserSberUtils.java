package zhmaylo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UserSberUtils {

    /**
     * Функция поиска дубликатов с использованием HashSet и встроенного метода.retainAll()
     *
     * @param collA Первая коллекция UserSber
     * @param collB Вторая коллекция UserSber
     * @return возвращает ArrayList преобразуя в него set с пересечениями множеств
     */
    public static List<UserSber> findDuplicates(Collection<UserSber> collA, Collection<UserSber> collB) {
        HashSet<UserSber> setA = new HashSet<>(collA);
        HashSet<UserSber> setB = new HashSet<>(collB);
        setA.retainAll(setB);
        return new ArrayList(setA);
    }

    /**
     * Функция поиска дубликатов с использованием ArrayList и цикла for
     *
     * @param collA Первая коллекция UserSber
     * @param collB Вторая коллекция UserSber
     * @return возвращает ArrayList с дубликатами множеств.
     * время работы составляет несколько минут.
     */
    public static List<UserSber> findDuplicatesFor(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<>();
        for (UserSber user : collA) {
            if (collB.contains(user)) {
                duplicates.add(user);
            }
        }
        return duplicates;
    }

    /**
     * Функция поиска дубликатов с использованием HashSet и stream
     *
     * @param collA Первая коллекция UserSber
     * @param collB Вторая коллекция UserSber
     * @return возвращает List.
     */
    public static List<UserSber> findDuplicatesStream(Collection<UserSber> collA, Collection<UserSber> collB) {
        HashSet<UserSber> setA = new HashSet<>(collA);
        HashSet<UserSber> setB = new HashSet<>(collB);
        return setA.stream().filter(setB::contains).collect(Collectors.toList());
    }
}
