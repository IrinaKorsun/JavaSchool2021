package starikov;

/**
 * Реализация очереди, в которой элементы сдвигаются на свободное место
 * при удалении элемента из начала очереди
 */
public class Queue2 {
    private Object[] queue;
    private int index = -1;

    public Queue2(int queueSize) {
        queue = new Object[queueSize];
    }

    public Object[] getQueue() {
        return queue.clone();
    }

    /**
     * Проверяет, является ли очередь пустой.
     *
     * @return true - очередь пуста, false - очередь не пуста
     */
    public boolean isEmpty() {
        return index == -1;
    }

    /**
     * Возвращает первый элемент очереди
     *
     * @return Объект, расположенный первым в очереди
     */
    public Object top() {
        if (isEmpty()) {
            throw new StackAndQueueException("Cannot get an item from the queue: the queue is empty.");
        }

        return queue[0];
    }

    /**
     * Удаляет элемент из начала очереди
     */
    public void dequeue() {
        if (isEmpty()) {
            throw new StackAndQueueException("Cannot get an item from the queue: the queue is empty.");
        }

        for (int i = 0; i < index; i++) {
            queue[i] = queue[i + 1];
        }

        queue[index] = null;
        index--;
    }

    /**
     * Вставляет элемент в конец очереди
     *
     * @param item Объект, который необходимо поставить в очередь
     */
    public void enqueue(Object item) {
        if (index == queue.length - 1) {
            throw new StackAndQueueException("Cannot add an item to the queue: the queue is full.");
        }

        if (item != null) {
            index++;
            queue[index] = item;
        }
    }
}