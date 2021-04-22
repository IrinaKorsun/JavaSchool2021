package sartakova;

public class Queue {

    private final Object[] queue;
    private final int capacity;
    private int current_number;
    private int begin;
    private int end;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        end = -1;
        begin = 0;
        current_number = 0;
    }

    public void enqueue(Object element) throws Exception { // Вставляет элемент в конец очереди
        if (current_number == capacity) {
            throw new Exception("Ошибка!Очередь переполнена");
        }
        queue[++end] = element;
        current_number++;
    }

    public Object dequeue() throws Exception { // Удаляет и возвращает первый элемент из очереди, оставшиеся элементы сдвигаются
        if (isEmpty()) {
            throw new Exception("Ошибка!Очередь пустая");
        }
        Object removedValue = queue[begin];
        current_number--;
        for (int i = 1; i < capacity; i++) {
            queue[i - 1] = queue[i];
        }
        queue[end] = null;
        return removedValue;
    }


    public boolean isEmpty() { // Возвращает значение true, если очередь пуста
        return (current_number == 0);
    }

    public Object getBegin() { // Возвращает первый элемент очереди (без удаления)
        return queue[begin];
    }

    public int getCurrentNumber() { // Возвращает текущее количество элементов в очереди
        return current_number;
    }
}