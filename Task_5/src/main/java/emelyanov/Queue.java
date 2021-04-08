package emelyanov;

import java.util.Arrays;

public class Queue {
    /*
     * maxSize - максимальное количество элементов в очереди
     * arrayQueue массив элементов
     * top верхний элемент
     * numberElement текущее количество элементов в очереди
     * front указатель на первый элемент
     * rear указатель на последний элемент
     */
    private Object[] arrayQueue;
    private int maxSize;
    private int numberElement;
    private int front;
    private int rear;

    /**
     * Конструктор очереди
     *
     * @param maxSize - размер очереди
     */
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arrayQueue = new Object[maxSize];
        numberElement = 0;
        front = 0;
        rear = -1;
    }

    /**
     * Вставляет элемент в конец очереди
     */
    public void enqueue(Object value) {
        if (rear == maxSize - 1) {  // циклический перенос
            throw new ArrayIndexOutOfBoundsException("Очередь полная");
        }
        arrayQueue[++rear] = value;  //увеличение Rear и вставка
        numberElement++;
    }

    /**
     * Удаляет элемент из начала очереди
     */
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object removedValue = arrayQueue[front];
        numberElement--;
        for (int i = 1; i < maxSize; i++) {
            arrayQueue[i - 1] = arrayQueue[i];
        }
        arrayQueue[rear] = null;
        return removedValue;
    }

    /**
     * Возвращает значение true, если очередь пуста
     */
    public boolean isEmpty() {
        return (numberElement == 0);
    }

    /**
     * Возвращает первый элемент очереди
     * Возвращает null если очередь пустая
     */
    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return arrayQueue[front];
    }

    @Override
    public String toString() {
        return "Queue{" +
                "arrayQueue=" + (arrayQueue == null ? null : Arrays.asList(arrayQueue)) +
                '}';
    }
}
