package sartakova;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator <T> implements Iterator <T> {
    private final int size; //всего элементов в матрице
    private int count; //номер текущего элемента
    private final T[][] array;
    private int row; //строка текущего элемента
    private int col; //столбец текущего элемента

    public ArrayIterator(T[][] array) {
        this.array = array;
        this.size = countElements();
    }

    /**
     * Метод,проверяющий наличие следующего элемента
     * @return true - если есть, false - если нет
     */
    @Override
    public boolean hasNext() {
        return count < size;
    }

    /**
     * Метод, возвращающий следующий элемент
     * @return следующий элемент
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (row < array.length && col == array[row].length) {
            row++;
            col = 0;
        }

        count++;
        return array[row][col++];
    }

    /**
     * Метод, считающий общее количество элементов в двумерном массиве
     * @return кол-во элементов массива
     */
    private int countElements(){
        int count = 0;
        for (T[] subArray : array) {
            count += subArray.length;
        }
        return count;
    }
}
