package podolyak.demo;

import podolyak.annotation.DoAfterAll;
import podolyak.annotation.DoBeforeAll;
import podolyak.annotation.ThisIsTest;

public class DemoClass {
    /**
     * DemoClass используется для проверки правильности порядка выполнения методов
     */
    public DemoClass() {
    }

    @DoBeforeAll
    public void beforeAll() {
        System.out.println("@DoBefore. Выполняется перед тестами");
    }

    @ThisIsTest(priority = 2)
    public void testTwo() {
        System.out.println("Test 2. Выполняется вторым");
    }

    @DoAfterAll
    public void afterAll() { System.out.println("@DoAfterAll. Выполняется после тестов"); }

    @ThisIsTest(priority = 1)
    public void testOne() {
        System.out.println("Test 1. Выполняется первым");
    }

    @ThisIsTest(priority = 1)
    public void testOneOne() {
        System.out.println("Test 1. Выполняется первым");
    }

    @ThisIsTest(priority = 3)
    public void testTree() {
        System.out.println("Test 3. Выполняется третьим");
    }
}
