package emelyanov;

import org.junit.jupiter.api.Test;


public class MainTest {

    @Test
    void testBadAccounts50Clients70() throws InterruptedException {
        String[] propertyPath = {"emelyanov/config.properties"};
        Main.main(propertyPath);
    }

    @Test
    void testAccounts80Clients80() throws InterruptedException {
        String[] propertyPath = {"emelyanov/config1.properties"};
        Main.main(propertyPath);
    }

    @Test
    void testAccounts2Clients70() throws InterruptedException {
        String[] propertyPath = {"emelyanov/config2.properties"};
        Main.main(propertyPath);
    }
}
