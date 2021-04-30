package podolyak;

import java.util.*;
import java.util.stream.Collectors;

public class Util {
    /**
     * Метод находит дубликаты, ооооооооочень долго, около 3х мин. для двух коллекций по 100_000 значений
     *
     * @param collA UserSber
     * @param collB UserSber
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<>();
        for (UserSber user1 : collA) {
            for (UserSber user2 : collB) {
                if (user1.equals(user2)) {
                    duplicates.add(user1);
                    break;
                }
            }
        }
        return duplicates.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Метод находит дубликаты быстро, использует встроенную функцию Collection1.retainAll(Collection2)
     *
     * @param collA UserSber
     * @param collB UserSber
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> A = new HashSet<>(collA);
        Set<UserSber> B = new HashSet<>(collB);
        A.retainAll(B);
        return new ArrayList<>(A);
    }
}
