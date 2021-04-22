package pelipenko;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator {

    private final T[][] array;
    private int row;
    private int col;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return row < array.length && (row != array.length - 1 || col < array[row].length);
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        if(col >= array[row].length) {
            col = 0;
            row++;
        }
        return array[row][col++];
    }
}
