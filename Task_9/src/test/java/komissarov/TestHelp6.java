package komissarov;

public class TestHelp6 {
    @DoAfterAll
    public Object afterMethod() {
        return "After method";
    }

    @DoBeforeAll
    public Object beforeMethod() {
        return "Before method";
    }
}
