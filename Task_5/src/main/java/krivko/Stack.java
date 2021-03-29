package krivko;

import java.util.Arrays;

/**
 * Задание 5.2
 * <br> Стек любых объектов
 * <br> С максимальным размером MAX_SIZE: {@value MAX_SIZE}
 * @author krivko
 * @version 1.5
 * @since 30.03.2021
 */
public class Stack {

    public static final int MAX_SIZE = 10_000;  // максимальный размер стека

    private Object[] arrayStack;    // массив объектов стека
    private int count;              // текущий элемент стека

    /**
     * Конструктор  по умолчанию
     * <br>Начальный размер массива стека равен 10
     */
    public Stack() {
        arrayStack = new Object[10];
        count = -1;
    }

    /**
     * 1. Вставляем элемент сверху в стек
     * @param object элемент помещаемый в стек
     * @throws RuntimeException         если размер стека превышает MAX_SIZE: {@value MAX_SIZE}
     * @throws IllegalArgumentException если аргумент равен null
     */
    public void push(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Invalid argument: null");
        }

        if (count + 2 > MAX_SIZE) {
            throw new RuntimeException("Stack size exceeds MAX_SIZE: " + MAX_SIZE);
        }
        // Если текуший массив стека мал, надо увеличивать его размер
        if (count + 2 > arrayStack.length) {
            // новый размер стека (смотрим, что бы он не привысил MAX_SIZE)
            int newSize = Math.min(arrayStack.length * 2, MAX_SIZE);
            arrayStack = Arrays.copyOf(arrayStack, newSize);
        }
        // добавляем новый элемент
        ++count;
        arrayStack[count] = object;
    }

    /**
     * 2. Возвращаем верхний элемент после удаления из стека
     * @return возвращает удаляемый элемент,
     * <br>если стек пуст, то возвращает null
     */
    public Object pop() {
        Object obj;
        if (isEmpty()) {
            obj = null;
        } else {
            obj = arrayStack[count];
            arrayStack[count] = null; // удаляем ссылку на объект
            count--;
        }
        return obj;
    }

    /**
     * 3. Возвращает значение true, если стек пустой
     */
    public boolean isEmpty() {
        return count == -1;
    }

    /**
     * 4. Возвращаем верхний элемент без удаления из стека
     * @return возвращает элемент,
     * если стек пуст, то возвращает null
     */
    public Object top() {
        return isEmpty() ? null : arrayStack[count];
    }

    /**
     * Сколько элементов в стеке
     */
    public int getCount() {
        return count + 1;
    }
}
