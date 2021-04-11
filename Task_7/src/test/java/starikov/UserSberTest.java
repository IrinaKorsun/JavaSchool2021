package starikov;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

class UserSberTest {
    static private Collection<UserSber> collA;
    static private Collection<UserSber> collB;

    @BeforeAll
    static void setUp() {
        UserSberTest.collA = new ArrayList<>();
        UserSberTest.collB = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            collA.add(new UserSber("user" + getRandom(), "email" + getRandom()));
            collB.add(new UserSber("user" + getRandom(), "email" + getRandom()));
        }
    }

    private static int getRandom() {
        return (int) (Math.random() * 1000 + 1);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates1() {
        long start = System.currentTimeMillis();
        List<UserSber> result = UserSber.findDuplicates1(collA, collB);
        long stop = System.currentTimeMillis();
        System.out.println("HashSet и HashSet");
        System.out.println("Размер коллекций: " + collA.size() + ". Количество дублей: " + result.size());
        System.out.println("Время работы: " + (stop - start) / 1_000.0);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates2() {
        long start = System.currentTimeMillis();
        List<UserSber> result = UserSber.findDuplicates2(collA, collB);
        long stop = System.currentTimeMillis();
        System.out.println("HashSet и ArrayList");
        System.out.println("Размер коллекций: " + collA.size() + ". Количество дублей: " + result.size());
        System.out.println("Время работы: " + (stop - start) / 1_000.0);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates3() {
        long start = System.currentTimeMillis();
        List<UserSber> result = UserSber.findDuplicates3(collA, collB);
        long stop = System.currentTimeMillis();
        System.out.println("ArrayList.retainAll(HashSet)");
        System.out.println("Размер коллекций: " + collA.size() + ". Количество дублей: " + result.size());
        System.out.println("Время работы: " + (stop - start) / 1_000.0);
    }
}