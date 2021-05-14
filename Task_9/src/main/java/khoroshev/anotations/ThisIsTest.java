package khoroshev.anotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThisIsTest {
    int priority() default 0;
}
