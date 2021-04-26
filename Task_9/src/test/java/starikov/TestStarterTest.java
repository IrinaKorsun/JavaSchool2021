package starikov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestStarterTest {

    @Test()
    void start() {
        //проверка порядка запуска методов
        List<String> result = TestStarter.start(TestsClass.class.getName());
        List<String> expectedList = new ArrayList<>();
        expectedList.add("DoBeforeAll");
        expectedList.add("Test4: priority 1");
        expectedList.add("Test2: default priority 2");
        expectedList.add("Test6: priority 3");
        expectedList.add("Test3: priority 4");
        expectedList.add("DoAfterAll");
        assertEquals(expectedList, result);

        //проверка на ошибку при дублировании аннотации @DoBeforeAll
        try {
            TestStarter.start(TestsClass2.class.getName());
        } catch (RuntimeException ex) {
            assertEquals("Дублирование аннотации DoBeforeAll", ex.getMessage());
        }

        //проверка класса без аннотаций @DoBeforeAll и @DoAfterAll
        result = TestStarter.start(TestsClass3.class.getName());
        expectedList.clear();
        expectedList.add("Test4: priority 1");
        expectedList.add("Test2: default priority 2");
        expectedList.add("Test6: priority 3");
        expectedList.add("Test3: priority 4");
        assertEquals(expectedList, result);
    }
}