package emelyanov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserSberTest {
    private static Collection collA;
    private static Collection collB;
    private static List<UserSber> duplicate;
    private static long stop;
    Utils utils = new Utils();

    @BeforeEach
    void setUp() {
        collA = new ArrayList();
        collB = new ArrayList();
        collA.add(new UserSber("name Ivan", "asde@"));
        collB.add(new UserSber("name Ivan", "asde@"));
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            collA.add(new UserSber("name" + random.nextInt(), "asde@" + random.nextInt()));
            collB.add(new UserSber("name" + random.nextInt(), "asde@" + random.nextInt()));
        }
    }

    @Test
    void findDublicates1() {
        try {
            assertTimeout(Duration.ofMillis(200), () -> {
                duplicate = utils.findDuplicates1(collA, collB);
                stop = System.currentTimeMillis();
            });
        } catch (AssertionFailedError error) {
            stop = System.currentTimeMillis();
        }
        assertTrue(duplicate.contains(new UserSber("name Ivan", "asde@")));
        System.out.println("Количество дубликатов = " + duplicate.size());
    }

    @Test
    void findDublicates2() {
        try {
            assertTimeout(Duration.ofMillis(200), () -> {
                duplicate = utils.findDuplicates2(collA, collB);
                stop = System.currentTimeMillis();
            });
        } catch (AssertionFailedError error) {
            stop = System.currentTimeMillis();
        }
        assertTrue(duplicate.contains(new UserSber("name Ivan", "asde@")));
        System.out.println("Количество дубликатов = " + duplicate.size());
    }

    @Test
    void findDublicates3() {
        long start = System.currentTimeMillis();
        duplicate = utils.findDuplicates3(collA, collB);
        long stop = System.currentTimeMillis();
        assertTrue((stop - start) < 260);
        assertTrue(duplicate.contains(new UserSber("name Ivan", "asde@")));
        System.out.println("Количество дубликатов = " + duplicate.size());
    }
}
