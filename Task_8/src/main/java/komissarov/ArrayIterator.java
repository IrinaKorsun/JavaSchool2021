package komissarov;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayIterator<T> implements Iterable<T> {
    private final List<T> elements;

    public ArrayIterator(T[][] array) {
        elements = new LinkedList<>();
        for (T[] array1 : array) {
            for (T array11 : array1) elements.add(array11);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
