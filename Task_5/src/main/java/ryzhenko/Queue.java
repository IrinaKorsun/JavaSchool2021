package ryzhenko;

public class Queue {

    private int first = 0; //Указатель на вершину очереди
    private int last = -1; //Указатель на конец очереди
    private int size = 0; //Текущий размер очереди
    private final static int MAX_SIZE = 100; //Максимальный размер очереди
    private Object[] Array;

    public Queue() {
        this.Array = new Object[MAX_SIZE];
    }

    /**
     * Вставляет элемент в конец очереди
     *
     * @param element Элемент очереди
     * @throws Exception Если очередь переполнена
     */
    public void enqueue(Object element) throws Exception {
        if (size < MAX_SIZE) {
            if (first != 0) {
                offsetArray();
            }
            last++;
            size++;
            Array[last] = element;

        } else {
            throw new Exception("Queue is full!");
        }
    }

    /**
     * Удаляет элемент из начала очереди
     *
     * @throws Exception Если очередь пуста
     */
    public void dequeue() throws Exception {
        if (!isEmpty()) {
            Array[first] = null;
            first++;
            size--;
        } else {
            throw new Exception("Queue is empty!");
        }
    }

    /**
     * Возвращает значение true, если очередь пуста
     *
     * @return true или false
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Возвращает первый элемент очереди
     *
     * @return Элемент типа Object или null, если очередь пуста
     */
    public Object top() {
        if (isEmpty()) {
            return null;
        } else {
            return Array[first];
        }
    }

    /**
     * Если в начале очереди есть место, смещает очередь
     */
    private void offsetArray() {
        for (int i = 0; i < MAX_SIZE - first; i++) {
            Array[i] = Array[i + first];
        }
        for (int i = MAX_SIZE - first; i < MAX_SIZE; i++) {
            Array[i] = null;
        }
        last = last - first;
        first = 0;
    }
}