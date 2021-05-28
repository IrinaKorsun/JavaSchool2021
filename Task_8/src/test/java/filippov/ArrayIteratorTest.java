package filippov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayIteratorTest {

    private static Integer [][] matrix;
    private final Object Exception = new Exception();

    @BeforeAll
    static void beforeAll() {
        int sizeX = (int) (Math.random() * 10);
        int sizeY = (int) (Math.random() * 10);
        matrix = new Integer[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int k = 0; k < sizeX; k++) {
                matrix[i][k] = (int) (Math.random() * 10);
            }
        }
    }

    @Test
    void hasNextWithEmptyMatrix() {
        Integer [][] matrix1 = new Integer[0][0];
        ArrayIterator<Integer> i = new ArrayIterator<>(matrix1);
        Assertions.assertFalse(i.hasNext());
    }

    @Test
    void nextWithEmptyMatrix() {
        Integer [][] matrix1 = new Integer[0][0];
        ArrayIterator<Integer> i = new ArrayIterator<>(matrix1);
        try{i.hasNext();
        }catch(ArrayIndexOutOfBoundsException e){
            Assertions.assertEquals(e.getMessage(), "ArrayIndexOutOfBoundsException");
        }
    }

    @Test
    void compareStreamAndCustomIteratorMethod() {
        ArrayIterator<Integer> i = new ArrayIterator<>(matrix);
        Arrays.stream(matrix).flatMap(Arrays::stream).forEach(e -> Assertions.assertEquals(e, i.next()));
    }
}




