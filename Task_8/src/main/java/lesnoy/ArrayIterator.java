package lesnoy;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] items;
    private int index = 0;
    private int row = 0;
    private int column = 0;
    private int size = 0;

    public ArrayIterator(T[][] items) {
        this.items = items;
        this.size = getSize();
    }

    public int getSize() {
        for (T[] item : items) {
            this.size += item.length;
        }
        return this.size;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (row == items[0].length) {
            row = 0;
            column++;
        }
        index++;
        return items[column][row++];
    }
}