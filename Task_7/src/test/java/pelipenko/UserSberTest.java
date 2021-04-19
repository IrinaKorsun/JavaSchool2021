package pelipenko;

import manafov.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserSberTest {
    List<UserSber> usersA, usersB;
    private static long startTime;
    private static long endTime;

    @BeforeEach
    void setUp() {
        usersA = new ArrayList<>();
        usersB = new ArrayList<>();
    }

    @Nested
    class FewElementsAdded {
        List<UserSber> expected;

        @BeforeEach
        void setUp() {
            usersA.add(new UserSber("Alex", "user@uaser.ru"));
            usersA.add(new UserSber("Dennis", "user1@user.ru"));
            usersA.add(new UserSber("John", "raterouz@yandex.ru"));
            usersA.add(new UserSber("UserName", "email@email.ru"));

            usersB.add(new UserSber("Alex", "user@uaser.ru"));
            usersB.add(new UserSber("UserName", "email@email.ru"));
            usersB.add(new UserSber("Name", "email123@email.ru"));
            usersB.add(new UserSber("Nick", "nick@email.ru"));

            expected = Arrays.asList(new UserSber("Alex", "user@uaser.ru"),
                    new UserSber("UserName", "email@email.ru"));
            startTime = System.currentTimeMillis();
        }

        @Test
        void findDuplicatesFast() {
            List<UserSber> actual = UtilClass.findDuplicatesFast(usersA, usersB);
            assertTrue(expected.size() == actual.size()
                    && expected.containsAll(actual)
                    && actual.containsAll(expected));
            endTime = System.currentTimeMillis();
        }

        @Test
        void findDuplicatesSlow() {
            List<UserSber> actual = UtilClass.findDuplicatesSlow(usersA, usersB);
            assertTrue(expected.size() == actual.size()
                    && expected.containsAll(actual)
                    && actual.containsAll(expected));
            endTime = System.currentTimeMillis();
        }

        @Test
        void findDuplicatesGood() {
            List<UserSber> actual = UtilClass.findDuplicatesGood(usersA, usersB);
            assertTrue(expected.size() == actual.size()
                    && expected.containsAll(actual)
                    && actual.containsAll(expected));
            endTime = System.currentTimeMillis();
        }

        @AfterEach
        void setEnd() {
            if (endTime - startTime > 200) {
                System.out.println("Не успел :(");
            } else {
                System.out.println("Выполнилось за " + (endTime - startTime));
            }
        }
    }

    @Nested
    class ManyElementsAdded{
        @BeforeEach
        void setUp() {
            for (int i = 0; i < 100_000; i++) {
                usersA.add(new UserSber(createRandomWord(), createRandomWord()));
                usersB.add(new UserSber(createRandomWord(), createRandomWord()));
            }
            startTime = System.currentTimeMillis();
        }

        @Test
        void findDuplicatesFastWithTimeout() {
            try {
                assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
                    UtilClass.findDuplicatesFast(usersA, usersB);
                });
                endTime = System.currentTimeMillis();
            } catch (AssertionFailedError e){
                endTime = System.currentTimeMillis();
            }
            System.out.println("Fast выполнилось за: " + (endTime - startTime));

        }

        @Test
        void findDuplicatesGoodtWithTimeout() {
            try {
                assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
                    UtilClass.findDuplicatesGood(usersA, usersB);
                });
                endTime = System.currentTimeMillis();
            } catch (AssertionFailedError e){
                endTime = System.currentTimeMillis();
            }
            System.out.println("Good выполнилось за: " + (endTime - startTime));

        }

        @Test
        void findDuplicatesSlowtWithTimeout() {
            try {
                assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
                    UtilClass.findDuplicatesSlow(usersA, usersB);
                });
                endTime = System.currentTimeMillis();
            } catch (AssertionFailedError e) {
                endTime = System.currentTimeMillis();
            }
            System.out.println("Slow выполнилось за: " + (endTime - startTime));

        }


        public String createRandomWord() {
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                int v = 1 + (int) (Math.random() * 26);
                char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
                name.append(c);
            }
            return name.toString();
        }
    }

}
