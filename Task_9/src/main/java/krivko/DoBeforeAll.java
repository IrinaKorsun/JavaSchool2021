package krivko;

import java.lang.annotation.*;

/**
 * Аннотация одного метода, который выполняется до методов с аннотацией ThisIsTest
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoBeforeAll {
}