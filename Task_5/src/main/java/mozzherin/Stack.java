package mozzherin;

public class Stack {
    private final int MAX_ARRAY_SIZE = 1000;

    private Object[] array = new Object[MAX_ARRAY_SIZE];
    private int size = 0;

    /**
     * Метод добавляет элемент в Stack
     * @param element - добавляемый элемент
     * @return - возвращает true в случае успешного добавления
     * @throws QueueStackException
     */
    public boolean push(Object element) throws QueueStackException {
        if (size >= MAX_ARRAY_SIZE) {
            throw new QueueStackException(ErrorCode.IS_FULL);
        }
        array[size] = element;
        size++;
        return true;
    }

    /**
     *  Метод удаляет верхний элемент из Stack
     * @return - возвращает true в случае успешного удаления
     * @throws QueueStackException
     */
    public boolean pop() throws QueueStackException{
        if (size == 0) {
            throw new QueueStackException(ErrorCode.IS_EMPTY);
        }
        array[size] = null;
        size--;
        return true;
    }

    /**
     * Метод возвращает значение true/false в зависимости, от того является ли стек пустым
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /**
     * Метод возвращает верхний элемент из стека
     */
    public Object top() throws QueueStackException {
        if (size == 0) {
            throw new QueueStackException(ErrorCode.IS_EMPTY);
        }
        return array[size - 1];
    }

    /**
     * Метод возвращает размер стека
     * @return
     */
    public int getSize() {
        return size;
    }
}