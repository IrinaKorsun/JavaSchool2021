package zhmaylo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

class UserSberTest {

    private static Collection<UserSber> collA;
    private static Collection<UserSber> collB;
    private static final int TEST_SIZE = 99_999;

    @BeforeAll
    static void beforeAll() {
        collA = new ArrayList<>();
        collB = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            collA.add(new UserSber("username" + Math.random(), "email" + Math.random()));
        }
        collA.add(new UserSber("Wally", "find@wally.com"));
        for (int i = 0; i < TEST_SIZE; i++) {
            collB.add(new UserSber("username" + Math.random(), "email" + Math.random()));
        }
        collB.add(new UserSber("Wally", "find@wally.com"));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesRetainTimeTest() {
        long startTimer = System.currentTimeMillis();
        List<UserSber> duplicates = UserSberUtils.findDuplicates(collA, collB);
        long duration = System.currentTimeMillis() - startTimer;
        System.out.println("Duration with \"retainAll\": " + duration + " m.s.");
        System.out.println("Found duplicates: " + duplicates.size() + ".");
        for (UserSber d : duplicates) {
            System.out.println(d.getUsername());

        }
    }

    @Disabled("Disabled because is too slow on my PC ")
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesForTimeTest() {
        long startTimer = System.currentTimeMillis();
        List<UserSber> duplicates = UserSberUtils.findDuplicatesFor(collA, collB);
        long duration = System.currentTimeMillis() - startTimer;
        System.out.println("Duration with \"for\" : " + duration + " m.s.");
        System.out.println("Found duplicates: " + duplicates.size() + ".");
        for (UserSber d : duplicates) {
            System.out.println(d.getUsername());

        }
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesStreamTimeTest() {
        long startTimer = System.currentTimeMillis();
        List<UserSber> duplicates = UserSberUtils.findDuplicatesStream(collA, collB);
        long duration = System.currentTimeMillis() - startTimer;
        System.out.println("Duration with \"stream\" : " + duration + " m.s.");
        System.out.println("Found duplicates: " + duplicates.size() + ".");
        for (UserSber d : duplicates) {
            System.out.println(d.getUsername());

        }
    }
}
