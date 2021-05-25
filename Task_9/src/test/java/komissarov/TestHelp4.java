package komissarov;

public class TestHelp4 {
    @ThisIsTest(priority = 3)
    public Object testMethod1() {
        return "Test method priority = 3";
    }

    @ThisIsTest(priority = 1)
    public Object testMethod2() {
        return "Test method priority = 1";
    }

    @ThisIsTest(priority = 7)
    public Object testMethod3() {
        return "Test method priority = 7";
    }

    @ThisIsTest
    public Object testMethod5() {
        return "Test method priority = default";
    }

}
