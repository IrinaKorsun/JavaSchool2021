package manafov;

import java.util.Arrays;

public class Queue {
    private Object[] elements;
    private int size = 0;
    private static final int MAX_CAPACITY = 1000;
    private static final int DEFAULT_CAPACITY = 16;

    public Queue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Queue(int initialCapacity) {
        if (initialCapacity >= 0 && initialCapacity <= MAX_CAPACITY)
            elements = new Object[initialCapacity];
        else throw new IllegalArgumentException("Размер очереди должен быть от 0 до " + MAX_CAPACITY);
    }

    /**
     * Добавляет элемент в конец очереди. Сначала вызывается <code>{@link #ensureCapacity()}</code>, чтобы избежать
     * выхода за пределы границ массива, затем элемент добавляется в массив.
     *
     * @param e добавляемый элемент.
     */
    public void enqueue(Object e) {
        if (size == MAX_CAPACITY)
            throw new IllegalStateException("Очередь переполнена!");

        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * Удаляет элемент из начала очереди.
     *
     * @return удаленный элемент, если очередь не пуста, null - в противном случае.
     */
    public Object dequeue() {
        if (size == 0)
            return null;

        Object result = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return result;
    }

    /**
     * Проверяет, пуста ли очередь.
     *
     * @return true, если очередь пуста, false - в противном случае.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает первый элемент очереди без его удаления.
     *
     * @return первый элемент очереди.
     */
    public Object top() {
        return elements[0];
    }

    /**
     * Создает копию массива <code>elements</code> размером <code>2 * size + 1</code>, если массив переполнен.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
