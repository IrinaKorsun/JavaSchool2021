package zhmaylo;

/**
 * Класс stack, реализующий структуру данных "стек".
 *
 * @version 1.0
 * @autor Жмайло Василий
 */

public class Stack {
    /**
     * Переменная size: размер стека
     */
    private int size;
    /**
     * Переменная Stack: список элементов стека
     */
    private Object[] stack;
    /**
     * Переменная top: индекс верхнего элемента
     */
    private int top;

    /**
     * Переменная count: колличество элементов в стеке
     */
    private int count;

    /**
     * Переменная maxSize: максимальный размер стека
     */
    private static final int MAX_SIZE = 2000000;

    /**
     * Конструктор нового стека
     *
     * @param size - размер стека
     */
    public Stack(int size) {
        this.stack = new Object[size];
        this.top = -1;
        this.count = 0;
        this.size = size;
    }

    /**
     * Функция проверки пустоты стека
     *
     * @return возвращет true если стек пуст, false если есть элементы
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Процедура добавления элемента в стек
     *
     * @param element - добавляемый элемент.
     */
    public void push(Object element) throws IndexOutOfReserved {
        if (count + 1 == size) extend();
        if (count == MAX_SIZE) throw new IndexOutOfReserved("Stack is oversize!");
        top++;
        stack[top] = element;
        count++;
    }

    /**
     * Функция получения крайнего элемента стека с его удалением.
     *
     * @return возвращает крайний элемент стека, удаляя его, если стек пуст
     * возвращает null
     */
    public Object pop() {
        if (isEmpty()) return null;
        Object tempObj = stack[top];
        stack[top] = null;
        top--;
        count--;
        return tempObj;
    }

    /**
     * Функция получения крайнего элемента стека.
     *
     * @return возвращает крайний элемент стека, не удаляя его, если стек пуст
     * возвращает null
     */
    public Object top() {
        if (isEmpty()) return null;
        return stack[top];
    }

    private void extend() {
        Object[] temp = stack.clone();
        size *= 2;
        stack = new Object[size];
        System.arraycopy(temp, 0, stack, 0, count);
    }

    /**
     * Переопределение функции toString. Отображение элементов стека скрыто,
     * для информативного прохождения тестов
     */
    @Override
    public String toString() {
        return "Stack{" +
                "size=" + size +
                ", stack=" + "Content is hidden" + //for un hide: Arrays.toString(stack)
                ", top=" + top +
                '}';
    }
}
