package bakunov;

import bakunov.annotation.DoAfterAll;
import bakunov.annotation.DoBeforeAll;
import bakunov.annotation.ThisIsTest;

public class TestPriority {
        @ThisIsTest(priority = 2)
        public String testPriority2() {
            return "testPriority2_#2";
        }

        @ThisIsTest(priority = 3)
        public String testPriority3() {
            return "testPriority3_#1";
        }

        @ThisIsTest
        public String testNoPriority() {
            return "testNoPriority_#3";
        }

        @DoAfterAll
        public String afterAllAnnotation() {
            return "afterAllAnnotation";
        }

        @DoBeforeAll
        public String beforeAllAnnotation() {
            return "beforeAllAnnotation";
        }
}
