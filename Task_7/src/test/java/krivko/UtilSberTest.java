package krivko;

import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilSberTest {
    final static public int TEST_MS = 200;
    final static public int SIZE_LIST = 100_000;
    final static public int RANDOM = 1000;

    static private Collection<UserSber> collA;
    static private Collection<UserSber> collB;
    static private List<UserSber> duplicates;

    static private long startTime;
    static private long endTime;
    static private String methodDescription;
    static private SecureRandom rnd = new SecureRandom();

    @BeforeEach
    void setUp() {
        UtilSberTest.collA = new ArrayList<>();
        UtilSberTest.collB = new ArrayList<>();
        for (int i = 0; i < SIZE_LIST; i++) {
            collA.add(new UserSber("user" + rnd.nextInt(RANDOM), "email" + rnd.nextInt(RANDOM)));
            collB.add(new UserSber("user" + rnd.nextInt(RANDOM), "email" + rnd.nextInt(RANDOM)));
        }
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    void setEnd() {
        if (endTime - startTime > TEST_MS)
            System.out.println("(время: ERROR - уменьшите SIZE_LIST) " + methodDescription);
        else
            System.out.println("(время: " + (endTime - startTime) / 1_000.0 + " \t дублей " + duplicates.size() + ") " + methodDescription);
    }

    @Test
    void findDuplicates1() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(TEST_MS), () -> {
                duplicates = UtilSber.findDuplicates1(collA, collB);
                endTime = System.currentTimeMillis();
            });
        } catch (AssertionFailedError e) {
            endTime = System.currentTimeMillis();
        }
        methodDescription = "1. Поиск дубликатов используя: HashSet, retainAll";
    }

    @Test
    void findDuplicates2() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(TEST_MS), () -> {
                duplicates = UtilSber.findDuplicates2(collA, collB);
                endTime = System.currentTimeMillis();
            });
        } catch (AssertionFailedError e) {
            endTime = System.currentTimeMillis();
        }
        methodDescription = "2. Поиск дубликатов используя: HashSet, for, contains";
    }

    @Test
    void findDuplicates3() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(TEST_MS), () -> {
                duplicates = UtilSber.findDuplicates3(collA, collB);
                endTime = System.currentTimeMillis();
            });
        } catch (AssertionFailedError e) {
            endTime = System.currentTimeMillis();
        }
        methodDescription = "3. Поиск дубликатов используя: HashSet, stream.filter, contains";
    }

    @Test
    void findDuplicates4() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(TEST_MS), () -> {
                duplicates = UtilSber.findDuplicates4(collA, collB);
                endTime = System.currentTimeMillis();
            });
        } catch (AssertionFailedError e) {
            endTime = System.currentTimeMillis();
        }
        methodDescription = "4. Поиск дубликатов используя: Collection, stream.filter, contains";
    }

    @Test
    void findDuplicates5() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(TEST_MS), () -> {
                duplicates = UtilSber.findDuplicates5(collA, collB);
                endTime = System.currentTimeMillis();
            });
        } catch (AssertionFailedError e) {
            endTime = System.currentTimeMillis();
        }
        methodDescription = "5. Поиск дубликатов используя: ArrayList, retainAll";
    }

    @Test
    void findDuplicates6() {
        try {
            assertTimeoutPreemptively(Duration.ofMillis(TEST_MS), () -> {
                duplicates = UtilSber.findDuplicates6(collA, collB);
                endTime = System.currentTimeMillis();
            });
        } catch (AssertionFailedError e) {
            endTime = System.currentTimeMillis();
        }
        methodDescription = "6. Поиск дубликатов используя: Collections.frequency";
    }
}