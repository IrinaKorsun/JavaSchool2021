package shkabrov;

import org.junit.jupiter.api.Test;
import shkabrov.testClasses.CorrectClass;
import shkabrov.testClasses.IncorrectClassDuplicateDoAfterAll;
import shkabrov.testClasses.IncorrectClassDuplicateDoBeforeAll;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryForCodeTestingTest {

    @Test
    void startWithCorrectClass() throws LibraryForCodeTestingException, InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException {
        List<Integer> resultsWorkingCorrectClass = LibraryForCodeTesting.Start(CorrectClass.class);
        assertEquals(new ArrayList<>(Arrays.asList(0, 1, 2, 2, 3, 4, 999)), resultsWorkingCorrectClass);
    }

    @Test
    void startWithIncorrectClassDuplicateDoBeforeAll() {
        assertThrows(LibraryForCodeTestingException.class, () -> LibraryForCodeTesting
                .Start(IncorrectClassDuplicateDoBeforeAll.class));
    }

    @Test
    void startWithIncorrectClassDuplicateDoAfterAll() {
        assertThrows(LibraryForCodeTestingException.class, () -> LibraryForCodeTesting
                .Start(IncorrectClassDuplicateDoAfterAll.class));
    }
}