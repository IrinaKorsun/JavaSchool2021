package zatsepin;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class UtilSberTest {
    private static List<UserSber> listA = new ArrayList<>();
    private static List<UserSber> listB = new ArrayList<>();
    private static String[] userNames = {"Ivan", "Fedor", "Nikolay", "Alexandr", "Dmitry", "Svetlana", "Irina", "Marina", "Anna", "Olga", "Evgeny", "Connor", "Donald"};
    private static String[] emails = {"aaa@sb.ru", "bbb@sb.ru", "ccc@sb.ru", "ddd@sb.ru", "eee@sb.ru", "fff@sb.ru", "ggg@sb.ru", "hhh@sb.ru", "iii@sb.ru", "jjj@sb.ru", "kkk@sb.ru", "lll@sb.ru", "mmm@sb.ru"};
    private static ThreadLocalRandom rand = ThreadLocalRandom.current();

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < 100_000; i++) {
            listA.add(new UserSber(userNames[rand.nextInt(userNames.length)], emails[rand.nextInt(emails.length)]));
            listB.add(new UserSber(userNames[rand.nextInt(userNames.length)], emails[rand.nextInt(emails.length)]));
        }
    }

    @AfterAll
    static void tearDown() {
        listA = null;
        listB = null;
    }

    @Test
    void findDuplicates1() {
        long startTime = System.nanoTime();
        List<UserSber> duplicates = UtilSber.findDuplicates1(listA, listB);
        long elapsedMillis = (System.nanoTime() - startTime)/ 1000_000;
        assertTrue(elapsedMillis < 200);
        System.out.println("Duration of execution findDuplicates1(): " + elapsedMillis + " ms");
        System.out.println("Duplicates: " + duplicates.size());
    }

    @Test
    void findDuplicates2() {
        long startTime = System.nanoTime();
        List<UserSber> duplicates = UtilSber.findDuplicates2(listA, listB);
        long elapsedMillis = (System.nanoTime() - startTime)/ 1000_000;
        assertTrue(elapsedMillis < 200);
        System.out.println("Duration of execution findDuplicates2(): " + elapsedMillis + " ms");
        System.out.println("Duplicates: " + duplicates.size());
    }
}