package shkabrov;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserSberTest {
    public static Collection<UserSber> collA;
    public static Collection<UserSber> collB;

    public static String generateRandomString(Random rnd, int length) {
        String possibleCharacters = "abcdefghijklmnopqrstuvwxyz";
        char[] generatedText = new char[length];
        for (int i = 0; i < length; i++) {
            generatedText[i] = possibleCharacters.charAt(rnd.nextInt(possibleCharacters.length()));
        }
        return new String(generatedText);
    }

    @BeforeAll
    public static void initializationOfTestData() {
        int amountOfElements = 100_000;
        collA = new ArrayList<>();
        collB = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < amountOfElements - 1; i++) {
            collA.add(new UserSber(generateRandomString(rnd, 2), generateRandomString(rnd, 1)));
            collB.add(new UserSber(generateRandomString(rnd, 2), generateRandomString(rnd, 1)));
        }
        collA.add(new UserSber("DuplicateName", "DuplicateEmail"));
        collB.add(new UserSber("DuplicateName", "DuplicateEmail"));
    }

    @Test
    public void findDuplicatesArrayContains() {
        long startOfExecution = System.currentTimeMillis();
        List<UserSber> repeatingElements = UtilSber.findDuplicatesArrayContains(collA, collB);
        long endOfExecution = System.currentTimeMillis();
        double totalExecutionTime = (endOfExecution - startOfExecution) / 1000.0;
        System.out.println("findDuplicatesArrayContains(execution time: " + totalExecutionTime + " )");
        System.out.println("Number of repeating elements: " + repeatingElements.size());
        assertTrue(repeatingElements.contains(new UserSber("DuplicateName", "DuplicateEmail")));
    }

    @Test
    public void findDuplicatesHashContains() {
        long startOfExecution = System.currentTimeMillis();
        List<UserSber> repeatingElements = UtilSber.findDuplicatesHashContains(collA, collB);
        long endOfExecution = System.currentTimeMillis();
        double totalExecutionTime = (endOfExecution - startOfExecution) / 1000.0;
        System.out.println("findDuplicatesHashContains(execution time: " + totalExecutionTime + " )");
        System.out.println("Number of repeating elements: " + repeatingElements.size());
        assertTrue(repeatingElements.contains(new UserSber("DuplicateName", "DuplicateEmail")));
    }

    @Test
    public void findDuplicatesArrayRetain() {
        long startOfExecution = System.currentTimeMillis();
        List<UserSber> repeatingElements = UtilSber.findDuplicatesArrayRetain(collA, collB);
        long endOfExecution = System.currentTimeMillis();
        double totalExecutionTime = (endOfExecution - startOfExecution) / 1000.0;
        System.out.println("findDuplicatesArrayRetain(execution time: " + totalExecutionTime + " )");
        System.out.println("Number of repeating elements: " + repeatingElements.size());
        assertTrue(repeatingElements.contains(new UserSber("DuplicateName", "DuplicateEmail")));
    }

    @Test
    public void findDuplicatesHashRetain() {
        long startOfExecution = System.currentTimeMillis();
        List<UserSber> repeatingElements = UtilSber.findDuplicatesHashRetain(collA, collB);
        long endOfExecution = System.currentTimeMillis();
        double totalExecutionTime = (endOfExecution - startOfExecution) / 1000.0;
        System.out.println("findDuplicatesHashRetain(execution time: " + totalExecutionTime + " )");
        System.out.println("Number of repeating elements: " + repeatingElements.size());
        assertTrue(repeatingElements.contains(new UserSber("DuplicateName", "DuplicateEmail")));
    }
}