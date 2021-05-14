package podolyak;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import podolyak.demo.DemoClass;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTestDemo {

    @BeforeAll
    static void getSortMethods(){
        try {
            TestClass.start(DemoClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findBefore() {
        assertNotNull(TestClass.getBefore());
    }

    @Test
    void findAfter() {
        assertNotNull(TestClass.getAfter());
    }
}