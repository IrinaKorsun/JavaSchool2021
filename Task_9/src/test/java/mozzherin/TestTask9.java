package mozzherin;

import mozzherin.demoClasses.DemoClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask9 {
    private Object demoClass = new DemoClass();

    @Test
    void test() throws Exception {
        HashMap<Integer, Method> resultsMap = UnitClass.start(DemoClass.class);
        DemoClass testedObj = DemoClass.class.getDeclaredConstructor().newInstance();

        for (int i = 0; i < resultsMap.size(); i++) {
            assertEquals(i, resultsMap.get(i).invoke(testedObj));
        }
    }
}
