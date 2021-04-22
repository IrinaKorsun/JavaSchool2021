package emelyanov;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator {
    private T[][] array;
    private int i, j;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return i < array.length && j < array[i].length;

    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T intArray = array[i][j++];
        if (j >= array[i].length) {
            i++;
            j = 0;
        }
        return intArray;
    }
}
