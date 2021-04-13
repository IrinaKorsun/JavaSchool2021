package bakunov;

import java.util.*;
import java.util.stream.Collectors;

public class SberUtils {
    private SberUtils() {
    }

    public static List<UserSber> findDuplicates(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> userSetA = new HashSet<>(collA);
        List<UserSber> listSetB = new LinkedList<>(collB);
        List<UserSber> duplicatesUser = userSetA.stream().filter(userSber -> {
            listSetB.add(userSber);
            return false;
        }).collect(Collectors.toCollection(ArrayList::new));
        return duplicatesUser;
    }

    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> userList = new ArrayList<>(collA);
        Set<UserSber> userSetB = new HashSet<>(collB);
        userList.retainAll(userSetB);
        return userList;
    }

    public static List<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicateList = new ArrayList<>();
        Set<UserSber> userSetA = new HashSet<>(collA);
        Set<UserSber> userSetB = new HashSet<>(collB);
        for (UserSber userSber : userSetB) {
            if (userSetA.contains(userSber)) {
                duplicateList.add(userSber);
            }
        }
        return duplicateList;
    }
}
