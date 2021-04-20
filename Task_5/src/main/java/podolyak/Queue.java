package podolyak;


public class Queue {
    private final Object[] arrayQueue;
    private final int maxSize;
    private int amountElements;
    private int firstElement;
    private int lastElement;

    public Queue(int maxSize) {
        this.arrayQueue = new Object[maxSize];
        this.maxSize = maxSize;
        this.amountElements = 0;
        this.firstElement = 0;
        this.lastElement = -1;
    }

    /**
     * Метод вствляет элемент в конец очереди
     *
     * @param element - элемент для добаления
     * @throws Exception - если очередь переполнена
     */
    public void enqueue(Object element) throws Exception {
        if (amountElements == maxSize) {
            throw new Exception("Очередь переполнена");
        } else {
            if (lastElement == maxSize - 1) {
                lastElement = 0;
            } else {
                lastElement++;
            }
            arrayQueue[lastElement] = element;
            amountElements++;
        }
    }

    /**
     * Метод удаляет элемент из начала очереди
     *
     * @throws Exception - если очередь пуста
     */
    public void dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Очередь пуста");
        } else {
            if (firstElement == maxSize - 1) {
                arrayQueue[firstElement] = null;
                amountElements--;
                firstElement = 0;
            } else {
                arrayQueue[firstElement] = null;
                amountElements--;
                firstElement++;
            }
        }
    }

    /**
     * Метод проверяет пустали очередь
     *
     * @return boolean true - очередь пуста, false - в очереди есть элементы
     */
    public boolean isEmpty() {
        return amountElements == 0;
    }

    /**
     * Метод возвращает первый элемент очереди
     *
     * @return Object
     * @throws Exception - если очередь пуста
     */
    public Object top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Очередь пуста");
        } else {
            return arrayQueue[firstElement];
        }
    }
}
