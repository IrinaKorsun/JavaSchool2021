package starikov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Класс итератора для перебора двухмерного массива
 * В реализации на стадии создания объекта происходит преобразование
 * двухмерного массива в Arraylist, что упрощает работу с элементами, например,
 * с пустыми массивами и массивами с пропущенными элементам
 *
 * @param <T> тип элементов массива
 */
public class ArrayIterator2<T> {
    private ArrayList<T> data;
    private int index;

    ArrayIterator2(T[][] array) {
        index = 0;
        //интернет пишет, что вроде можно использовать методы в конструкторах,
        //хотя некоторые источники говорят, что лучше так не делать
        data = setData(array);
    }

    /**
     * Закрытый метод, используемый конструктором для преобразования двухмерного массива в список
     *
     * @param array двухмерный массив, с элементы которого необходимо итерировать
     * @return список из элементов массива
     */
    private ArrayList<T> setData(T[][] array) {
        //ArrayList, вместо List, используется умышленно, чтобы использовать метод trimToSize
        ArrayList<T> list = new ArrayList<>();
        for (T[] arr : array
        ) {
            list.addAll(Arrays.asList(arr));
        }
        list.trimToSize();
        return list;
    }

    /**
     * Проверяет, существует ли следующий элемент для итерации
     *
     * @return true - следующий элемент существует, false - следующий элемент не существует
     */
    public boolean hasNext() {
        return !data.isEmpty() && index < data.size();
    }

    /**
     * Возвращает следующий итерируемый элемент
     *
     * @return следующий элемент массива
     */
    public T next() {
        if (index == data.size()) {
            throw new NoSuchElementException("Нет элементов");
        }

        //return data.get(index++); короткая запись
        index++;
        return data.get(index - 1);
    }
}
