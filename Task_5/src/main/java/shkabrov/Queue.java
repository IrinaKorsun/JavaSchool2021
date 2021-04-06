package shkabrov;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс реализует структуру данных - очередь.
 */
public class Queue {
    private int head;
    private int tail;
    private Object[] queueElements;
    private final int MAX_QUEUE_SIZE = 1024;

    /**
     * @param queueSize размер очереди
     * @throws QueueException неверно задан размер очереди
     */
    public Queue(int queueSize) throws QueueException {
        setQueueElements(queueSize);
    }

    /**
     * @param queueSize            размер очереди
     * @param defaultQueueElements элементы, которыми очередь инициализируется при ее создании
     * @throws QueueException переданы некорректные элементы для инициализации очереди или неверно задан размер очереди
     */
    public Queue(int queueSize, Object[] defaultQueueElements) throws QueueException {
        this(queueSize);
        setQueueElements(defaultQueueElements);
    }

    /**
     * @return все элементы очереди
     */
    public Object[] takeQueueElements() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueErrorCode.QUEUE_EMPTY);
        }
        int quantityNotEmptyElements = 0;
        for (Object currentQueueElement : queueElements) {
            if (currentQueueElement != null) {
                quantityNotEmptyElements++;
            }
        }
        Object[] outputArray = new Object[quantityNotEmptyElements];
        for (int i = 0, j = 0; i < queueElements.length; i++) {
            if (queueElements[i] != null) {
                outputArray[j] = queueElements[i];
                j++;
            }
        }
        return outputArray;
    }

    private void setQueueElements(int queueSize) throws QueueException {
        if (queueSize > MAX_QUEUE_SIZE) {
            throw new QueueException(QueueErrorCode.QUEUE_MAX_SIZE_EXCEEDED);
        } else if (queueSize <= 0) {
            throw new QueueException(QueueErrorCode.QUEUE_INCORRECT_SIZE);
        }
        this.queueElements = new Object[queueSize];
        head = 0;
        tail = 0;
    }

    private void setQueueElements(Object[] defaultQueueElements) throws QueueException {
        if (queueElements.length < defaultQueueElements.length) {
            // Ошибка при инициализации очереди: превышено максимально возможное число элементов
            throw new QueueException(QueueErrorCode.QUEUE_INSUFFICIENT_SIZE);
        }
        if (defaultQueueElements.length == 0) {
            head = 0;
            tail = 0;
        } else {
            for (int i = 0; i < defaultQueueElements.length; i++) {
                if (defaultQueueElements[i] == null) {
                    throw new QueueException(QueueErrorCode.QUEUE_NULL_ELEMENT);
                } else {
                    setQueueElement(defaultQueueElements[i], i);
                }
            }
            head = 0;
            tail = defaultQueueElements.length - 1;
        }
    }

    private void setQueueElement(Object newQueueElement, int insertPosition) {
        this.queueElements[insertPosition] = newQueueElement;
    }

    /**
     * Добавляет элемент в очередь.
     *
     * @param newQueueElement новый элемент очереди
     * @throws QueueException в очередь заносится некорректный элемент или очередь переполнена
     */
    public void enQueue(Object newQueueElement) throws QueueException {
        if (newQueueElement == null) {
            throw new QueueException(QueueErrorCode.QUEUE_NULL_ELEMENT);
        }
        if (!isEmpty()) {
            if (tail == queueElements.length - 1) {
                if (head == 0) {
                    // Ошибка: очередь переполнена
                    throw new QueueException(QueueErrorCode.QUEUE_FULL);
                } else {
                    tail = 0;
                }
            } else if (tail + 1 == head) {
                throw new QueueException(QueueErrorCode.QUEUE_FULL);
            } else {
                tail = tail + 1;
            }
        }
        setQueueElement(newQueueElement, tail);
    }

    /**
     * Удаляет элемент из очереди.
     *
     * @throws QueueException извлекаются данные из пустой очереди
     */
    public void deQueue() throws QueueException {
        if (isEmpty()) {
            // Ошибка: очередь пуста, нечего извлекать
            throw new QueueException(QueueErrorCode.QUEUE_EMPTY);
        }
        setQueueElement(null, head);
        if (!isEmpty()) {
            if (head == queueElements.length - 1) {
                head = 0;
                while (queueElements[head] == null && head != tail) {
                    head = head + 1;
                }
            } else {
                head = head + 1;
            }
        }
    }

    /**
     * Проверяет наличие элементов в очереди.
     *
     * @return true, если очередь пуста. false, если в очереди еще есть элементы.
     */
    public boolean isEmpty() {
        return head == tail && queueElements[head] == null;
    }

    /**
     * @return первый элемент очереди
     * @throws QueueException берется первый элемент из пустой очереди
     */
    public Object top() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueErrorCode.QUEUE_EMPTY);
        }
        return queueElements[head];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return head == queue.head && tail == queue.tail && Arrays.equals(queueElements, queue.queueElements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(head, tail);
        result = 31 * result + Arrays.hashCode(queueElements);
        return result;
    }
}
