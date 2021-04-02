package lesnoy;

public class Stack {
    private final Object[] stack;
    private int qtyElem;
    private final int indexTop;
    private int indexLast;

    public Stack(int maxSize) {
        stack = new Object[maxSize];
        indexTop = 0;
        indexLast = -1;
        qtyElem = 0;
    }

    /**
     * Данный метод добавляет элемент в стек
     *
     * @param elem - объект для добавления.
     */
    public void push(Object elem) throws Exception {
        if (indexLast + 1 < stack.length) {
            stack[indexLast + 1] = elem;
            qtyElem++;
            indexLast++;
        } else {
            throw new Exception("Место в стеке закончилось!");
        }
    }

    /**
     * Данный метод возвращает верхний элемент после удаления из
     * стека
     *
     * @return Object temp из начала очереди.
     */
    public Object pop() {
        try {
            Object temp = stack[indexTop];
            for (int i = 0; i < indexLast + 1; i++) {
                stack[i] = stack[i + 1];
            }
            indexLast--;
            qtyElem--;
            return temp;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Данный метод проверяет, пуст ли стек
     *
     * @return Boolean (true) - если стек пуст.
     */
    public boolean isEmpty() {
        return (qtyElem == 0);
    }

    /**
     * Данный метод возвращает первый элемент стека
     *
     * @return Object из начала стека.
     */
    public Object top() {
        return stack[indexLast + 1];
    }
}
