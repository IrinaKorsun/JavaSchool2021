package komissarov;

import java.util.Arrays;

public class Queue<T> {
    private int capacity = 10;
    private Object[] array = new Object[capacity];
    private int position = 0;
    private int maxCapacity = 1000;

    /**
     * Метод проверки стэка на пустоту
     *
     * @return boolean значение пустоты очереди.
     */
    public boolean isEmpty() {
        return position == 0;
    }

    /**
     * Метод добавления элемента в конец очереди.
     * Если добавляется объект после заполненности очереди - пробрасывается exception
     *
     * @param t - добавляемый объект очереди
     */
    public void enqueue(T t) throws QueueException {
        if (position == maxCapacity) {
            throw new QueueException("Очередь переполнена");
        }
        if (position >= capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
        array[position] = t;
        position++;
    }

    /**
     * Метод выводит первый элемент очереди
     * В теле метода вызывается метод getFirst - получения первого элемента очереди.
     *
     * @return первый элемент очереди
     */
    public T top() throws QueueException {
        T temp = getFirst();
        return temp;
    }

    /**
     * Метод выводит первый элемент очереди с последующим его удалением.
     * В теле метода вызывается метод getFirst - получения первого элемента очереди.
     *
     * @return первый элемент очереди
     */
    public T dequeue() throws QueueException {
        T temp = getFirst();
        System.arraycopy(array, 1, array, 0, position--);
        array[position] = null;
        return temp;
    }

    /**
     * Метод получения первого элемента очереди.
     * Если очередь пуста, пробрасывается exception.
     *
     * @return первый элемент очереди
     */
    private T getFirst() throws QueueException {
        if (isEmpty()) throw new QueueException("Очередь пуста");
        return (T) array[0];
    }
}
