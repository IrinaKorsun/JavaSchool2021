package komissarov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestBankSystem {
    @Test
    void testOneProperties() throws InterruptedException {
        Bank.main(new String[]{"komissarov/apTest1.properties"});
    }

    @Test
    void testTwoProperties() throws InterruptedException {
        try {
            Bank.main(new String[]{"komissarov/apTest2.properties"});
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Money leak");
        }
    }

    @Test
    void testThreeProperties() throws InterruptedException {
        Bank.main(new String[]{"komissarov/apTest3.properties"});
    }
}
