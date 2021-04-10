package galuza;

import java.util.Arrays;
import java.util.Objects;

public class ArtisanalQueue {
    private int capacity = 1000;
    private Object[] elements = new Object[capacity];
    private int count = 0;

    public ArtisanalQueue() {
    }

    /**
     * @return элемент из начала очереди с его удалением
     * @throws ArtisanalException
     */
    public Object deQueue() throws ArtisanalException {
        Object result;
        if (!isEmpty()) {
            result = elements[0];

            for (int i = 0; i < count; i++) {
                elements[i] = elements[i + 1];
            }
            elements[count] = null;
            count--;
        } else throw new ArtisanalException(ArtisanalErrorCode.QUEUE_IS_EMPTY);
        return result;
    }

    /**
     * вставляет элемент в конец очереди, если количество элементов превысит ёмкость, то произойдёт её увеличение на 500
     * @param object
     */
    public void enQueue(Object object) {
        if (count == capacity) {
            int newCapacity = capacity + 500;
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < capacity; i++) {
                newElements[i] = elements[i];
            }
            setElements(newElements);
            setCapacity(newCapacity);
        }
        elements[count] = object;
        count++;
    }

    /**
     * @return true если очередь пуста
     */
    public boolean isEmpty() {
        return elements[0] == null;
    }

    /**
     *
     * @return возвращает первый элемент очереди без удаления
     * @throws ArtisanalException
     */
    public Object top() throws ArtisanalException {
        if (!isEmpty())
            return elements[0];
        else throw new ArtisanalException(ArtisanalErrorCode.NO_SUCH_ELEMENT_EXCEPTION);
    }

    public int getCapacity() {
        return capacity;
    }

    public Object[] getElements() {
        return elements;
    }

    public int getCount() {
        return count;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtisanalQueue queue = (ArtisanalQueue) o;
        return capacity == queue.capacity && count == queue.count && Arrays.equals(elements, queue.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, count);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}
