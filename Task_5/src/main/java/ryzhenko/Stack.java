package ryzhenko;

public class Stack {

    private int size = 0; //Текущий размер стека
    private final static int MAX_SIZE = 100; //Максимальный размер стека
    private Object[] Array;

    public Stack() {
        this.Array = new Object[MAX_SIZE];
    }

    /**
     * Вставляет элемент сверху
     *
     * @param element Элемент стека
     * @throws Exception Если стек переполнен
     */
    public void push(Object element) throws Exception {
        if (size < MAX_SIZE) {
            Array[size] = element;
            size++;
        } else {
            throw new Exception("Stack is full!");
        }
    }

    /**
     * Возвращает верхний элемент после удаления из стека
     *
     * @return Элемент типа Object
     * @throws Exception Если стек пуст
     */
    public Object pop() throws Exception {
        Object result;
        if (!isEmpty()) {
            result = Array[size - 1];
            Array[size - 1] = null;
            size--;
            return result;
        } else {
            throw new Exception("Stack is empty!");
        }
    }

    /**
     * Возвращает true, если стек пуст
     *
     * @return true или false
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Возвращает верхний элемент без удаления из стека
     *
     * @return Элемент типа Object или null, если стек пуст
     */
    public Object top() {
        if (isEmpty()) {
            return null;
        } else {
            return Array[size - 1];
        }
    }
}