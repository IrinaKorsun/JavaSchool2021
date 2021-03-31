package prikhozhaya;

import java.util.OptionalDouble;

public class Stack {
    private Object array[];
    private int maxSize; // максимальное количество элементов
    private int quantity;  // текущее количество элементов
    private int rear; //ID последнего элеиента в массиве

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        rear = -1;
        quantity = 0;
    }

    public Object[] getArray() {
        return array;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRear() {
        return rear;
    }

    /*
     *Вставляет элемент сверху.
     *
     * Метод получает значение нового элемента, после чего добавляет его
     * в стек.
     * Размер стека фиксирован (задается пользователем).
     * Если случается переполнение, возвращается ошибка "Стек переполнен".
     *
     * @param element - потенциальный представитель стека.
     *
     */
    public void push(Object element) {
        if (quantity == maxSize) {
            throw new RuntimeException("Стек переполнен");
        }
        rear++;
        quantity++;
        array[rear] = element;
    }

    /*
     *Возвращает верхний элемент после удаления из стека.
     *
     * Mетод удаляет последний добавленный в стек элемент и
     * возвращает его значение.
     *
     * @return element - значение верхнего элемента в стеке.
     *
     */
    public Object pop() {
        Object element = null;
        if (!isEmpty()) {
            element = array[rear];
            array[rear] = null;
            quantity--;
            if (rear != 0) {
                rear--;
            }
        }
        return element;
    }

    /*
     *Возвращает true, если стек пуст.
     *
     * Метод осуществляет проверку стека на наличие элементов в нем.
     *
     */
    public boolean isEmpty() {
        return quantity == 0;
    }

    /*
     * Возвращает верхний элемент без удаления из стека.
     *
     *Данный метод находит последний добавленный в стек элемент
     *и возвращает его значение, не удаляя его при этом. Если
     * стек пуст, метод возвращает NULL.
     *
     * @return element - верхний элемент cтека.
     *
     */
    public Object top() {
        Object element = null;
        if (!isEmpty()) {
            element = array[rear];
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (!isEmpty()) {
            for (Object a : array) {
                if (a != null) {
                    str.append(a).append(" ");
                }
            }
        }
        return str.toString();
    }
}
