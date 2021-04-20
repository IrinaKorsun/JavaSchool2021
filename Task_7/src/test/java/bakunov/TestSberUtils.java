package bakunov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSberUtils {
    private static Collection<UserSber> collA;
    private static Collection<UserSber> collB;

    @BeforeEach
    void setUp() {
        collA = new ArrayList<>();
        collB = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            collA.add(new UserSber("name" + (int) (Math.random() * 1000), "email" + (int) (Math.random() * 1000)));
            collB.add(new UserSber("name" + (int) (Math.random() * 1000), "email" + (int) (Math.random() * 1000)));
        }
    }

    @Test
    void testFindDuplicates() {
        DecimalFormat df = new DecimalFormat("#.##");
        long start = System.currentTimeMillis();
        List<UserSber> result = SberUtils.findDuplicates(collA, collB);
        long finish = System.currentTimeMillis();
        double totalTime = (double) (finish - start) / 1000;
        System.out.println("Time on `findDuplicates` = " + df.format(totalTime) + "c.");
        assertTrue(totalTime < 0.3);
    }

    @Test
    void testFindDuplicates2() {
        DecimalFormat df = new DecimalFormat("#.##");
        long start = System.currentTimeMillis();
        List<UserSber> result = SberUtils.findDuplicates2(collA, collB);
        long finish = System.currentTimeMillis();
        double totalTime = (double) (finish - start) / 1000;
        System.out.println("Time on `findDuplicates2` = " + df.format(totalTime) + "c.");
        assertTrue(totalTime < 0.3);
    }

    @Test
    void testFindDuplicates3() {
        DecimalFormat df = new DecimalFormat("#.##");
        long start = System.currentTimeMillis();
        List<UserSber> result = SberUtils.findDuplicates3(collA, collB);
        long finish = System.currentTimeMillis();
        double totalTime = (double) (finish - start) / 1000;
        System.out.println("Time on `findDuplicates3` = " + df.format(totalTime) + "c.");
        assertTrue(totalTime < 0.3);
    }


}
