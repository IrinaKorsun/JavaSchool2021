package galuza;

import java.util.Arrays;
import java.util.Objects;

public class ArtisanalStack {
    private final int CAPACITY = 1000;
    private final Object[] elements = new Object[CAPACITY];
    private int count = 0;

    public ArtisanalStack() {
    }

    /**
     * вставляет элемент сверху и возвращвет его; если превышен размер стека, выбрасывается исключение STACK_OVERFLOW
     * @param object
     * @return object
     * @throws ArtisanalException
     */
    public Object push(Object object) throws ArtisanalException {
        if (count == elements.length) {
            throw new ArtisanalException(ArtisanalErrorCode.STACK_OVERFLOW);
        }
        elements[count] = object;
        count++;
        return object;
    }

    /**
     * возвращает верхний элемент после удаления из стека; если стек пуст выбрасывается исключение STACK_IS_EMPTY
     * @return object
     * @throws ArtisanalException
     */
    public Object pop() throws ArtisanalException {
        Object result = top();
        elements[count - 1] = null;
        count--;
        return result;
    }

    /**
     * возвращает верхний элемент без удаления из стека; если стек пуст выбрасывается исключение STACK_IS_EMPTY
     * @return object
     * @throws ArtisanalException
     */
    public Object top() throws ArtisanalException {
        if (!isEmpty()) {
            Object result = elements[count - 1];
            return result;
        } else {
            throw new ArtisanalException(ArtisanalErrorCode.STACK_IS_EMPTY);
        }
    }

    /**
     *
     * @return true, если стек пуст
     */
    public boolean isEmpty() {
        return elements[0] == null;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public Object[] getElements() {
        return elements;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtisanalStack that = (ArtisanalStack) o;
        return CAPACITY == that.CAPACITY && count == that.count && Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(CAPACITY, count);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}
