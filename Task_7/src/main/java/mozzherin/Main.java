package mozzherin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_PEOPLE = 100000;

    public static List< UserSber > findDuplicates1(Collection<UserSber > collA, Collection<UserSber > collB){
        HashSet<UserSber> hashSetA = new HashSet<>(collA);
        HashSet<UserSber> hashSetB = new HashSet<>(collB);

        ArrayList<UserSber> listOfDuplicates = new ArrayList<>();

        for (UserSber user: hashSetA) {
            if (hashSetB.contains(user)) {
                listOfDuplicates.add(user);
            }
        }
        return listOfDuplicates;
    }

    public static List< UserSber > findDuplicates2(Collection<UserSber > collA, Collection<UserSber > collB){
        ArrayList<UserSber> arrayListA = new ArrayList<>(collA);
        ArrayList<UserSber> arrayListB = new ArrayList<>(collB);

        ArrayList<UserSber> listOfDuplicates = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PEOPLE; i++) {
            for (int j = 0; j < NUMBER_OF_PEOPLE; j++) {
                if (arrayListA.get(i).equals(arrayListB.get(j))) {
                    listOfDuplicates.add(arrayListA.get(i));
                }
            }
        }
        return listOfDuplicates;
    }
}
