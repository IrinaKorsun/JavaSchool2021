package khoroshev;

import khoroshev.anotatedClasses.*;
import khoroshev.exception.AnnotateException;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    @Test
    void successClassTest() throws Exception {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), Runner.start(SuccessClass.class));
    }

    @Test
    void duplicatedDoBeforeAllTest() {
        assertThrows(AnnotateException.class, () -> Runner.start(DuplicatedDoBeforeAll.class));
    }

    @Test
    void duplicatedDoAfterAllTest() {
        assertThrows(AnnotateException.class, () -> Runner.start(DuplicatedDoAfterAll.class));
    }

    @Test
    void classWithoutThisIsTestAnnotation() {
        assertThrows(AnnotateException.class, () -> Runner.start(WithoutThisIsTestAnnotation.class));
    }

    @Test
    void onlyThisIsTestAnnotationClassTest() throws Exception {
        assertEquals(Arrays.asList(1, 2, 3), Runner.start(OnlyThisIsTestAnnotations.class));
    }

}
