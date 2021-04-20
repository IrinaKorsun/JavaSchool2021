package mozzherin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final int NUMBER_OF_PEOPLE = 100000;

    Collection<mozzherin.UserSber> arrayListA;
    Collection<mozzherin.UserSber> arrayListB;

    @BeforeEach
    void setUp() {
        arrayListA = new ArrayList<>();
        arrayListB = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PEOPLE; i++) {
            arrayListA.add(new UserSber("UserName" + getRandom(), getRandom() + "@mail"));
            arrayListB.add(new UserSber("UserName" + getRandom(), getRandom() + "@mail"));
        }
    }

    private static int getRandom() {
        return (int) (Math.random() * 10000);
    }

    @Test
    void findDuplicates1() {
        long startTime = System.currentTimeMillis();
        List<UserSber> result = Main.findDuplicates1(arrayListA, arrayListB);
        long stopTime = System.currentTimeMillis();
        System.out.println("findDuplicates1");
        System.out.println("Number of duplicates: " + result.size());
        System.out.println("Time: " + (stopTime - startTime) / 1000.0);
        assertTrue(((stopTime - startTime) / 1000.0) < 0.2);
    }

    @Test
    void findDuplicates2() {
        long startTime = System.currentTimeMillis();
        List<UserSber> result = Main.findDuplicates2(arrayListA, arrayListB);
        long stopTime = System.currentTimeMillis();
        System.out.println("findDuplicates1");
        System.out.println("Number of duplicates: " + result.size());
        System.out.println("Time: " + (stopTime - startTime) / 1000.0);
        assertFalse(((stopTime - startTime) / 1000.0) < 0.2);
    }

    @Test
    void findDuplicatesTestAssert() {
        arrayListA.clear();
        arrayListB.clear();

        arrayListA.add(new UserSber("UserName1", 2 + "@mail"));
        arrayListB.add(new UserSber("UserName1", 2 + "@mail"));
        List<UserSber> result = Main.findDuplicates1(arrayListA, arrayListB);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), new UserSber("UserName1", 2 + "@mail"));

    }
}