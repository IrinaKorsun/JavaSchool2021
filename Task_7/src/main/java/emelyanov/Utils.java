package emelyanov;

import java.util.*;

public class Utils {
    /**
     * Поиск дубликатов в двух коллекциях с помощью метода retainAll
     *
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return список дубликатов
     */
    public ArrayList findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        ArrayList<UserSber> arrayListA = new ArrayList<>(collA);
        ArrayList<UserSber> arrayListB = new ArrayList<>(collB);
        ArrayList<UserSber> listDuplicat = new ArrayList<>(arrayListA);
        if (listDuplicat.retainAll(arrayListB)) {
            System.out.println(listDuplicat);
        }
        return listDuplicat;
    }

    /**
     * Поиск дубликатов в двух коллекциях с помощью цикла for
     *
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return список дубликатов
     */
    public ArrayList<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        ArrayList<UserSber> arrayListA = new ArrayList<>(collA);
        ArrayList<UserSber> arrayListB = new ArrayList<>(collB);
        ArrayList<UserSber> listDuplicat = new ArrayList<>();
        for (int i = 0; i < arrayListA.size(); i++) {
            for (int j = 0; j < arrayListB.size(); j++) {
                if (arrayListA.get(i).equals(arrayListB.get(j))) {
                    listDuplicat.add(arrayListA.get(i));
                }
            }
        }
        return listDuplicat;
    }

    /**
     * Поиск дубликатов в двух коллекциях с помощью HasSet() и метода contains
     *
     * @param collA - первая коллекция
     * @param collB - вторая коллекция
     * @return список дубликатов
     */
    public ArrayList<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {
        HashSet<UserSber> hashSetA = new HashSet<>(collA);
        ArrayList<UserSber> arrayListB = new ArrayList<>(collB);
        ArrayList<UserSber> listDuplicat = new ArrayList<>();
        for (UserSber user : arrayListB) {
            if (hashSetA.contains(user)) {
                listDuplicat.add(user);
            }
        }
        return listDuplicat;
    }
}
