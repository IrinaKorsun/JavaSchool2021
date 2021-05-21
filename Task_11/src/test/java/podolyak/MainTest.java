package podolyak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testPropertyTwoAccounts(){
        String[] args = {"good"};
        Main.main(args);
    }
    @Test
    void testPropertyException() {
        String[] args = {"bad"};
        Assertions.assertThrows(Exception.class, () -> Main.main(args));
    }

}