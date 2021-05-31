package komissarov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class UtilsTest {
    List<UserSber> collA = new ArrayList<>();
    List<UserSber> collB = new ArrayList<>();
    Set<UserSber> collASet = new HashSet<>();
    Set<UserSber> collBSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        fillArray(collASet);
        fillArray(collBSet);
        fillArray(collA);
        fillArray(collB);
    }

    @Test
    void timeoutExceededSet() {
        assertTimeout(ofMillis(200), () -> {
            long startMilliseconds = new Date().getTime();
            Utils.findDuplicates(collASet, collBSet);
            long endMilliseconds = new Date().getTime();
            System.out.println(endMilliseconds - startMilliseconds);
        });
    }

    @Test
    void timeoutNotExceededList() {
        assertTimeout(ofMillis(200000), () -> {
            Utils.findDuplicates(collA, collB);
        });
    }

    @Test
    void testFindDuplicates() {
        List<UserSber> collC = new ArrayList<>();
        List<UserSber> collD = new ArrayList<>();
        collC.add(new UserSber("1", "2"));
        UserSber user = new UserSber("2", "3");
        collD.add(new UserSber("3", "3"));
        collC.add(user);
        collD.add(user);
        List<UserSber> collRes = new ArrayList<>();
        collRes.add(user);
        List<UserSber> collExp = Utils.findDuplicates(collC, collD);
        assertEquals(collRes, collExp);
    }


    @Test
    void timeoutNotExceededDup2() {
        assertTimeout(ofMillis(200000), () -> {
            Utils.findDuplicates2(collA, collB);
        });
    }

    @Test
    void testFindDuplicates2() {
        List<UserSber> collC = new ArrayList<>();
        List<UserSber> collD = new ArrayList<>();
        collC.add(new UserSber("1", "2"));
        UserSber user = new UserSber("2", "3");
        collD.add(new UserSber("3", "3"));
        collC.add(user);
        collD.add(user);
        List<UserSber> collRes = new ArrayList<>();
        collRes.add(user);
        List<UserSber> collExp = Utils.findDuplicates2(collC, collD);
        assertEquals(collRes, collExp);
    }

    private void fillArray(Collection<UserSber> list) {
        for (int i = 0; i < 100000; i++) {
            list.add(new UserSber(String.valueOf(Math.random()), String.valueOf(Math.random())));
        }
    }

}