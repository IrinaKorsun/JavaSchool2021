package sartakova;

import java.util.Arrays;
import java.util.Objects;

public class Queue {
    private final static int MAX_NUMBER_QUEUE = 10;// максимальное коли-во элементов в очереди
    private Object array[] = new Object[MAX_NUMBER_QUEUE];
    private int current_number = 0;  // текущее количество элементов
    private int first_element = 0; //номер первого элемента в массиве
    private int last_element = -1; //номер последнего элемента в массиве

    public Queue() {
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

    // Вставка элемента в конец очереди
    public void enqueue(Object elem) throws Exception {
        if (current_number == MAX_NUMBER_QUEUE) {
            throw new Exception("Ошибка! Очередь переполнена");
        }
        if (last_element == (MAX_NUMBER_QUEUE - 1)) {
            last_element = -1;
        }
        current_number++;
        array[++last_element] = elem;
    }

    // Удаление элемента из начала очереди
    public void dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Ошибка! Очередь пустая");
        }
        if (first_element == (MAX_NUMBER_QUEUE - 1)) {
            first_element = 0;
        }
        array[first_element] = null;
        current_number--;
        first_element++;
    }

    // Проверка очереди на наличие элементов в ней
    public boolean isEmpty() {
        return (current_number == 0);
    }

    // Возвращение первого элемента очереди
    public Object top() {
        Object el = null;
        if (!isEmpty()) {
            el = array[first_element];
        }
        return el;
    }

    @Override
    public String toString() {
        StringBuilder el = new StringBuilder();
        if (!isEmpty()) {
            for (int i = first_element; i < MAX_NUMBER_QUEUE; i++){
                if (array[i] != null) {
                    if (i != first_element) {
                        el.append("; ");
                    }
                    el.append(array[i]);
                }
            }
            if (first_element > last_element){
                for (int i = 0; i <= last_element; i++){
                    if (array[i] != null) {
                        el.append("; ");
                        el.append(array[i]);
                    }
                }
            }
        }
        return el.toString();
    }
}