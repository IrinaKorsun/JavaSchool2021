package pelipenko;

import java.util.Arrays;

public class Stack {
    private Object[] stackArray;
    private int sSize = 0;
    private static final int MAX_CAPACITY = 1000;
    private static final int INITIAL_CAPACITY = 16;

    public Stack() {
        stackArray = new Object[INITIAL_CAPACITY];
    }

    public Stack(int capacity) {
        if (capacity >= 0 && capacity <= MAX_CAPACITY)
            stackArray = new Object[capacity];
        else throw new IllegalArgumentException("Размер стека должен быть от 0 до " + MAX_CAPACITY);
    }

    /**
     * Метод добавляет новый элемент в стек. Метод <code>{@link #extendArray()}</> расширяет массив,
     * для избежаения переполнения
     * @param element добавляемый элемент
     */
    public void push(Object element) throws Exception {
            if (sSize == MAX_CAPACITY)
                throw new Exception("Стек переполнен");

        extendArray();
        stackArray[sSize++] = element;
    }

    /**
     * Возвращает верхний элемент после удаления из
     * стека
     * @return удаленный элемент, в случае пустого стека - null
     */
    public Object pop() {
        if (sSize == 0) {
            return null;
        }
        Object result = stackArray[--sSize];
        stackArray[sSize] = null;
        return result;
    }

    /**
     * Проверка наличия элментов в стеке
     * @return true в случает пустого стека, в ином случае - false
     */
    public boolean isEmpty() {
        return sSize == 0;
    }

    /**
     * Возвращает верхний элемент стека без удаления
     * @return верхний элемент стека, в ином случае - null
     */
    public Object top() {
        return sSize == 0 ? null : stackArray[sSize - 1];
    }

    /**
     * Метод расширения стека
     */
    private void extendArray() {
        if (stackArray.length == sSize) {
            stackArray = Arrays.copyOf(stackArray, 2 * sSize + 1);
        }
    }
}

