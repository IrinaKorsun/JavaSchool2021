package zatsepin;

import java.util.Arrays;
import java.util.Objects;

/**
 * Resizable-array implementation of the Queue.
 * The size of the array has a limit of no more than 100000.
 * Adding null elements is not supported.
 *
 * @author Evgeny Zatsepin
 */
public class Queue {
    private static final int ARRAY_INITIAL_SIZE = 100;
    private static final int ARRAY_MAX_SIZE = 100000;
    private int rearIndex;
    private int elementsCount;
    private Object[] array;

    /**
     * Constructs an empty queue with an initial capacity sufficient to hold 100 elements.
     */
    public Queue() {
        array = new Object[ARRAY_INITIAL_SIZE];
        rearIndex = -1;
        elementsCount = 0;
    }

    /**
     * Adding an element at the end of the queue.
     *
     * @param element the element to add
     * @throws Exception if maximum queue size reached and it is impossible to insert an element
     * @throws NullPointerException if the specified element is null
     */
    public void enqueue(Object element) throws Exception {
        Objects.requireNonNull(element);
        if (rearIndex == array.length - 1) {
            if (array.length * 2 > ARRAY_MAX_SIZE) {
                throw new Exception("Maximum queue size reached!");
            }
            array = Arrays.copyOf(array, array.length * 2);
        }
        rearIndex++;
        array[rearIndex] = element;
        elementsCount++;
    }

    /**
     * Retrieves and removes an element from the front of the queue.
     *
     * @return element from the front of the queue
     * @throws Exception if queue is empty and it is impossible to retrieve an element
     */
    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        Object firstElement = array[0];
        for (int i = 0; i <= rearIndex; i++) {
            array[i] = array[i + 1];
        }
        elementsCount--;
        rearIndex--;
        return firstElement;
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue contains no elements
     */
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    /**
     * Retrieves, but does not remove, the first element of the queue,
     * or returns null if this queue is empty.
     *
     * @return first element of the queue, or null if this queue is empty
     */
    public Object top() {
        return array[0];
    }

}
