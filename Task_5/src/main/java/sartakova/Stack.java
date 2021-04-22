package sartakova;

public class Stack {
    private final Object[] stack;
    private int top;
    private int current_number;

    public Stack(int size) {
        stack = new Object[size];
        top = -1;
        current_number = 0;
    }

    public void push(Object element) throws Exception { // Вставляет новый элемент в стек сверху
        if (current_number == stack.length) {
            throw new Exception("Ошибка!Стек переполнен");
        }
        stack[++top] = element;
        current_number++;
    }


    public Object pop() throws Exception { // Возвращает верхний элемент из стека и удаляет его
        if (isEmpty()) {
            throw new Exception("Ошибка!Стек пустой");
        }
        current_number--;
        return stack[top--];
    }


    public boolean isEmpty() { // Возвращает true, если стек пуст
        return top == -1;
    }

    public Object top() throws Exception { // Возвращает верхний элемент без удаления из стека
        if (isEmpty()) {
            throw new Exception("Ошибка! Стек пустой");
        }
        return stack[top];
    }


    public int getCurrentNumber() { // Возвращает текущее количество элементов в стеке
        return current_number;
    }
}