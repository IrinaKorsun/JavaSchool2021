package lesnoy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

import static lesnoy.UtilSber.*;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class UtilSberTest {
    private static final int ONE_MILLION = 1_000_000;
    private static final int COUNT_ITERATION = 1_000_00;
    private static final int RUNNING_TIME = 300;
    private static Collection<lesnoy.UserSber> collA;
    private static Collection<lesnoy.UserSber> collB;

    @BeforeAll
    static void setUp() {
        UtilSberTest.collA = new ArrayList<>();
        UtilSberTest.collB = new ArrayList<>();

        for (int i = 0; i < COUNT_ITERATION; i++) {
            collA.add(new lesnoy.UserSber("user" + (int) (Math.random() * 1000 + 1), "email" + (int) (Math.random() * 1000 + 1)));
            collB.add(new lesnoy.UserSber("user" + (int) (Math.random() * 1000 + 1), "email" + (int) (Math.random() * 1000 + 1)));
        }
    }

    @Test
    void findDuplicatesTest() {
        long startTime = System.nanoTime();
        long runningTime;
        try {
            assertTimeoutPreemptively(Duration.ofMillis(RUNNING_TIME), () -> {
                findDuplicates(collA, collB);
            });
        } catch (AssertionFailedError e) {
            runningTime = (System.nanoTime() - startTime) / ONE_MILLION;
            System.out.println("Ex: " + e.toString());
            System.out.println(runningTime + "ms");
        }
    }

    @Test
    void findDuplicates2Test() {
        long startTime = System.nanoTime();
        long runningTime;
        try {
            assertTimeoutPreemptively(Duration.ofMillis(RUNNING_TIME), () -> {
                findDuplicates2(collA, collB);
            });
        } catch (AssertionFailedError e) {
            runningTime = (System.nanoTime() - startTime) / ONE_MILLION;
            System.out.println("Ex: " + e.toString());
            System.out.println(runningTime + "ms");
        }
    }

    @Test
    void findDuplicates3Test() {
        long startTime = System.nanoTime();
        long runningTime;
        try {
            assertTimeoutPreemptively(Duration.ofMillis(RUNNING_TIME), () -> {
                findDuplicates3(collA, collB);
            });
        } catch (AssertionFailedError e) {
            runningTime = (System.nanoTime() - startTime) / ONE_MILLION;
            System.out.println("Ex: " + e.toString());
            System.out.println(runningTime + "ms");
        }
    }
}