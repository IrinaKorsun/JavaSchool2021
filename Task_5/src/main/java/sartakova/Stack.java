package sartakova;

import java.util.Arrays;
import java.util.Objects;

public class Stack {
    private final static int MAX_NUMBER_STACK = 10;// максимальное количество элементов
    private Object array[] = new Object[MAX_NUMBER_STACK];
    private int current_number = 0;  // текущее количество элементов
    private int last_element = -1; //номер последнего элемента в массиве

    public Stack() {
    }

    public Object[] getArray() {
        return array;
    }

    public int getCurrent() {
        return current_number;
    }

    public int getLast() {
        return last_element;
    }

    // Вставка элемента сверху в стек
    public void push(Object element) throws Exception {
        if (current_number == MAX_NUMBER_STACK) {
            throw new Exception("Ошибка! Стек переполнен");
        }
        last_element++;
        current_number++;
        array[last_element] = element;
    }

    //Возвращение верхнего элемента после удаления из стека

    public Object pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Ошибка! Стек пуст");
        }
        Object element = array[last_element];
        array[last_element] = null;
        current_number--;
        if (last_element != 0) {
            last_element--;
        }
        return element;
    }

    // Проверка стека на наличие элементов в нем
    public boolean isEmpty() {
        return (current_number == 0);
    }

    //Возвращение верхнего элемента без удаления из стека
    public Object top() {
        Object element = null;
        if (!isEmpty()) {
            element = array[last_element];
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder el = new StringBuilder();
        if (!isEmpty()) {
            for (int i = 0; i < MAX_NUMBER_STACK; i++){
                if (array[i] != null) {
                    if (i != 0) {
                        el.append("; ");
                    }
                    el.append(array[i]);
                }
            }
        }
        return el.toString();
    }
}

