package galuza;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtilSber2 {
    private static final int CAPACITY = 100_000;
    private static List<UserSber> usersA = new ArrayList<>(CAPACITY);
    private static List<UserSber> usersB = new ArrayList<>(CAPACITY);
    private final static double MIN_TIME = 0.2;

    @Test
    public void testFindDuplicatesByRetainAll() {
        long startTime = System.nanoTime();
        List<UserSber> users = UtilSber.findDuplicatesByRetainAllMethod(usersA, usersB);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        System.out.println("findDuplicatesByRetainAll time: " + time + " s, size: " + users.size());
        assertTrue(MIN_TIME > time);
    }

    @Test
    public void testFindDuplicatesByContains() {
        long startTime = System.nanoTime();
        List<UserSber> users = UtilSber.findDuplicatesByContainsMethod(usersA, usersB);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        System.out.println("FindDuplicatesByContains time: " + time + " s, size: " + users.size());
        assertTrue(MIN_TIME > time);
    }

    @Test
    public void testFindDuplicatesByAddMethod() {
        long startTime = System.nanoTime();
        List<UserSber> users = UtilSber.findDuplicatesByAddMethod(usersA, usersB);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        System.out.println("FindDuplicatesByAddMethod time: " + time + " s, size: " + users.size());
        assertTrue(MIN_TIME > time);
    }

    @Test
    public void testFindDuplicatesByRemoveMethod() {
        long startTime = System.nanoTime();
        List<UserSber> users = UtilSber.findDuplicatesByRemoveMethod(usersA, usersB);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        System.out.println("FindDuplicatesByRemoveMethod time: " + time + " s, size: " + users.size());
        assertTrue(MIN_TIME > time);
    }

    @BeforeEach
    void fillUsers() {
        Random random = new Random();
        for (int i = 0; i < CAPACITY; i++) {
            usersA.add(new UserSber("name" + random.nextInt(CAPACITY), "userAddress@mail.ru"));
            usersB.add(new UserSber("name" + random.nextInt(CAPACITY), "userAddress@mail.ru"));
        }
    }

    @AfterEach
    void clearUsers() {
        usersA.clear();
        usersB.clear();
    }
}
