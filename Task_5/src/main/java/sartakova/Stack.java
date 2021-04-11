package sartakova;

public class Stack {
    private final Object[] stack;
    private int top;
    private int currentNumber;

    public Stack(int size) {
        stack = new Object[size];
        top = -1;
        currentNumber = 0;
    }

    public void push(Object element) throws Exception { //  Вставляет новый элемент в стек сверху
        if (currentNumber == stack.length) {
            throw new Exception("Ошибка! Стек переполнен");
        }
        stack[++top] = element;
        currentNumber++;
    }


    public Object pop() throws Exception { // Возвращает верхний элемент из стека и удаляет его
        if (isEmpty()) {
            throw new Exception("Ошибка! Стек пустой");
        }
        currentNumber--;
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
        return currentNumber;
    }
}