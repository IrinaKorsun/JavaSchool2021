package mozzherin;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterable<T> {
    private int size = 0;// колличество массивов
    private int sizeLastArray = 0; // размер последнего массива
    private int indexArray = 0; // индекс массива
    private int indexElement = 0; // индекс элемента
    private T[][] array;

    public ArrayIterator(T[][] object) {
        this.array = object;
        size = object.length - 1;
        sizeLastArray = object[object.length - 1].length - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return !((indexArray == size) & (indexElement > sizeLastArray));
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (array[indexArray].length == indexElement) {
                    indexArray++;
                    indexElement = 0;
                }
                return array[indexArray][indexElement++];
            }
        };
    }
}
