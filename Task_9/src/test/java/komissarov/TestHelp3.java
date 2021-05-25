package komissarov;

public class TestHelp3 {
    @ThisIsTest
    public Object testMethod1() {
        return "ThisIsTest";
    }

    @DoAfterAll
    public Object afterMethod() {
        return "After method";
    }

    @DoBeforeAll
    public Object beforeMethod() {
        return "Before method";
    }
}
