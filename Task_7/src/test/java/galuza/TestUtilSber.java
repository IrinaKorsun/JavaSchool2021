package galuza;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TestUtilSber {
    private static List<UserSber> usersA = new ArrayList<>();
    private static List<UserSber> usersB = new ArrayList<>();
    private static List<UserSber> expectedUsers = new ArrayList<>();
    private final static double MIN_TIME = 0.2;

    @Test
    void testFindDuplicatesByRetainAll() {
        List<UserSber> actualUsers = UtilSber.findDuplicatesByRetainAllMethod(usersA, usersB);
        long startTime = System.nanoTime();
        sortUsers(actualUsers);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        assertAll(
                () -> assertEquals(expectedUsers, actualUsers),
                () -> assertTrue(time < MIN_TIME)
        );
    }

    @Test
    void testFindDuplicatesByContains() {
        List<UserSber> actualUsers = UtilSber.findDuplicatesByContainsMethod(usersA, usersB);
        long startTime = System.nanoTime();
        sortUsers(actualUsers);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        assertAll(
                () -> assertEquals(expectedUsers, actualUsers),
                () -> assertTrue(time < MIN_TIME)
        );
    }

    @Test
    void testFindDuplicatesByAddMethod() {
        List<UserSber> actualUsers = UtilSber.findDuplicatesByAddMethod(usersA, usersB);
        long startTime = System.nanoTime();
        sortUsers(actualUsers);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        assertAll(
                () -> assertEquals(expectedUsers, actualUsers),
                () -> assertTrue(time < MIN_TIME)
        );
    }

    @Test
    void testFindDuplicatesByRemoveMethod() {
        List<UserSber> actualUsers = UtilSber.findDuplicatesByRemoveMethod(usersA, usersB);
        long startTime = System.nanoTime();
        sortUsers(actualUsers);
        long finishTime = System.nanoTime();
        double time = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime) / 1000.0;
        assertAll(
                () -> assertEquals(expectedUsers, actualUsers),
                () -> assertTrue(time < MIN_TIME)
        );
    }

    @BeforeEach
    void fillUsers() {
        for (int i = 0; i < 100; i++) {
            if (i < 50)
                usersA.add(new UserSber("name" + i, "userAddress@mail.ru"));
            if (i > 45)
                usersB.add(new UserSber("name" + i, "userAddress@mail.ru"));
            if (i >= 46 && i <= 49)
                expectedUsers.add(new UserSber("name" + i, "userAddress@mail.ru"));
        }
        sortUsers(expectedUsers);
    }

    void sortUsers(List<UserSber> userList) {
        userList.sort(Comparator.comparingInt(o -> o.getUserName().hashCode()));
    }

    @AfterEach
    void clearUsers() {
        usersA.clear();
        usersB.clear();
        expectedUsers.clear();
    }
}
