package podolyak;

import org.junit.jupiter.api.Test;
import podolyak.demo.DemoClassTree;

import static org.junit.jupiter.api.Assertions.*;

class TestClassDemoTree {

    @Test
    void startAssertException() {
        assertThrows(Exception.class, () -> TestClass.start(DemoClassTree.class));
    }
}