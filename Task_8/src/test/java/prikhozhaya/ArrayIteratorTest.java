package prikhozhaya;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    void hasNext() {
        Integer[][] items = {{1}};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(items);
        assertTrue(arrayIterator.hasNext());
        arrayIterator.next();
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void next() {
        Integer items[][] = new Integer[10][10];
        for (int i = 0; i < items.length; i++){
            for (int j = 0; j < items[i].length; j++){
                items[i][j] = ((int) (Math.random() * 10));
            }
        }

        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(items);
        for (Integer[] item: items){
            for (Integer integer: item){
                assertEquals(integer, arrayIterator.next());
            }
        }
    }
}