package pelipenko;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotationTest {
    @Test
    public void goodTestClass() throws Exception {
        assertEquals(Arrays.asList("До тестов", "1", "2", "3", "6", "После тестов"), TestStart.start(SequenceTest.class));
    }

    @Test
    public void wrongTestClassTwoBefore() {
        assertThrows(RuntimeException.class, () -> TestStart.start(WrongTestClassTwoBefore.class));
    }

    @Test
    public void wrongTestClassTwoAfter() {
        assertThrows(RuntimeException.class, () -> TestStart.start(WrongTestClassTwoAfter.class));
    }

    public static class SequenceTest {
        @DoBeforeAll
        public String before1() {
            return "До тестов";
        }

        @DoAfterAll
        public String after1() {
            return "После тестов";
        }

        @ThisIsTest(priority = 6)
        public String test1() {
            return "6";
        }

        @ThisIsTest(priority = 2)
        public String test2() {
            return "2";
        }

        @ThisIsTest
        public String test3() {
            return "1";
        }

        @ThisIsTest(priority = 3)
        public String test4() {
            return "3";
        }
    }

    public static class WrongTestClassTwoBefore extends SequenceTest {
        @DoBeforeAll
        public String before2() {
            return "Повтор BeforeAll";
        }
    }

    public static class WrongTestClassTwoAfter extends SequenceTest {
        @DoAfterAll
        public String after2() {
            return "Повтор AfterAll";
        }
    }
}
