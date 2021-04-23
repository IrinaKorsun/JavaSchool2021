package starikov;

import java.util.NoSuchElementException;

/**
 * Реализация класса итератора двухмерного массива элементов.
 * В данной реализации двухмерный массив не преобразуется в одномерный,
 * а происходит изменение значений указателей строки и столбца массива
 * Реализация допускает в качетсве входных данных двухмерные нулевые или не полные массивы например, {{},{},{1, 2}}
 *
 * @param <T> - тип элементов коллекции
 */
public class ArrayIterator<T> {
    private T[][] data;
    private int rowIndex;
    private int columnIndex;

    ArrayIterator(T[][] array) {
        data = array;
        rowIndex = 0;
        columnIndex = -1;
        //находим позицию первого элемента. необходимо для пустых и не полных массивов
        // например, {{},{},{1, 2}}
        moveToNext();
    }

    /**
     * Устанавливает значение указателей на следующий существующий элемент в массиве
     */
    private void moveToNext() {
        //установка начальных значений для итераторов операторов for
        int startRow = rowIndex;
        // +1, чтобы начать движение со следующего, после возвращенного, элемента
        int startColumn = columnIndex + 1;

        //корректировка начальных значений при достижении конца строки
        if (startColumn == data[rowIndex].length) {
            startRow++;
            startColumn = 0;
        }

        //при переходе к следующему не нулевому значению, запоминаем его индексы и выходим из метода
        for (int i = startRow; i < data.length; i++) {
            for (int j = startColumn; j < data[i].length; j++) {
                if (data[i][j] != null) {
                    rowIndex = i;
                    columnIndex = j;
                    return;
                }
            }
        }
        //при пустом массиве или после перебора всех элементов
        rowIndex = -1;
    }

    /**
     * Проверяет, будет ли возвращен элемент, если вызвать метод next()
     *
     * @return true - элемент будет возвращен, false - элемент не будет возвращен
     */
    boolean hasNext() {
        return rowIndex != -1;
    }

    /**
     * Возвращает следующи элемент коллекции.
     * Если массив пустой или достигнут конец массива, то возникает NoSuchElementException
     *
     * @return
     */
    T next() {
        if (rowIndex == -1) {
            throw new NoSuchElementException("Нет следующего элемента");
        }
        //запоминаем элемент
        T elem = data[rowIndex][columnIndex];
        //переходим к следующему
        moveToNext();
        //возвращаем элемент, который запомнили
        return elem;
    }
}
