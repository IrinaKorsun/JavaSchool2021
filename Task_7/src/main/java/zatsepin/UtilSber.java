package zatsepin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for working with lists of  UserSber objects.
 */
public class UtilSber {

    /**
     * Returns a list of duplicates that are contained in both collections.
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> listOfDuplicates = new ArrayList<>();
        Set<UserSber> setA = new HashSet<>(collA);
        Set<UserSber> setB = new HashSet<>(collB);
        for (UserSber user : setA) {
            if (setB.contains(user)) {
                listOfDuplicates.add(user);
            }
        }
        return listOfDuplicates;
    }

    /**
     * Returns a list of duplicates that are contained in both collections.
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> listOfDuplicates = collA.stream()
                .distinct()
                .filter(collB::contains)
                .collect(Collectors.toList());

        return listOfDuplicates;
    }
}
