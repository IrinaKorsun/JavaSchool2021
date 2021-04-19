package prikhozhaya;

import java.util.*;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int size;   //количество элементов в array
    private int row = 0;    //строка текущего элемента в array
    private int col = -1;    //столбец текущего элемента в array
    private int index = 0;  //количество элементов перенесенных из массива array

    public ArrayIterator(T[][] array) {
        this.array = array;
        for (T[] row : array) {
            size += row.length;
        }
    }

    @Override
    public boolean hasNext() {
        return index != size;
    }

    @Override
    public T next() {
        if (index == size) {
            throw new NoSuchElementException();
        }
        col++;
        if (row < array.length && col == array[row].length) {
            col = 0;
            row++;
        }
        index++;
        return array[row][col];
    }
}