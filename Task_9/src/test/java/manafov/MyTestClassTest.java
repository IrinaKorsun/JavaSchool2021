package manafov;

import manafov.fortest.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyTestClassTest {
    @Test
    void startThrowsExceptionWhenDuplicateBeforeAll() {
        assertThrows(Exception.class, () -> MyTestClass.start(DuplicateBeforeAll.class));
    }

    @Test
    void startThrowsExceptionWhenDuplicateAfterAll() {
        assertThrows(Exception.class, () -> MyTestClass.start(DuplicateAfterAll.class));
    }

    @Test
    void beforeAfterAll() throws Exception {
        assertEquals("DoBeforeAll", MyTestClass.start(BeforeAfterAll.class).get(0));
        assertEquals("DoAfterAll", MyTestClass.start(BeforeAfterAll.class).get(1));
    }

    @Test
    void beforeAfterAllForOneMethod() throws Exception {
        assertEquals("DoBeforeAll", MyTestClass.start(BeforeAfterAllForOneMethod.class).get(0));
        assertEquals("DoAfterAll", MyTestClass.start(BeforeAfterAllForOneMethod.class).get(1));
    }

    @Test
    void withoutBeforeAfterAll() throws Exception {
        assertEquals("ThisIsTest1", MyTestClass.start(WithoutBeforeAfterAll.class).get(0));
        assertEquals("ThisIsTest2", MyTestClass.start(WithoutBeforeAfterAll.class).get(1));
        assertEquals("ThisIsTest3", MyTestClass.start(WithoutBeforeAfterAll.class).get(2));
    }

    @Test
    void thisIsTests() throws Exception {
        assertEquals("DoBeforeAll", MyTestClass.start(ThisIsTests.class).get(0));
        assertEquals("ThisIsTest1", MyTestClass.start(ThisIsTests.class).get(1));
        assertEquals("ThisIsTest2", MyTestClass.start(ThisIsTests.class).get(2));
        assertEquals("ThisIsTest3", MyTestClass.start(ThisIsTests.class).get(3));
        assertEquals("DoAfterAll", MyTestClass.start(ThisIsTests.class).get(4));
    }
}
