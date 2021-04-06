package shkabrov;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс реализует структуру данных - стек.
 */
public class Stack {
    private int top;
    private Object[] stackElements;
    private final int MAX_STACK_SIZE = 256;

    /**
     * @param stackSize размер стека
     * @throws StackException неверно задан размер стека
     */
    public Stack(int stackSize) throws StackException {
        setStackElements(stackSize);
    }

    /**
     * @param stackSize            размер стека
     * @param defaultStackElements элементы, которыми стек инициализируется при его создании
     * @throws StackException переданы некорректные элементы для инициализации стека или неверно задан размер стека
     */
    public Stack(int stackSize, Object[] defaultStackElements) throws StackException {
        this(stackSize);
        setStackElements(defaultStackElements);
    }

    /**
     * @return все элементы стека
     */
    public Object[] takeStackElements() throws StackException {
        if (isEmpty()) {
            throw new StackException(StackErrorCode.STACK_EMPTY);
        }
        Object[] outputArray = new Object[top + 1];
        System.arraycopy(stackElements, 0, outputArray, 0, top + 1);
        return outputArray;
    }

    private void setStackElements(int stackSize) throws StackException {
        if (stackSize > MAX_STACK_SIZE) {
            throw new StackException(StackErrorCode.STACK_MAX_SIZE_EXCEEDED);
        } else if (stackSize <= 0) {
            throw new StackException(StackErrorCode.STACK_INCORRECT_SIZE);
        }
        this.stackElements = new Object[stackSize];
        top = 0;
    }

    private void setStackElements(Object[] defaultStackElements) throws StackException {
        if (stackElements.length < defaultStackElements.length) {
            // Ошибка при инициализации стека: превышено максимально возможное число элементов
            throw new StackException(StackErrorCode.STACK_INSUFFICIENT_SIZE);
        }
        if (defaultStackElements.length == 0) {
            top = 0;
        } else {
            for (int i = 0; i < defaultStackElements.length; i++) {
                if (defaultStackElements[i] == null) {
                    throw new StackException(StackErrorCode.STACK_NULL_ELEMENT);
                } else {
                    setStackElement(defaultStackElements[i], i);
                }
            }
            top = defaultStackElements.length - 1;
        }
    }

    private void setStackElement(Object newStackElement, int insertPosition) {
        this.stackElements[insertPosition] = newStackElement;
    }

    /**
     * Добавляет элемент в стек.
     *
     * @param newStackElement новый элемент стека
     * @throws StackException в стек заносится некорректный элемент или стек переполнен
     */
    public void push(Object newStackElement) throws StackException {
        if (newStackElement == null) {
            throw new StackException(StackErrorCode.STACK_NULL_ELEMENT);
        }
        if (top == (stackElements.length - 1)) {
            // Ошибка: стек переполнен
            throw new StackException(StackErrorCode.STACK_FULL);
        }
        if (!isEmpty()) {
            top = top + 1;
        }
        setStackElement(newStackElement, top);
    }

    /**
     * Извлекает и удаляет верхний элемент из стека
     * @return верхний элемент стека
     * @throws StackException извлекаются данные из пустого стека
     */
    public Object pop() throws StackException {
        if (isEmpty()) {
            // Ошибка: стек пуст, нечего извлекать
            throw new StackException(StackErrorCode.STACK_EMPTY);
        }
        Object outputStackElement = stackElements[top];
        setStackElement(null, top);
        if (top != 0) {
            top = top - 1;
        }
        return outputStackElement;
    }

    /**
     * Проверяет наличие элементов в стеке.
     *
     * @return true, если стек пуст. false, если в стеке еще есть элементы.
     */
    public boolean isEmpty() {
        return top == 0 && stackElements[top] == null;
    }

    /**
     * @return верхний элемент стека
     * @throws StackException берется верхний элемент из пустого стека
     */
    public Object top() throws StackException {
        if (isEmpty()) {
            throw new StackException(StackErrorCode.STACK_EMPTY);
        }
        return stackElements[top];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack = (Stack) o;
        return top == stack.top && Arrays.equals(stackElements, stack.stackElements);

    }

    @Override
    public int hashCode() {
        int result = Objects.hash(top);
        result = 31 * result + Arrays.hashCode(stackElements);
        return result;
    }
}
