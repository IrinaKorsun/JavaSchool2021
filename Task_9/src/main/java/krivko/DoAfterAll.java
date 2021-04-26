package krivko;

import java.lang.annotation.*;

/**
 * Аннотация одного метода, который выполняется после методов с аннотацией ThisIsTest
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoAfterAll {
}