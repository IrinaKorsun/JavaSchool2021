package shkabrov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Метод, помеченный этой аннотацией, запускается после метода с аннотацией {@code @DoBeforeAll}, но перед методом с аннотацией
 * {@code @DoAfterAll}. Если методов с аннотацией {@code @ThisIsTest} несколько, они запускаются в зависимости от установленного
 * приоритета.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThisIsTest {
    int executionPriority() default 1;
}
