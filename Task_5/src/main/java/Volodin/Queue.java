package Volodin;

public class Queue {
    private Object[] queue;
    private int maxSize;
    private int nElem;
    private int front;
    private int rear;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    /**
     * Метод вставляющий элемент в конец очереди
     * @param elem
     */
    public void enqueue (Object elem) {
        if (rear == maxSize - 1) {
            rear = - 1;
        }
        queue[++rear] = elem;
        nElem++;
    }

    /**
     * Метод удаляет элемент из начала очереди
     * @return
     */
    public Object dequeue () {
        Object temp = queue[front++];

        if (front == maxSize) {
            front = 0;
        }
        nElem--;
        return temp;
    }

    /**
     * Метод возвращает первый элемент в очереди
     * @return
     */
    public Object top() {
        return queue[front];
    }

    /**
     * Метод возвращает значение true если очередь пуста
     * @return
     */
    public boolean isEmpty() {
        return (nElem == maxSize - 1);
    }
}
