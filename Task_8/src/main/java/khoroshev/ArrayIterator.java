package khoroshev;

import java.util.*;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int column;
    private int line;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return column < array.length && (column != array.length - 1 || line < array[column].length);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("В массиве больше нет значений!");
        }
        if (line == array[column].length) {
            line = 0;
            column++;
        }
        return array[column][line++];
    }
}
