package zatsepin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class GoodCase1Test {

    @Test
    void goodCase1With70ClientsAnd100Accounts() throws InterruptedException {
        String[] propertyPath = {"zatsepin/goodcase1.properties"};
        Starter.main(propertyPath);
        TimeUnit.SECONDS.sleep(5);
    }
}