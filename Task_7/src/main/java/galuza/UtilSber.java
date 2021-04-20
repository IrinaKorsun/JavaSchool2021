package galuza;

import java.util.*;

public class UtilSber {

    public static List<UserSber> findDuplicatesByRetainAllMethod(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber>[] userSets = castCollectionsToHashSetArray(collA, collB);
        userSets[0].retainAll(userSets[1]);
        return new ArrayList<>(userSets[0]);
    }

    public static List<UserSber> findDuplicatesByContainsMethod(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber>[] userSets = castCollectionsToHashSetArray(collA, collB);
        List<UserSber> userList = new ArrayList<>();

        for (UserSber user : userSets[0]) {
            if (userSets[1].contains(user))
                userList.add(user);
        }
        return userList;
    }

    public static List<UserSber> findDuplicatesByAddMethod(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber>[] userSets = castCollectionsToHashSetArray(collA, collB);
        List<UserSber> userList = new ArrayList<>();

        for(UserSber userSber : userSets[0]) {
            if (!userSets[1].add(userSber))
                userList.add(userSber);
        }
        return userList;
    }

    public static List<UserSber> findDuplicatesByRemoveMethod(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber>[] userSets = castCollectionsToHashSetArray(collA, collB);
        List<UserSber> userList = new ArrayList<>();

        for(UserSber userSber : userSets[0]) {
            if (userSets[1].remove(userSber))
                userList.add(userSber);
        }
        return userList;
    }

    private static Set<UserSber>[] castCollectionsToHashSetArray(Collection<UserSber> collA, Collection<UserSber> collB) {
        return new Set[] {new HashSet<>(collA), new HashSet<>(collB)};
    }
}













