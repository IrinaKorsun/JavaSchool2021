package emelyanov;

import java.util.Arrays;

public class Stack {
    /*
     * Переменная maxSize - максимальный размер стека
     * Переменная arrayStack массив элементов
     * Переменная top верхний элемент
     */
    private int maxSize;
    private Object[] arrayStack;
    private int top;

    /**
     * Конструктор стека
     *
     * @param maxSize - размер стека
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        arrayStack = new Object[maxSize];
        top = -1;
    }

    /**
     * Вставляет элемент сверху
     */
    public void push(Object element) {
        if (top == arrayStack.length - 1) {
            throw new IllegalStateException("Стек переполнен");
        } else {
            arrayStack[++top] = element;
        }
    }

    /**
     * Возвращает верхний элемент после удаления из стека
     * Возвращает null если очередь пустая
     */
    public Object pop() {
        Object object;
        if (top == 0) {
            return null;
        }
        object = arrayStack[top];
        arrayStack[top] = null;
        top--;
        return object;
    }

    /**
     * Возвращает верхний элемент без удаления из стека
     * Возвращает null если очередь пустая
     */
    public Object top() {
        if (isEmpty()){
            return null;
        }
        return arrayStack[top];
    }

    /**
     * Возвращает true, если стек пуст
     */
    public Boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "maxSize=" + maxSize +
                ", arrayStack=" + (arrayStack == null ? null : Arrays.asList(arrayStack)) +
                ", top=" + top +
                '}';
    }
}
