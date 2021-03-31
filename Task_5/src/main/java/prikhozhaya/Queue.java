package prikhozhaya;

public class Queue {
    private Object array[];
    private int maxSize; // максимальное количество элементов
    private int quantity;  // текущее количество элементов
    private int first; //ID первого элеиента в массиве
    private int rear; //ID последнего элеиента в массиве

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        rear = -1;
        first = 0;
        quantity = 0;
    }

    public Object[] getArray() {
        return array;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getnQuantity() {
        return quantity;
    }

    public int getRear() {
        return rear;
    }

    /*
     *Вставляет элемент в конец очереди.
     *
     * Метод получает значение нового элемента, после чего добавляет его
     * в очередь.
     * Размер очереди фиксирован (задается пользователем).
     * Если случается переполнение, возвращается ошибка "Очередь переполнена".
     *
     * @param element - объект, желающий оказаться в очереди.
     *
     */
    public void enqueue(Object elem) {
        if (quantity == maxSize) {
            throw new RuntimeException("Очередь переполнена");
        }
        if (rear == (maxSize - 1)) {
            rear = -1;
        }
        quantity++;
        array[++rear] = elem;
    }

    /*
     * Удаляет элемент из начала очереди.
     *
     */
    public void dequeue() {
        if (!isEmpty()) {
            if (first == (maxSize - 1)) {
                first = 0;
            }
            array[first] = null;
            quantity--;
            first++;
        }
    }

    /*
     *Возвращает значение true, если очередь пуста.
     *
     * Метод осуществляет проверку очереди на наличие элементов в ней.
     *
     * @return isEmpty - логический параметр (true - очередь пуста, false -
     * в очереди имеются элементы)
     *
     */
    public boolean isEmpty() {
        return (quantity == 0);
    }

    /*
     * Ввозвращает первый элемент очереди.
     *
     *Данный метод определяет элемент, попавший в очередь раньше
     * остальных, и возвращает его значение.
     *
     * @return element - элемент, попавший в очередь раньше остальных.
     *
     */
    public Object top() {
        Object el = null;
        if (!isEmpty()) {
            el = array[first];
        }
        return el;
    }

    @Override
    public String toString() {
        StringBuilder el = new StringBuilder();
        if (!isEmpty()) {
            for (Object a : array) {
                if (a != null) {
                    el.append(a).append(" ");
                }
            }
        }
        return el.toString();
    }
}