package Volodin;

public class Stack {
    private int mSize;
    private Object[] stackArray;
    private int top;

    /**
     * Конструктор создания стэка и указания его размера
     * @param m
     */
    public Stack (int m) {
        this.mSize = m;
        stackArray = new Object[mSize];
        top = -1;
    }

    /**
     * Метод вставляет элемент сверху
     * @param element
     */
    public void push (Object element) {
        stackArray[++top] = element;
    }

    /**
     * Метод возвращает top элемент после удаления из стэка
     * @return
     */
    public Object pop () {
        return stackArray[--top];
    }

    /**
     * Метод возвращает true если стэк пуст
     * @return
     */
    public Object top () {
        return stackArray[top];
    }

    /**
     * Метод возвращает top элемент без удаления
     * @return
     */
    public boolean isEmpty () {
        return(top == -1);
    }
}
