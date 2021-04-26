package krivko;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    @Test
    public void goodTestClass() throws Exception {
        assertEquals(Arrays.asList("b1", "t3o1", "t2o2", "t4o2", "t1o5", "a1"), Runner.start(GoodTestClass.class));
    }

    @Test
    public void wrongTestClassTwoBefore() {
        assertThrows(RuntimeException.class, () -> Runner.start(WrongTestClassTwoBefore.class));
    }

    @Test
    public void wrongTestClassTwoAfter() {
        assertThrows(RuntimeException.class, () -> Runner.start(WrongTestClassTwoAfter.class));
    }

    public static class GoodTestClass {
        @DoBeforeAll
        public String before1() {
            return "b1";
        }

        @DoAfterAll
        public String after1() {
            return "a1";
        }

        @ThisIsTest(order = 5)
        public String test1() {
            return "t1o5";
        }

        @ThisIsTest(order = 2)
        public String test2() {
            return "t2o2";
        }

        @ThisIsTest
        public String test3() {
            return "t3o1";
        }

        @ThisIsTest(order = 2)
        public String test4() {
            return "t4o2";
        }
    }

    public static class WrongTestClassTwoBefore extends GoodTestClass {
        @DoBeforeAll
        public String before2() {
            return "b2";
        }
    }

    public static class WrongTestClassTwoAfter extends GoodTestClass {
        @DoAfterAll
        public String after2() {
            return "a2";
        }
    }
}