package krivko;

import java.lang.annotation.*;

/**
 * Аннотация методов в которых идет тестирование
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ThisIsTest {
    public int order() default 1;
}