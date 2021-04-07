package khoroshev;

public class Queue {
    private Object[] queue;
    private int head;
    private int tail;
    private int size;
    private final int MAX_SIZE;

    /**
     * Конструктор, определяющий тип объектов в массиве queue и его размер.
     * @param queue массив из определенного типа данных.
     */
    public Queue(Object[] queue) {
        this.queue = queue;
        MAX_SIZE = queue.length;
        tail = -1;
    }

    public Queue() {
        queue = new Object[100];
        MAX_SIZE = 10000;
        tail = -1;
    }

    /**
     * Добавляет элемент, если он не null,  в очередь с циклическим переносом указателя на последний элемент tail.
     * При успешной вставке элемента увеличивает размер списка на 1. А указатель перемещается на следующий в массиве
     * null элемент.
     * @param object объект для вставки в очередь.
     * @throws QueueException если размер массива равен максимальному(очередь переполнена)
     * или если пользователь хочет добавить null в очередь.
     */
    public void enqueue (Object object) throws QueueException {
        if (object == null) {
            throw new QueueException("Нельзя добавлять null в очередь.");
        }
        if (size == MAX_SIZE) {
            throw new QueueException("Превышен максимальный размер списка.");
        }
        if (size + 1 > queue.length) {
            int newSize = Math.min(queue.length * 2, MAX_SIZE);
            Object[] newQueue = new Object[newSize];
            int newTail = 0;
            while (newTail < size) {
                newQueue[newTail] = queue[head];
                newTail++;
                if (head != queue.length - 1) {
                    ++head;
                }
            }
            queue = newQueue;
            head = 0;
            tail = newTail - 1;
        }
        if (tail != queue.length - 1) {
            ++tail;
        }
        queue[tail] = object;
        size++;
    }

    /**
     * Метод удаления из очереди элемента с использованием циклического переноса указателя head и уменьшения размера на
     * 1, при условии, что очередь не пустая.
     * @throws QueueException если очередь пустая.
     */
    public void dequeue () throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Очередь пустая.");
        }
        queue[head] = null;
        head++;
        if (head == MAX_SIZE) {
            head = 0;
        }
        size--;
    }

    /**
     * Проверка очереди на пустоту.
     * @return true, если очередь пустая.
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * Метод вывода из очереди элемента.
     * @return объект, находящийся первым в очереди, если очередь не пуста.
     * @throws QueueException если очередь пустая.
     */
    public Object top() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Очередь пустая.");
        }
        return queue[head];
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }
}
