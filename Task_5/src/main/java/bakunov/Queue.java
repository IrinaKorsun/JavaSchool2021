package bakunov;

public class Queue {

    private final Object[] queue;
    private int count;

    public Queue(int size) {
        this.queue = new Object[size];
        count = 0;
    }

    /**
     * добавляет элемент в конец очереди
     *
     * @param obj, объект для вставки
     */
    public void enqueue(Object obj) throws QueueStackException {
        if (count < queue.length - 1) {
            queue[count] = obj;
            count++;
        } else {
            throw new QueueStackException(ErrorCode.IS_FULL);
        }
    }

    /**
     * удаляет возвращает элемент из начала очереди
     *
     * @return Object, объект из начала очереди
     */
    public Object dequeue() throws Exception {
        try {
            if (isEmpty()) {
                return null;
            } else {
                Object toReturn = queue[0];
                if (queue.length > 2) {
                    for (int i = 0; i < count - 2; i++) {
                        queue[i] = queue[i + 1];
                    }
                    count--;
                } else {
                    queue[0] = null;
                    count = 0;
                }
                return toReturn;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Проверка очереди на пустоту
     *
     * @return Boolean, true, если очередь пуста
     */
    public Boolean isEmpty() {
        return count == 0;
    }

    /**
     * возвращает, но не удаляет первый элемент очереди
     *
     * @return Object, объект из начала очереди
     */
    public Object top() {
        return queue[0];
    }
}
