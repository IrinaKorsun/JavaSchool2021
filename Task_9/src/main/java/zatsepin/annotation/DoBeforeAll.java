package zatsepin.annotation;

import java.lang.annotation.*;

/**
 * Used to signal that the annotated method should be executed before all @ThisIsTest methods.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoBeforeAll {
}
