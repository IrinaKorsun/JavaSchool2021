package prikhozhaya;

public class Queue {
    private final static int QUEUE_MAX_SIZE = 5;// максимальное количество элементов
    private Object array[] = new Object[QUEUE_MAX_SIZE];
    private int quantity = 0;  // текущее количество элементов
    private int first = 0; //ID первого элемента в массиве
    private int rear = -1; //ID последнего элемента в массиве

    public Queue() {
    }

    public Object[] getArray() {
        return array;
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
    public void enqueue(Object elem) throws Exception {
        if (quantity == QUEUE_MAX_SIZE) {
            throw new Exception("Очередь переполнена");
        }
        if (rear == (QUEUE_MAX_SIZE - 1)) {
            rear = -1;
        }
        quantity++;
        array[++rear] = elem;
    }

    /*
     * Удаляет элемент из начала очереди.
     *
     */
    public void dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Очередь пуста");
        }
        if (first == (QUEUE_MAX_SIZE - 1)) {
            first = 0;
        }
        array[first] = null;
        quantity--;
        first++;
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
            for (int i = first; i < QUEUE_MAX_SIZE; i++){
                if (array[i] != null) {
                    if (i != first) {
                        el.append("; ");
                    }
                    el.append(array[i]);
                }
            }
            if (first > rear){
                for (int i = 0; i <= rear; i++){
                    if (array[i] != null) {
                        el.append("; ");
                        el.append(array[i]);
                    }
                }
            }
        }
        return el.toString();
    }
}
