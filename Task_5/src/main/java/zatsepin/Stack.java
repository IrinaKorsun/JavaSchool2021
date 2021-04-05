package zatsepin;

import java.util.Arrays;
import java.util.Objects;

/**
 * Resizable-array implementation of the Stack.
 * The size of the array has a limit of no more than 100000.
 * Adding null elements is not supported.
 *
 * @author Evgeny Zatsepin
 */
public class Stack {
    private static final int ARRAY_INITIAL_SIZE = 100;
    private static final int ARRAY_MAX_SIZE = 100000;
    private int topIndex;
    private Object[] array;

    /**
     * Constructs an empty stack with an initial capacity sufficient to hold 100 elements.
     */
    public Stack() {
        array = new Object[ARRAY_INITIAL_SIZE];
        topIndex = -1;
    }

    /**
     * Pushes an element at the top of the stack.
     *
     * @param element the element to push
     * @throws Exception if maximum stack size reached and it is impossible to insert an element
     * @throws NullPointerException if the specified element is null
     */
    public void push(Object element) throws Exception {
        Objects.requireNonNull(element);
        if (topIndex == array.length - 1) {
            if (array.length * 2 > ARRAY_MAX_SIZE) {
                throw new Exception("Maximum stack size reached!");
            }
            array = Arrays.copyOf(array, array.length * 2);
        }
        topIndex++;
        array[topIndex] = element;
    }

    /**
     * Pops an element from the stack.
     *
     * @return element from the top of the stack
     * @throws Exception if stack is empty and it is impossible to pop an element
     */
    public Object pop() throws Exception {
        if (topIndex == -1) {
            throw new Exception("Stack is empty!");
        }
        Object element = array[topIndex];
        array[topIndex] = null;
        topIndex--;
        return element;
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack contains no elements
     */
    public boolean isEmpty() {
        return topIndex == -1;
    }

    /**
     * Retrieves, but does not remove, the top element of the stack,
     * or returns null if this stack is empty.
     *
     * @return top element of the stack, or null if this stack is empty
     */
    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return array[topIndex];
    }
}
