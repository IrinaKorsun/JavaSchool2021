package prikhozhaya;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static prikhozhaya.UtilUserSber.findDuplicates1;
import static prikhozhaya.UtilUserSber.findDuplicates2;

class UserSberTest {
    private static Collection<UserSber> collA = new ArrayList<UserSber>();
    private static Collection<UserSber> collB = new ArrayList<UserSber>();
    private static String[] userNameCollA = {"User1", "User2", "User3", "User4"};
    private static String[] emailCollA = {"Test1@mail.ru", "Test2@mail.ru", "Test3@mail.ru", "Test4@mail.ru"};
    private static String[] userNameCollB = {"User1", "User22", "User33", "User44"};
    private static String[] emailCollB = {"Test1@mail.ru", "Test22@mail.ru", "Test33@mail.ru", "Test44@mail.ru"};

    @BeforeAll
    static void beforeAll() {
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            collA.add(new UserSber(userNameCollA[random.nextInt(userNameCollA.length)], emailCollA[random.nextInt(emailCollA.length)]));
            collB.add(new UserSber(userNameCollB[random.nextInt(userNameCollB.length)], emailCollB[random.nextInt(emailCollB.length)]));
        }
    }

    @Test
    void findDuplicates1Test() {
        long startTime = System.currentTimeMillis();
        List testList = findDuplicates1(collA, collB);
        long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 120_000);
        System.out.println("Number of takes: " + testList.size());

    }

    @Test
    void findDuplicates2Test() {
        long startTime = System.currentTimeMillis();
        List testList = findDuplicates2(collA, collB);
        long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 200);
        System.out.println("Number of takes: " + testList.size());
    }
}