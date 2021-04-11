package shakina;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class UserSberTest {

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates1RandomTest() {
        Collection<UserSber> collA = generateRandomCollection();
        Collection<UserSber> collB = generateRandomCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = Duplicate.findDuplicates1(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Число дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates1WorseTest() {
        Collection<UserSber> collA = generateWorseCollection();
        Collection<UserSber> collB = generateWorseCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = Duplicate.findDuplicates1(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Число дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates2RandomTest() {
        Collection<UserSber> collA = generateRandomCollection();
        Collection<UserSber> collB = generateRandomCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = Duplicate.findDuplicates2(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Число дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void findDuplicates2WorseTest() {
        Collection<UserSber> collA = generateWorseCollection();
        Collection<UserSber> collB = generateWorseCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = Duplicate.findDuplicates2(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Число дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test
    @Timeout(value = 400, unit = TimeUnit.MILLISECONDS)
    void findDuplicates3RandomTest() {
        Collection<UserSber> collA = generateRandomCollection();
        Collection<UserSber> collB = generateRandomCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = Duplicate.findDuplicates3(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Число дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    @Test()
    @Timeout(value = 400, unit = TimeUnit.MILLISECONDS)
    void findDuplicates3WorseTest() {
        Collection<UserSber> collA = generateWorseCollection();
        Collection<UserSber> collB = generateWorseCollection();

        long startTime = System.currentTimeMillis();
        List<UserSber> duplicates = Duplicate.findDuplicates3(collA, collB);
        long endTime = System.currentTimeMillis();

        System.out.println("Число дубликатов: " + duplicates.size());
        System.out.println("Время выполнения (сек): " + (endTime - startTime) / 1000.0);
    }

    private Collection<UserSber> generateRandomCollection() {
        Random random = new Random();
        return Stream.generate(() -> new UserSber("Иван" + random.nextInt(1_000_000),
                "ivan@mail.ru")).limit(100_000).collect(Collectors.toList());
    }

    private Collection<UserSber> generateWorseCollection() {
        Collection<UserSber> collection = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            collection.add(new UserSber("Иван" + i, "ivan@mail.ru"));
        }
        return collection;
    }

}