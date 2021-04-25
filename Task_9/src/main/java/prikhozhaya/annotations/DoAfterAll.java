package prikhozhaya.annotations;

import java.lang.annotation.*;

/**
 * Аннотация, применяемая к методу, запуск которого производится последним.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DoAfterAll {
}
