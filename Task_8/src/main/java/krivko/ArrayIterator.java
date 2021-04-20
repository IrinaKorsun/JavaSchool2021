package krivko;

import java.util.*;

/**
 * Задание 8
 * <br> Итератор двумерного массива
 */
public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int index1;
    private int index2;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index1 < array.length && (index1 != array.length - 1 || index2 < array[index1].length);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (index2 == array[index1].length) {
            index2 = 0;
            index1++;
        }
        return array[index1][index2++];
    }
}
