package starikov;

/**
 * Реализация кольцевой очереди. При удалении элемента из начала очереди, оставшиеся элементы
 * не сдвигаются к началу, а смещается указатель начала очереди. На освободившиеся места в начале очереди
 * могут быть размещены другие элементы.
 */
public class Queue {
    private Object[] queue;
    private int firstIndex = -1;
    private int lastIndex = -1;

    public Queue(int queueSize) {
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
        return firstIndex == -1 && lastIndex == -1;
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

        return queue[firstIndex];
    }

    /**
     * Удаляет элемент из начала очереди
     */
    public void dequeue() {
        if (isEmpty()) {
            throw new StackAndQueueException("Cannot get an item from the queue: the queue is empty.");
        }

        queue[firstIndex] = null;

        if (firstIndex == lastIndex) { //если единственный элемент, сбрасываем указатели
            firstIndex = lastIndex = -1;
        } else if (firstIndex == queue.length - 1) {//если последний индекс, то сбрасываем к первому индексу (закольцовываем)
            firstIndex = 0;
        } else {
            firstIndex++;
        }
    }

    /**
     * Вставляет элемент в конец очереди
     *
     * @param item Объект, который необходимо поставить в очередь
     */
    public void enqueue(Object item) {
        if ((firstIndex == 0 && lastIndex == queue.length - 1) || firstIndex - lastIndex == 1) {
            throw new StackAndQueueException("Cannot add an item to the queue: the queue is full.");
        }

        if (item != null) {

            if (lastIndex == queue.length - 1) {//если индекс максимальный, то закольцовываем очередь
                lastIndex = 0;
            } else {
                lastIndex++;

                if (firstIndex == -1) { //при вставке первого элемента, меняем индекс начала очереди
                    firstIndex++;
                }
            }
            queue[lastIndex] = item;
        }
    }
}
