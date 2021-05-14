package podolyak.demo;

import podolyak.annotation.ThisIsTest;

public class DemoClassTwo {
    /**
     * DemoClassTwo используется для проверки сортировки методов согласно приоритету
     */
    public DemoClassTwo() {
    }

    @ThisIsTest(priority = 2)
    public void testTwo() {
        System.out.println("Test 2. Выполняется вторым");
    }

    @ThisIsTest(priority = 1)
    public void testOne() {
        System.out.println("Test 1. Выполняется первым");
    }

    @ThisIsTest(priority = 3)
    public void testTree() {
        System.out.println("Test 3. Выполняется третьим");
    }
}
