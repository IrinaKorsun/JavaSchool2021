package prikhozhaya;

public class Stack {
    private final static int STACK_MAX_SIZE = 5;// максимальное количество элементов
    private Object array[] = new Object[STACK_MAX_SIZE];
    private int quantity = 0;  // текущее количество элементов
    private int rear = -1; //ID последнего элемента в массиве

    public Stack() {
    }

    public Object[] getArray() {
        return array;
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
    public void push(Object element) throws Exception {
        if (quantity == STACK_MAX_SIZE) {
            throw new Exception("Стек переполнен");
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
    public Object pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Стек пуст");
        }
        Object element = array[rear];
        array[rear] = null;
        quantity--;
        if (rear != 0) {
            rear--;
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
        return (quantity == 0);
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
        StringBuilder el = new StringBuilder();
        if (!isEmpty()) {
            for (int i = 0; i < STACK_MAX_SIZE; i++){
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
