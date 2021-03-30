package manafov;

import java.util.Arrays;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int MAX_CAPACITY = 1000;
    private static final int DEFAULT_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Stack(int initialCapacity) {
        if (initialCapacity >= 0 && initialCapacity <= MAX_CAPACITY)
            elements = new Object[initialCapacity];
        else throw new IllegalArgumentException("Размер стека должен быть от 0 до " + MAX_CAPACITY);
    }

    /**
     * Добавляет элемент в стек. Сначала вызывается <code>{@link #ensureCapacity()}</code>, чтобы избежать выхода за
     * пределы границ массива, затем элемент добавляется в массив.
     *
     * @param e добавляемый элемент.
     */
    public void push(Object e) {
        if (size == MAX_CAPACITY)
            throw new StackOverflowError();

        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * Удаляет верхний элемент из стека и возвращает его.
     *
     * @return удаленный элемент, если стек не пуст, null - в противном случае.
     */
    public Object pop() {
        if (size == 0)
            return null;

        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * Проверяет, пуст ли стек.
     *
     * @return true, если стек пуст, false - в противном случае.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает верхний элемент стека без его удаления.
     *
     * @return верхний элемент стека, если стек не пуст, null - в противном случае.
     */
    public Object top() {
        return size == 0 ? null : elements[size - 1];
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
