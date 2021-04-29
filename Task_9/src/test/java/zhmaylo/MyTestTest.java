package zhmaylo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zhmaylo.testclasses.TestClass1;
import zhmaylo.testclasses.TestClassNoBeforeAfter;
import zhmaylo.testclasses.TestClassWrongAfter;
import zhmaylo.testclasses.TestClassWrongBefore;

import java.util.List;

class MyTestTest {

    @Test
    void testWithGoodClass() throws Exception {
        List<Object> answer = MyTest.start(TestClass1.class);
        for (int i = 0; i < answer.size(); i++) {
            if (i == 3 || i == 4) {
                Assertions.assertEquals(3, answer.get(i));
            } else if (i == 5) {
                Assertions.assertEquals(i - 1, answer.get(i));
            } else {
                Assertions.assertEquals(i, answer.get(i));
            }
        }
    }

    @Test
    void wrongDoBefore() {
        Assertions.assertThrows(Exception.class, () -> MyTest.start(TestClassWrongBefore.class));
    }

    @Test
    void wrongDoAfter() {
        Assertions.assertThrows(Exception.class, () -> MyTest.start(TestClassWrongAfter.class));
    }

    @Test
    void noBeforeNoAfter() throws Exception {
        List<Object> answer = MyTest.start(TestClassNoBeforeAfter.class);
        for (int i = 0; i < answer.size(); i++) {
            if (i == 2 || i == 3) {
                Assertions.assertEquals(3, answer.get(i));
            } else {
                Assertions.assertEquals(i + 1, answer.get(i));
            }
        }
    }
}