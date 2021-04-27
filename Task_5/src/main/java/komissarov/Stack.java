package komissarov;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private int capacity = 10;
    private Object[] array = new Object[capacity];
    private int position = 0;
    private int maxCapacity = 1000;

    /**
     * Метод проверки стэка на пустоту
     *
     * @return boolean значение пустоты стэка.
     */
    public boolean isEmpty() {
        return position == 0;
    }

    /**
     * Метод добавления элемента в стэк.
     * Если добавляется объект после заполненности стэка - пробрасывается exception
     *
     * @param t - добавляемый объект стэка
     */
    public void push(T t) {
        if (position == maxCapacity) {
            throw new StackOverflowError("Стэк переполнен");
        }
        if (position >= capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
        array[++position] = t;
    }

    /**
     * Метод выводит последний элемент стэка с последующим его удалением.
     * В теле метода вызывается метод getLast - получения последнего элемента стэка.
     *
     * @return последний элемент стэка
     */
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T temp = (T) array[position];
        array[position] = null;
        position--;
        return temp;
    }

    /**
     * Метод выводит последний элемент стэка.
     * В теле метода вызывается метод getLast - получения последнего элемента стэка.
     *
     * @return последний элемент стэка
     */
    public T top() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) array[position];
    }

}
