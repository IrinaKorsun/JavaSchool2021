package ryzhenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class UserSberTest {

    private static Collection<UserSber> collA;
    private static Collection<UserSber> collB;
    static private long startTime;
    static private long endTime;

    @BeforeEach
    void setUp() {
        collA = new ArrayList<>();
        collB = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            collA.add(new UserSber("name" + (int) (Math.random() * 100_000), (int) (Math.random() * 100_000) + "@gmail.com"));
            collB.add(new UserSber("name" + (int) (Math.random() * 100_000), (int) (Math.random() * 100_000) + "@gmail.com"));
        }
        startTime = System.currentTimeMillis();
    }

    /**
     * Вариант с использованием ArrayList, contains
     */
    @Test
    void testFindDuplicates1() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(200),
                    () -> {
                        Utils.findDuplicates1(collA, collB);
                        endTime = System.currentTimeMillis();
                    });
            System.out.println("Execution time: " + (endTime - startTime) / 1000.0);
        } catch (AssertionFailedError e) {
            System.out.println("Test has exceeded the time limit!");
        }
    }

    /**
     * Вариант с использованием ArrayList, retainAll
     */
    @Test
    void testFindDuplicates2() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(200),
                    () -> {
                        Utils.findDuplicates2(collA, collB);
                        endTime = System.currentTimeMillis();
                    });
            System.out.println("Execution time: " + (endTime - startTime) / 1000.0);
        } catch (AssertionFailedError e) {
            System.out.println("Test has exceeded the time limit!");
        }
    }

    /**
     * Вариант с использованием HashSet, contains
     */
    @Test
    void testFindDuplicates3() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(200),
                    () -> {
                        Utils.findDuplicates3(collA, collB);
                        endTime = System.currentTimeMillis();
                    });
            System.out.println("Execution time: " + (endTime - startTime) / 1000.0);
        } catch (AssertionFailedError e) {
            System.out.println("Test has exceeded the time limit!");
        }
    }

    /**
     * Вариант с использованием HashSet, retainAll
     */
    @Test
    void testFindDuplicates4() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(200),
                    () -> {
                        Utils.findDuplicates4(collA, collB);
                        endTime = System.currentTimeMillis();
                    });
            System.out.println("Execution time: " + (endTime - startTime) / 1000.0);
        } catch (AssertionFailedError e) {
            System.out.println("Test has exceeded the time limit!");
        }
    }
}