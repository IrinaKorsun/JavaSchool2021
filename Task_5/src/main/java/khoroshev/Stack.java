package khoroshev;

import java.util.Arrays;

public class Stack {
    private Object[] stack;
    private int size;
    private final int MAX_SIZE;

    /**
     * Конструктор, определяющий тип данных в стеке. Определяется максимальный размер стека,
     * равный длинне передаваемого массива.
     * @param stack массив из определенного типа данных.
     */
    public Stack(Object[] stack) {
        this.stack = stack;
        MAX_SIZE = stack.length;
    }

    /**
     * Конструктор, определяющий тип данных в стеке. Определяется максимальный размер стека в размере 10000.
     */
    public Stack() {
        stack = new Object[100];
        MAX_SIZE = 10000;
    }

    /**
     * Добавляем свержу стека элемент, если он не null.
     * При успешной вставке элемента size увеличивается на 1, а указатель перемещается на stack[head + 1];
     * @param object объект для вставки в стек.
     * @throws StackException если размер стека равен максимальному(стек переполнен)
     * или если пользователь хочет добавить null в стек.
     */
    public void push(Object object) throws StackException {
        if (object == null) {
            throw new StackException("Нельзя добавлять null в стек.");
        }
        if (size == MAX_SIZE) {
            throw new StackException("Превышен лимит стека.");
        }
        if (size + 1 > stack.length) {
            int newSize = Math.min(stack.length * 2, MAX_SIZE);
            stack = Arrays.copyOf(stack, newSize);
        }
        stack[size] = object;
        size++;

    }

    /**
     * Возвращаем верхний элемент стека, после его удаления.
     * @return верхний элемент стека, если стек не пустой.
     * @throws StackException если стек пустой.
     */
    public Object pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Стек пустой.");
        }
        size--;
        Object o = stack[size];
        stack[size] = null;
        return o;
    }

    /**
     * Проверка на пустоту стека.
     * @return true, если размер стека равен нулю.
     * false, если размер стека больше нуля.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращаем верхний элемент без удаления из стека.
     * @return верхний элемент стека, если стек не пустой.
     * @throws StackException если стек пустой.
     */
    public Object top() throws StackException {
        if (isEmpty()) {
            throw new StackException("Стек пустой.");
        }
        return stack[size - 1];
    }

    public int getSize() {
        return size;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
