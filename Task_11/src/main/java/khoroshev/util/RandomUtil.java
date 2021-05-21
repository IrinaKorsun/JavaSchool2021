package khoroshev.util;

import khoroshev.model.Account;

import java.util.*;

public class RandomUtil {
    private static final Random random = new Random();

    public static int getRandomInt(int bound) {
        return random.nextInt(bound);
    }

    public static UUID getRandomUUID(Map<UUID, Account> accounts) {
        int count = random.nextInt(accounts.size());
        for (UUID uuid : accounts.keySet()) {
            if (count == 0) {
                return uuid;
            }
            count--;
        }
        return null;
    }
}
