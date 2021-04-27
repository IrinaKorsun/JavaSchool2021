package podolyak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserSberTest {

    private final int MAX_SIZE = 100_000;
    private Collection<UserSber> collA;
    private Collection<UserSber> collB;
    private Collection<UserSber> collA1;
    private Collection<UserSber> collB1;

    @BeforeEach
    void randomMakerUserSber() {
        collA = new ArrayList<>();
        collB = new ArrayList<>();
        for (int i = 1; i <= MAX_SIZE; i++) {
            collA.add(new UserSber("name" + (int) (Math.random() * 1000), "email" + (int) (Math.random() * 1000) + "@.ru"));
            collB.add(new UserSber("name" + (int) (Math.random() * 1000), "email" + (int) (Math.random() * 1000) + "@.ru"));
        }
    }

    @BeforeEach
    void makerUserSber() {
        collA1 = new ArrayList<>();
        collB1 = new ArrayList<>();

        collA1.add(new UserSber("name", "email@.ru"));
        collA1.add(new UserSber("name1", "email1@.ru"));
        collA1.add(new UserSber("name2", "email2@.ru"));
        collA1.add(new UserSber("name3", "email3@.ru"));
        collA1.add(new UserSber("name4", "email4@.ru"));

        collB1.add(new UserSber("name", "email@.ru"));
        collB1.add(new UserSber("name1", "email1@.ru"));
        collB1.add(new UserSber("name2", "email2@.ru"));
        collB1.add(new UserSber("name3", "email3@.ru"));
        collB1.add(new UserSber("name6", "email6@.ru"));
    }

    @Test
    void findDuplicates1() {
        List<UserSber> users = UserSber.findDuplicates1(collA1, collB1);
        assertEquals(4, users.size());
    }

    @Test
    void findDuplicates2() {
        List<UserSber> users = UserSber.findDuplicates2(collA1, collB1);
        assertEquals(4, users.size());
    }

    @Test
    void findDuplicates2Timeout() {
        long start = System.currentTimeMillis();
        List<UserSber> users = UserSber.findDuplicates2(collA, collB);
        long stop = System.currentTimeMillis();
        assertTrue((stop - start) < 200);
    }

    @Test
    void returnListSize() {
        List<UserSber> users = UserSber.findDuplicates2(collA1, collB1);
        List<UserSber> users1 = UserSber.findDuplicates1(collA1, collB1);
        assertTrue(users.size() == users1.size());
    }
}