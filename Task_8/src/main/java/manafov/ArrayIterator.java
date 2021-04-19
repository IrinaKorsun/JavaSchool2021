package manafov;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[][] array;
    private int currentRow;
    private int currentCol;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (currentRow >= array.length ||
                currentCol >= array[currentRow].length && currentRow == array.length - 1)
            return false;
        return true;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        if (currentCol >= array[currentRow].length) {
            currentCol = 0;
            currentRow++;
        }
        return array[currentRow][currentCol++];
    }
}
