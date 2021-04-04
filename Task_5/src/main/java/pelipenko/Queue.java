package pelipenko;

import java.util.Arrays;

public class Queue {
    private Object[] queueArray;
    private int qSize = 0;
    private static final int MAX_CAPACITY = 1000;
    private static final int INITIAL_CAPACITY = 16;

    public Queue() {
        queueArray = new Object[INITIAL_CAPACITY];
    }

    public Queue(int capacity) {
        if (capacity >= 0 && capacity <= MAX_CAPACITY)
            queueArray = new Object[capacity];
        else throw new IllegalArgumentException("Размер очереди должен быть от 0 до " + MAX_CAPACITY);

    }

    /**
     * Метод добавляет новый элемент в очередь. Метод <code>{@link #extendArray()}</> расширет массив,
     * для избежаения переполнения
     * @param element - добавляемый элемент
     */
    public void enqueue(Object element) {
        if (qSize == MAX_CAPACITY)
            throw new IllegalStateException("Очередь переполнена!");

        extendArray();
        queueArray[qSize] = element;
        qSize++;
    }

    /**
     * Возращает первый элемент очереди, а затем удаляет его0.
     * @return первый элемент очереди, в случае пустой очереди - null
     */
    public Object dequeue() {
        if (qSize == 0)
            return null;

        Object result = queueArray[0];
        if (qSize - 1 >= 0) System.arraycopy(queueArray, 1, queueArray, 0, qSize - 1);
        queueArray[--qSize] = null;
        return result;
    }

    /**
     * Метод проверки наличия в очереди элементов
     * @return true при пустой очереди, иначе - false
     */
    public boolean isEmpty() {
        return qSize == 0;
    }

    /**
     * Возвращает первый элемент очереди без его удаления
     * @return первый элемент очереди
     */
    public Object top() {
        return queueArray[0];
    }

    /**
     * Метод расширения очереди
     */
    private void extendArray() {
        if (queueArray.length == qSize) {
            queueArray = Arrays.copyOf(queueArray, 2 * qSize + 1);
        }
    }
}