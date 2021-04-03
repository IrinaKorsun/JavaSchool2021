package shakina;

import shakina.exception.ErrorCode;
import shakina.exception.MyException;

public class MyStack {
    private final Object[] stack;
    private int top;
    private int currentSize;

    public MyStack(int size) {
        stack = new Object[size];
        top = -1;
        currentSize = 0;
    }


    /**
     * Вставляет новый элемент в стек сверху
     *
     * @param elem - новый элемент стека
     */
    public void push(Object elem) throws MyException {
        if (currentSize == stack.length) {
            throw new MyException(ErrorCode.FULL_STACK);
        }
        stack[++top] = elem;
        currentSize++;
    }


    /**
     * Возвращает верхний элемент из стека и удаляет его
     *
     * @return верхний элемент стека
     */
    public Object pop() throws MyException {
        if (isEmpty()) {
            throw new MyException(ErrorCode.EMPTY_STACK);
        }
        currentSize--;
        return stack[top--];
    }


    /**
     * Возвращает true, если стек пуст
     *
     * @return true или false
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * Возвращает верхний элемент без удаления из стека
     *
     * @return верхний элемент стека
     */
    public Object top() throws MyException {
        if (isEmpty()) {
            throw new MyException(ErrorCode.EMPTY_STACK);
        }
        return stack[top];
    }

    /**
     * Возвращает текущее количество элементов в стеке
     *
     * @return целое число элементов
     */
    public int getCurrentSize() {
        return currentSize;
    }
}
