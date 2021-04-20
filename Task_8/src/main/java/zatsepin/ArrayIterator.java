package zatsepin;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Can be used to iterate over two-dimensional arrays.
 *
 * @param <T> array element type
 */
public class ArrayIterator<T> implements Iterator<T> {

    private final T[][] array;
    private int firstIndex = 0;
    private int secondIndex = 0;

    /**
     * Constructs an object to iterate over a two-dimensional array passed as an argument.
     */
    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return firstIndex < array.length && secondIndex < array[firstIndex].length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = array[firstIndex][secondIndex];
        if (secondIndex == array[firstIndex].length - 1) {
            firstIndex++;
            secondIndex = 0;
        } else {
            secondIndex++;
        }
        return element;
    }
}
