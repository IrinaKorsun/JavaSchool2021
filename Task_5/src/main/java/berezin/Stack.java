package berezin;

public class Stack {

    /**
     * Массив объектов
     */
    private final Object[] array;

    /**
     * Указатель на верхний элемент стека
     */
    private int end;

    /**
     * Констуктор по размеру
     * @param size размер стека
     */
    public Stack(int size) {
        array = new Object[size];
        end = 0;
    }

    /**
     * Вставляет объект сверху
     * @throws QueueStackException если стек переполнен
     */
    public void push(Object value) throws QueueStackException {
        if (end == array.length) {
            throw new QueueStackException(ErrorCode.STACK_IS_FULL);
        }
        array[end] = value;
        end++;
    }

    /**
     * @return верхний элемент после удаления из стека
     * @throws QueueStackException если стек пустой
     */
    public Object pop() throws QueueStackException {
        if (end == 0) {
            throw new QueueStackException(ErrorCode.STACK_IS_EMPTY);
        }
        Object object = array[end - 1];
        array[end - 1] = null;
        end--;
        return object;
    }


    /**
     * @return true – если стек пуст, иначе – false
     */
    public boolean isEmpty() {
        return end == 0;
    }

    /**
     * @return верхний элемент без удаления из стека
     * @throws QueueStackException если стек пустой
     */
    public Object top() throws QueueStackException {
        if (end == 0) {
            throw new QueueStackException(ErrorCode.STACK_IS_EMPTY);
        }
        return array[end - 1];
    }

}
