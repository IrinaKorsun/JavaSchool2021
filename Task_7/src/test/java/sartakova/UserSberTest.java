package sartakova;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserSberTest {
    @Test
    @Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesSetForRandomTest() {
        Collection<UserSber> collA = generateRandomCollection();
        Collection<UserSber> collB = generateRandomCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = UtilSber.findDuplicatesSetFor(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Кол-во дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesSetForWorseTest() {
        Collection<UserSber> collA = generateWorseCollection();
        Collection<UserSber> collB = generateWorseCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = UtilSber.findDuplicatesSetFor(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Кол-во дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesSetStreamRandomTest() {
        Collection<UserSber> collA = generateRandomCollection();
        Collection<UserSber> collB = generateRandomCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = UtilSber.findDuplicatesSetStream(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Кол-во дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesSetStreamWorseTest() {
        Collection<UserSber> collA = generateWorseCollection();
        Collection<UserSber> collB = generateWorseCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = UtilSber.findDuplicatesSetStream(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Кол-во дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesStreamRandomTest() {
        Collection<UserSber> collA = generateRandomCollection();
        Collection<UserSber> collB = generateRandomCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = UtilSber.findDuplicatesStream(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Кол-во дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test()
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void findDuplicatesStreamWorseTest() {
        Collection<UserSber> collA = generateWorseCollection();
        Collection<UserSber> collB = generateWorseCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = UtilSber.findDuplicatesStream(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Кол-во дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    private Collection<UserSber> generateRandomCollection() {
        Random random = new Random();
        return Stream.generate(() -> new UserSber("Петр" + random.nextInt(1_000_000),
                "petr@mail.ru")).limit(100_000).collect(Collectors.toList());
    }

    private Collection<UserSber> generateWorseCollection() {
        Collection<UserSber> collection = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            collection.add(new UserSber("Петр" + i, "petr@mail.ru"));
        }
        return collection;
    }
}
