package khoroshev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {
    private final List<UserSber> collA = new ArrayList<>();
    private final List<UserSber> collB = new ArrayList<>();
    private final List<UserSber> repetitive = new ArrayList<>();

    @BeforeEach
    void setUp() {
        repetitive.add(new UserSber("Виктор", "victor1@khoroshev.net"));
        repetitive.add(new UserSber("Виктор2", "victor2@khoroshev.net"));
        repetitive.add(new UserSber("Виктор3", "victor3@khoroshev.net"));
        repetitive.add(new UserSber("Виктор4", "victor4@khoroshev.net"));
        repetitive.add(new UserSber("Виктор5", "victor5@khoroshev.net"));
        repetitive.add(new UserSber("Виктор6", "victor6@khoroshev.net"));
        fillList(collA);
        fillList(collB);
    }

    @Test
    void findDuplicatesTimeTest() {
        long startMilliseconds = new Date().getTime();
        Utils.findDuplicates(collA, collB);
        long endMilliseconds = new Date().getTime();
        assertTrue(endMilliseconds - startMilliseconds < 200);
    }

    @Test
    void findDuplicatesRepeatTest() {
        List<UserSber> list = Utils.findDuplicates(collA, collB);
        assertTrue(list.containsAll(repetitive));
        assertEquals(repetitive.size(), list.size());
    }

    @Test
    void findDuplicatesVeryLongTimeTest() {
        long startMilliseconds = new Date().getTime();
        Utils.findDuplicatesVeryLong(collA, collB);
        long endMilliseconds = new Date().getTime();
        assertFalse(endMilliseconds - startMilliseconds < 200);
    }

    @Test
    void findDuplicatesVeryLongRepeatTest() {
        List<UserSber> list = Utils.findDuplicatesVeryLong(collA, collB);
        assertTrue(list.containsAll(repetitive));
        assertEquals(repetitive.size(), list.size());
    }

    @Test
    void findDuplicatesWithHashSetTimeTest() {
        long startMilliseconds = new Date().getTime();
        Utils.findDuplicatesWithHashSet(collA, collB);
        long endMilliseconds = new Date().getTime();
        assertTrue(endMilliseconds - startMilliseconds < 200);
    }

    @Test
    void findDuplicatesWithHashSetRepeatTest() {
        List<UserSber> list = Utils.findDuplicatesWithHashSet(collA, collB);
        assertTrue(list.containsAll(repetitive));
        assertEquals(repetitive.size(), list.size());
    }

    private void fillList(Collection<UserSber> coll) {
        for (int i = 0; i < 99994; i++) {
            coll.add(new UserSber(randomString(), randomString()));
        }
        coll.addAll(repetitive);
    }

    private String randomString() {
        Random random = new Random();
        char[] sAlphabet = "абвгдежзиклмнопрстуфх".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 60; i++) {
            stringBuilder.append(sAlphabet[random.nextInt(sAlphabet.length)]);
        }
        return stringBuilder.toString();
    }
}
