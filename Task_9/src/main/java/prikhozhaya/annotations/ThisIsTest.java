package prikhozhaya.annotations;

import java.lang.annotation.*;

/**
 * Аннотация, применяемая к методам, запуск которых производится после метода с аннотацией
 * @DoBeforeAll (если такой имеется) и перед методом с аннотацией @DoAfterAll (если такой имеется).
 * Запуск производится в произвольном порядке, либо с учетом приоритета.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ThisIsTest {
    public int priority() default 1;
}
