package manafov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UserSberTest {
    List<UserSber> users1, users2;

    @BeforeEach
    void setUp() {
        users1 = new ArrayList<>();
        users2 = new ArrayList<>();
    }

    @Nested
    class WithFewElementsAdded {
        List<UserSber> expected;

        @BeforeEach
        void setUp() {
            users1.add(new UserSber("alpha", "alpha@mail.ru"));
            users1.add(new UserSber("bravo", "bravo@mail.ru"));
            users1.add(new UserSber("charlie", "charlie@mail.ru"));
            users1.add(new UserSber("delta", "delta@mail.ru"));

            users2.add(new UserSber("alpha", "alpha@mail.ru"));
            users2.add(new UserSber("bravo", "bravo@mail.ru"));
            users2.add(new UserSber("echo", "echo@mail.ru"));
            users2.add(new UserSber("foxtrot", "foxtrot@mail.ru"));

            expected = Arrays.asList(new UserSber("alpha", "alpha@mail.ru"),
                    new UserSber("bravo", "bravo@mail.ru"));
        }

        @Test
        void findDuplicates() {
            List<UserSber> actual = Utils.findDuplicates(users1, users2);
            assertTrue(expected.size() == actual.size()
                    && expected.containsAll(actual)
                    && actual.containsAll(expected));
        }

        @Test
        void findDuplicatesNotBad() {
            List<UserSber> actual = Utils.findDuplicatesNotBad(users1, users2);
            assertTrue(expected.size() == actual.size()
                    && expected.containsAll(actual)
                    && actual.containsAll(expected));
        }

        @Test
        void findDuplicatesBad() {
            List<UserSber> actual = Utils.findDuplicatesBad(users1, users2);
            assertTrue(expected.size() == actual.size()
                    && expected.containsAll(actual)
                    && actual.containsAll(expected));
        }
    }

    @Nested
    class WithManyElementsAdded {
        @BeforeEach
        void setUp() {
            for (int i = 0; i < 100_000; i++) {
                users1.add(new UserSber(randomAlphabetic(), randomAlphabetic()));
                users2.add(new UserSber(randomAlphabetic(), randomAlphabetic()));
            }
        }

        @Test
        void findDuplicatesWithTimeout() {
            assertTimeout(Duration.ofMillis(200), () -> {
                Utils.findDuplicates(users1, users2);
            });
        }

        @Test
        void findDuplicatesNotBadWithTimeout() {
            assertTimeout(Duration.ofMillis(300), () -> {
                Utils.findDuplicatesNotBad(users1, users2);
            });
        }

        @Test
        void findDuplicatesBadWithTimeout() {
            assertTimeout(Duration.ofMinutes(5), () -> {
                Utils.findDuplicatesBad(users1, users2);
            });
        }
    }

    String randomAlphabetic() {
        return new Random().ints('a', 'z')
                .limit(20)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
