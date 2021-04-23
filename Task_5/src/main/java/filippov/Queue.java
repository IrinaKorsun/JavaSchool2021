package filippov;

import java.util.Arrays;

/**
 * Класс Queue, реализующий очередь.
 * При достижении currentPosition значения queueSize,
 * queueSize увеличивается на 100 - это эмирически проверенный быстрый метод.
 * При удалении элементов в начале очереди, нижняя граница окна (lowPosition) инкрементируется,
 * при увеличении пустого пространства в начале массива до 1/10 от его длины, пустой сегмент массива удаляется.
 *
 * @version 1.0
 */

public class Queue {
    private static final int QUEUE_MAX_SIZE = 2_000_000;
    private int lowPosition;                  //левый элемент обрабатываемого окна
    private int currentPosition;              //текущий (правый) обрабатываемый элемент
    private int queueSize;            //правая граница массива-буфера
    private Object[] queueArray = new Object[1];

    /**
     * Добавление в очередь.
     * При заполнении очереди (currentPosition == queueSize),
     * queueSize увеличивается на 100 - эмирически проверенный быстрый способ.
     *
     * @param newElement Добавление в массив элемента типа Object
     * @throws QueueExceptionOversize Обработка исключения при переполнении массива, лимит - QUEUE_MAX_SIZE
     */

    public void enqueue(Object newElement) throws QueueExceptionOversize {
        if (currentPosition == QUEUE_MAX_SIZE) {
            throw new QueueExceptionOversize("Queue oversized!");
        }
        if (currentPosition == queueSize) {
            queueSize += (queueSize + 100);
            queueArray = Arrays.copyOf(queueArray, queueSize);
        }
        queueArray[currentPosition] = newElement;
        currentPosition++;
    }

    /**
     * Удаление элемента из очереди со смещением вправо левой границы окна обработки,
     * срабатывает только при налчии элементов в очереди
     * Если в начале очереди Null (ранее затертых) элементов 1/10 от размера всего массива, то они удаляются
     * и окно обработки сдвигается на ноль
     */
    public void dequeue() {
        if (!isEmpty()) {
            queueArray[lowPosition] = null;
            lowPosition++;
            if (lowPosition > queueSize / 10) {
                Object[] tempArray = new Object[currentPosition - lowPosition + 1];
                System.arraycopy(queueArray, lowPosition, tempArray, 0, currentPosition - lowPosition);
                queueArray = tempArray;
                currentPosition -= lowPosition;
                queueSize -= lowPosition;
                lowPosition = 0;
            }
        }
    }

    /**
     * Проверка наличия элементов в очереди
     *
     * @return true если очередь пуста
     */
    public boolean isEmpty() {
        return currentPosition == lowPosition;
    }

    /**
     * Первый элемент очереди
     *
     * @return возвращает первый элемент очереди типа Object либо null, при пустой очереди
     */
    public Object top() {
        if (isEmpty()) return null;
        return queueArray[lowPosition];
    }
}