package krivko;

/**
 * Задание 5.1
 * <br> Очередь любых объектов с циклическим переносом.
 * <br> С максимальным размером MAX_SIZE: {@value MAX_SIZE}
 * @author krivko
 * @version 1.5
 * @since 30.03.2021
 */
public class Queue {

    public static final int MAX_SIZE = 10_000;  // максимальный размер очереди

    private Object[] arrayQueue;     // массив объектов очереди
    private int front;               // первый элемент очереди
    private int rear;                // последний элемент очереди
    private int count;               // всего в очереди элементов

    /**
     * Конструктор очереди по умолчанию
     * <br>Начальный размер массива очереди равен 10
     */
    public Queue() {
        arrayQueue = new Object[10];
        front = count = 0;
        rear = -1;
    }

    /**
     * Вставляем элемент в конец очереди
     * @param object элемент помещаемый в очередь
     * @throws RuntimeException         если размер очереди превышает MAX_SIZE: {@value MAX_SIZE}
     * @throws IllegalArgumentException если аргумент равен null
     */
    public void enqueue(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Invalid argument: null");
        }

        if (count + 1 > MAX_SIZE) {
            throw new RuntimeException("Stack size exceeds MAX_SIZE: " + MAX_SIZE);
        }

        // Если текуший массив очереди мал, надо увеличивать его размр
        if (count + 1 > arrayQueue.length) {
            // новый размер очереди (смотрим, что бы он не привысил MAX_SIZE)
            int newSize = Math.min(arrayQueue.length * 2, MAX_SIZE);
            // создаем массив объектов с увеличиным размером и копируем туда данные из старого массива очереди
            Object[] arrayNewQueue = new Object[newSize];
            int newRear = 0;
            while (newRear < count) {
                arrayNewQueue[newRear] = arrayQueue[front];
                newRear++;
                front = nextIndex(front);
            }
            // копируем данные в наш массив очереди
            arrayQueue = arrayNewQueue;
            front = 0;
            rear = newRear - 1;
        }

        // добавляем новый элемент
        rear = nextIndex(rear);
        arrayQueue[rear] = object;
        count++;
    }

    /**
     * Счетчик реализации "циклического переноса" для начала и конца очереди
     * @param index принимает либо front или rear
     * @return новое значение индекса +1, если уперлись в конец массива очереди то 0
     */
    private int nextIndex(int index) {
        return index == arrayQueue.length - 1 ? 0 : ++index;
    }

    /**
     * Удаляем элемент из начала очереди
     */
    public void dequeue() {
        if (count > 0) {
            arrayQueue[front] = null;   // удаляем ссылку на объект
            front = nextIndex(front);
            count--;
        }
    }

    /**
     * Возвращает значение true, если очередь пуста
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Возвращаем первый элемент из начала очереди
     * @return возвращает элемент, а если очередь пустая то null
     */
    public Object top() {
        return isEmpty() ? null : arrayQueue[front];
    }

    /**
     * Сколько элементов в очереди
     */
    public int getCount() {
        return count;
    }
}