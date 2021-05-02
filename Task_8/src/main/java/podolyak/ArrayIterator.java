package podolyak;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int size;
    private int pointer;
    private int column;
    private int row;

    public ArrayIterator(T[][] array) {
        this.pointer = 0;
        this.column = 0;
        this.row = 0;
        this.array = array;
        for (T[] row : array) {
            this.size += row.length;
        }
    }

    @Override
    public boolean hasNext() {
        return pointer != size;
    }

    @Override
    public T next() {
        if (hasNext()) {
            if (row < array.length && column == array[row].length) {
                column = 0;
                row++;
            }
            pointer++;
            T element = array[row][column];
            column++;
            return element;
        } else {
            throw new NoSuchElementException();
        }
    }
}
