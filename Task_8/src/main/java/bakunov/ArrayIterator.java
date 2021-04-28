package bakunov;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[][] items;
    private int currentIndex = 0;
    private int currentRow = 0;
    private int currentColumn = 0;
    private int size = 0;


    public ArrayIterator(T[][] items) {
        this.items = items;
        setSize();
    }

    public T[][] getContent() {
        return items;
    }

    public int getSize() {
        return size;
    }

    private void setSize() {
        for (T[] item : items) {
            this.size += item.length;
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (currentRow == items[0].length) {
            currentRow = 0;
            currentColumn++;
        }
        currentIndex++;
        return items[currentColumn][currentRow++];
    }
}
