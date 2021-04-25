package prikhozhaya.annotations;

import java.lang.annotation.*;

/**
 * Аннотация, применяемая к методу, запуск которого производится первым.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DoBeforeAll {
}
