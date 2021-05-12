package ryzhenko;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private final T[][] array;
    private int row = 0;
    private int column = 0;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    /**
     * Проверяет имеется ли следующий элемент
     *
     * @return true, если да, иначе false
     */
    @Override
    public boolean hasNext() {
        return (row < array.length && column < array[row].length);
    }

    /**
     * Возвращает текущий элемент и переходит к следующему, если такого нет, то генерируется исключение NoSuchElementException
     *
     * @return текущий элемент
     */
    @Override
    public T next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = array[row][column];
        if (column == array[row].length - 1) {
            row++;
            column = 0;
        } else {
            column++;
        }
        return element;
    }
}