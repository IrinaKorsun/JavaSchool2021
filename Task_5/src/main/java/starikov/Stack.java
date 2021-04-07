package starikov;

public class Stack {
    private Object[] stack;
    private int index = -1;

    public Stack(int stackSize) {
        this.stack = new Object[stackSize];
    }

    public Object[] getStack() {
        return stack;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Добавляет объект на вершину стека. Если стек заполнен, генерирует RuntimeException();
     *
     * @param object объект для размещения в стеке
     */
    public void push(Object object) {
        if (index == stack.length - 1) {
            throw new StackAndQueueException("Cannot add an item to the stack: the stack is full.");
        }
        if (object != null) {
            index++;
            stack[index] = object;
        }
    }

    /**
     * Проверяет, является ли стек пустым.
     *
     * @return true - если стек пуст, false - если стек не пуст.
     */
    public boolean isEmpty() {
        return index == -1;
    }

    /**
     * Получает объект, находящийся на вершине стека, без удаления его из стека. Если стек пуст, генерирует RuntimeException();
     *
     * @return Элемент, находящийся на вершине стека
     */
    public Object top() {
        if (isEmpty()) {
            throw new StackAndQueueException("Cannot get an item from the stack: the stack is empty.");
        }
        return stack[index];
    }

    /**
     * Получает объект, находящийся на вершине стека, удаляя его из стека. Если стек пуст, генерирует RuntimeException();
     *
     * @return объект, находящийся на вершине стека
     */
    public Object pop() {
        Object item = top();
        stack[index] = null;
        index--;
        return item;
    }
}
