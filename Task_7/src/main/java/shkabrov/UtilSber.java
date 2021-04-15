package shkabrov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Этот класс состоит из утилитных методов для работы со списками объектов UserSber
 */
public final class UtilSber {
    private UtilSber() {
    }

    /**
     * Производит поиск элементов, которые есть в обеих коллекциях. Для поиска дубликатов используется contains.
     * Исходные коллекции преобразуются к ArrayList(в исходных коллекциях учитываются повторяющиеся элементы).
     * @param collA первая коллекция
     * @param collB вторая коллекция
     * @return коллекцию повторяющихся элементов
     */
    public static List<UserSber> findDuplicatesArrayContains(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> collectionOne = new ArrayList<>(collA);
        List<UserSber> collectionTwo = new ArrayList<>(collB);
        List<UserSber> repeatingElements = new ArrayList<>();
        for (UserSber currentElement: collectionOne) {
            if(collectionTwo.contains(currentElement)) {
                repeatingElements.add(currentElement);
            }
        }
        return repeatingElements;
    }

    /**
     * Производит поиск элементов, которые есть в обеих коллекциях. Для поиска дубликатов используется contains.
     * Исходные коллекции преобразуются к HashSet(в исходных коллекциях не учитываются повторяющиеся элементы).
     * @param collA первая коллекция
     * @param collB вторая коллекция
     * @return коллекцию повторяющихся элементов
     */
    public static List<UserSber> findDuplicatesHashContains(Collection<UserSber> collA, Collection<UserSber> collB) {
        HashSet<UserSber> collectionOne = new HashSet<>(collA);
        HashSet<UserSber> collectionTwo = new HashSet<>(collB);
        List<UserSber> repeatingElements = new ArrayList<>();
        for (UserSber currentElement: collectionOne) {
            if(collectionTwo.contains(currentElement)) {
                repeatingElements.add(currentElement);
            }
        }
        return repeatingElements;
    }

    /**
     * Производит поиск элементов, которые есть в обеих коллекциях. Для поиска дубликатов используется retainAll.
     * Исходные коллекции преобразуются к ArrayList(в исходных коллекциях учитываются повторяющиеся элементы).
     * @param collA первая коллекция
     * @param collB вторая коллекция
     * @return коллекцию повторяющихся элементов
     */
    public static List<UserSber> findDuplicatesArrayRetain(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> collectionOne = new ArrayList<>(collA);
        List<UserSber> collectionTwo = new ArrayList<>(collB);
        collectionOne.retainAll(collectionTwo);
        return new ArrayList<>(collectionOne);
    }

    /**
     * Производит поиск элементов, которые есть в обеих коллекциях. Для поиска дубликатов используется retainAll.
     * Исходные коллекции преобразуются к HashSet(в исходных коллекциях не учитываются повторяющиеся элементы).
     * @param collA первая коллекция
     * @param collB вторая коллекция
     * @return коллекцию повторяющихся элементов
     */
    public static List<UserSber> findDuplicatesHashRetain(Collection<UserSber> collA, Collection<UserSber> collB) {
        HashSet<UserSber> collectionOne = new HashSet<>(collA);
        HashSet<UserSber> collectionTwo = new HashSet<>(collB);
        collectionOne.retainAll(collectionTwo);
        return new ArrayList<>(collectionOne);
    }
}
