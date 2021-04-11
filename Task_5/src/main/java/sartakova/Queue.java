package sartakova;

public class Queue {

    private final Object[] queue;
    private final int capacity;
    private int size;
    private int begin;
    private int end;


    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        end = -1;
        begin = 0;
        size = 0;
    }

    public void enqueue(Object element) throws Exception { // Вставляет элемент в конец очереди
        if (size == capacity) {
            throw new Exception("Ошибка! Очередь переполнена");
        }
        queue[++end] = element;
        size++;
    }

    public Object dequeue() throws Exception { // Удаляет и возвращает первый элемент из очереди, оставшиеся элементы сдвигаются
        if (isEmpty()) {
            throw new Exception("Ошибка! Очередь пустая");
        }
        Object removedValue = queue[begin];
        size--;
        for (int i = 1; i < capacity; i++) {
            queue[i - 1] = queue[i];
        }
        queue[end] = null;
        return removedValue;
    }


    public boolean isEmpty() { // Возвращает значение true, если очередь пуста
        return (size == 0);
    }

    public Object getTop() { //  Возвращает первый элемент очереди (без удаления)
        return queue[begin];
    }

    public int getSize() { // Возвращает текущее количество элементов в очереди
        return size;
    }

    public int getCapacity() { // Возвращает текущее количество элементов в очереди
        return capacity;
    }
}