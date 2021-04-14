package lesnoy;

import java.util.*;

public class UtilSber {
    private UtilSber() {
    }

    public static List<UserSber> findDuplicates(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<UserSber>(collA);
        duplicates.retainAll(collB);
        return duplicates;
    }

    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<UserSber>(collB);
        Set<UserSber> setA = new HashSet<UserSber>(collA);
        duplicates.retainAll(setA);
        return duplicates;
    }

    public static List<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<UserSber>();
        for (UserSber user : collA) {
            if (collB.contains(user)) {
                duplicates.add(user);
            }
        }
        return duplicates;
    }
}
