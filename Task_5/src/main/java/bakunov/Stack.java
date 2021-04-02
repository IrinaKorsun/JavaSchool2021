package bakunov;

public class Stack {
    private final Object[] stack;
    private Object[] stackTemp;
    private int count;

    public Stack(int size) {
        stack = new Object[size];
        count = 0;
    }

    /**
     * Вставляет элемент сверху
     *
     * @param obj, объект для вставки в стек
     */
    public void push(Object obj) throws QueueStackException {
        if (count < stack.length - 1) {
            stack[count] = obj;
            count++;
        } else {
            throw new QueueStackException(ErrorCode.IS_FULL);
        }
    }

    /**
     * Возвращает верхний элемент после удаления из стека
     *
     * @return Object, верхний элемент из стека
     */
    public Object pop() {
        try {
            if (isEmpty()) {
                return null;
            } else {
                Object toReturn = stack[count - 1];
                if (stack.length > 2) {
                    for (int i = 0; i < count - 2; i++) {
                        stack[i] = stack[i + 1];
                    }
                    count--;
                } else {
                    stack[0] = null;
                    count = 0;
                }
                return toReturn;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Проверка стека на пустоту
     *
     * @return Boolean, true, если стек пуст
     */
    public Boolean isEmpty() {
        return count == 0;
    }

    /**
     * Возвращает верхний элемент из стека, без его удаления
     *
     * @return Object, верхний элемент из стека
     */
    public Object top() {
        if (!isEmpty()) {
            return stack[count - 1];
        }
        return null;
    }
}
