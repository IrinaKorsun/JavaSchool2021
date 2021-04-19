package zhmaylo;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] matrix;
    private int lvl1;
    private int lvl2;

    public ArrayIterator(T[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Переопределяем метод next, проверяем - если дошли до конца вложенного массива, то переключаемся на следующий
     * с обнулем текущего элемента массива второго уровня
     *
     * @return возвращаем текущий элемент массива второго уровня с последущим увеличением "индекса" lvl2
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements!");
        }
        if (lvl2 >= matrix[lvl1].length) {
            lvl1++;
            lvl2 = 0;
        }
        return matrix[lvl1][lvl2++];
    }

    /**
     * Проверяем что бы оба индексы и первого и второго уровня не выходили за пределы длинны массива.
     * Если выходит значит следующего быть не может
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return lvl1 < matrix.length
                && (lvl1 != matrix.length - 1 || lvl2 < matrix[lvl1].length)
                && (matrix[lvl1].length > 0);
    }
}
