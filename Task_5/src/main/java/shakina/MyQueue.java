package shakina;

import shakina.exception.ErrorCode;
import shakina.exception.MyException;

public class MyQueue {

    private final Object[] queue;
    private final int capacity;
    private int currentSize;
    private int head;
    private int tail;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        tail = -1;
        head = 0;
        currentSize = 0;
    }

    /**
     * Вставляет элемент в конец очереди
     *
     * @param newElement - новый элемент для вставки
     */
    public void enqueue(Object newElement) throws MyException {
        if (currentSize == capacity) {
            throw new MyException(ErrorCode.FULL_QUEUE);
        }
        queue[++tail] = newElement;
        currentSize++;
    }

    /**
     * Удаляет и возвращает первый элемент из очереди, оставшиеся элементы сдвигаются
     *
     * @return удаленный элемент (стоявший первым в очереди)
     */
    public Object dequeue() throws MyException {
        if (isEmpty()) {
            throw new MyException(ErrorCode.EMPTY_QUEUE);
        }
        Object removedValue = queue[head];
        currentSize--;
        for (int i = 1; i < capacity; i++) {
            queue[i - 1] = queue[i];
        }
        queue[tail] = null;
        return removedValue;
    }

    /**
     * Возвращает значение true, если очередь пуста
     *
     * @return true или false
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * Возвращает первый элемент очереди (без удаления)
     *
     * @return элемент, который стоит в очереди первым
     */
    public Object getHead() {
        return queue[head];
    }

    /**
     * Возвращает текущее количество элементов в очереди
     *
     * @return целое число элементов
     */
    public int getCurrentSize() {
        return currentSize;
    }
}
