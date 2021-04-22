package shkabrov;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int row = 0, column = 0;

    public ArrayIterator(T[][] array) {
        this.array = array;
        if (array.length > 0) {
            while(array[row].length == 0) { // проверка на наличие пустых массивов
                row++;
                if(row >= array.length) {
                    break;
                }
            }
        }
    }

    /**
     * @return true, если следующий элемент не выходит за границы двумерного массива
     */
    @Override
    public boolean hasNext() {
        return row < array.length;
    }

    /**
     * @return следующий элемент в итерации
     * @throws NoSuchElementException выход за границы двумерного массива
     */
    @Override
    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        T currentArrayElement = array[row][column];
        column++;
        if(column >= array[row].length) {
            column = 0;
            row++;
        }
        if (hasNext()) {
            while(array[row].length == 0) { // проверка на наличие пустых массивов
                row++;
                if(row >= array.length) {
                    break;
                }
            }
        }
        return currentArrayElement;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an two-dimensional array");
    }
}
