package lesnoy;

public class Queue {
    private final Object[] queue;
    private int qtyElem;
    private final int indexTop;
    private int indexLast;

    public Queue(int maxSize) {
        queue = new Object[maxSize];
        indexTop = 0;
        indexLast = -1;
        qtyElem = 0;
    }

    /**
     * Данный метод добавляет элемент в конец очереди
     *
     * @param elem - объект для добавления.
     */
    public void enqueue(Object elem) throws Exception {

        if (indexLast + 1 < queue.length) {
            queue[indexLast + 1] = elem;
            qtyElem++;
            indexLast++;
        } else {
            throw new Exception("Место в очереди закончилось!");
        }
    }

    /**
     * Данный метод удаляет элемент из начала очереди
     *
     * @return - Object из начала очереди.
     */
    public Object dequeue() {
        try {
            Object temp = queue[indexTop];
            for (int i = 0; i < indexLast; i++) {
                queue[i] = queue[i + 1];
            }
            indexLast--;
            qtyElem--;
            return temp;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Данный метод проверяет, пуста ли очередь
     *
     * @return Boolean (true) - если очередь пуста.
     */
    public boolean isEmpty() {
        return (qtyElem == 0);
    }

    /**
     * Данный метод возвращает первый элемент очереди
     *
     * @return Object queue[indexTop] - объект из начала очереди.
     */
    public Object top() {
        return queue[indexTop];
    }
}
