package podolyak.demo;

import podolyak.annotation.DoBeforeAll;

public class DemoClassTree {
    /**
     * DemoClassTree используется для проверки возникновения исключения при дублировании аннотации DoBefore
     */
    public DemoClassTree() {
    }

    @DoBeforeAll
    public void beforeAll() {
        System.out.println("@DoBefore. Выполняется перед тестами");
    }

    @DoBeforeAll
    public void beforeAllTwo() {
        System.out.println("@DoBefore. Выполняется перед тестами");
    }
}
