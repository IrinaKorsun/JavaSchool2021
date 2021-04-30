package galuza;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator <T> implements Iterator {
    private T[][] array;
    private int i = 0;
    private int j = 0;
    private int count = 0;
    int capacity;

    public ArrayIterator(T[][] array) {
        this.array = array;
        this.capacity = arrayCapacity();
    }

    @Override
    public boolean hasNext() {
        return count < capacity;
    }

    @Override
    public T next() {
        T result;
        if (count == arrayCapacity()) {
            throw new NoSuchElementException();
        }
        result = array[i][j];
        if (j == array[i].length - 1) {
            i++;
            j = 0;
        } else j++;
        count++;
        return result;
    }

    private int arrayCapacity() {
        int result = 0;
        for (T[] objects : array) {
            result += objects.length;
        }
        return result;
    }
}
