package zatsepin.annotation;

import java.lang.annotation.*;

/**
 * Used to signal that the annotated method should be executed as test method.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ThisIsTest {
    public int priority() default 1;
}
