package shakina;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final int size;
    private int count;
    private final T[][] array;
    private int indexCurrentSubArray, indexCurrentElement;

    public ArrayIterator(T[][] array) {
        this.array = array;
        this.size = countElements();
    }

    /**
     * Проверяет, есть ли следующий элемент
     * @return true - если есть, false - если нет
     */
    @Override
    public boolean hasNext() {
        return count < size;
    }

    /**
     * Возвращает следующий элемент
     * @return следующий элемент
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (indexCurrentSubArray < array.length && indexCurrentElement == array[indexCurrentSubArray].length) {
            indexCurrentSubArray++;
            indexCurrentElement = 0;
        }

        count++;
        return array[indexCurrentSubArray][indexCurrentElement++];
    }

    /**
     * Считает общее количество элементов в двумерном массиве
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