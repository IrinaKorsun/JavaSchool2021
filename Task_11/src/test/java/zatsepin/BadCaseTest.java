package zatsepin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class BadCaseTest {

    @Test
    void badCaseWith70ClientsAnd50AccountsWhenCheckerThrowsException() throws InterruptedException {
        String[] propertyPath = {"zatsepin/default.properties", "BAD_CASE"};
        Starter.main(propertyPath);
    }
}