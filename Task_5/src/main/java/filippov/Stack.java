package filippov;

import java.util.Arrays;

/**
 * Класс Stack, реализующий структуру данных "стек".
 * При достижении currentPosition значения stackSize,
 * queueSize увеличивается на 100 - это эмирически проверенный быстрый метод.
 * при увеличении пустого пространства в конце массива до 500, пустой сегмент массива удаляется, оставляя буфер в 100.
 *
 * @version 1.0
 */

public class Stack {
    private static final int STACK_MAX_SIZE = 2_000_000; //Максимальный размер очереди
    int currentPosition = 0;                      //текущий (правый) обрабатываемый элемент
    int stackSize = 0;                            //правая граница массива-буфера
    Object[] stackArray = new Object[1];

    /**
     * Добавление в стек.
     * При заполнении стека (currentPosition == stackSize),
     * stackSize увеличивается на 100.
     *
     * @param newElement Добавление в массив элемента типа Object
     * @throws QueueExceptionOversize Обработка исключения при переполнении массива, лимит - STACK_MAX_SIZE
     */
    public void push(Object newElement) throws QueueExceptionOversize {
        if (currentPosition == STACK_MAX_SIZE)
            throw new QueueExceptionOversize("Stack oversized!");
        if (currentPosition == stackSize) {
            stackSize += (stackSize + 100);
            stackArray = Arrays.copyOf(stackArray, stackSize);
        }
        stackArray[currentPosition] = newElement;
        currentPosition++;
    }

    /**
     * Метод pop возвращает верхний элемент стека, удаляя его.
     * @return верхий элемент стека класс Object
     */
    public Object pop() {
        if (!isEmpty()) {
            currentPosition--;
            Object r = stackArray[currentPosition];
            stackArray[currentPosition] = null;
            if (currentPosition < (stackSize - 500)) {
                stackSize -= 400;
                stackSize = currentPosition;
                stackArray = Arrays.copyOf(stackArray, currentPosition);
            }
            return r;
        }
        return null;
    }

    /**
     * Метод top возвращает верхний элемент стека, НЕ удаляя его.
     * @return верхий элемент стека класс Object
     */
    public Object top() {
        if (isEmpty()) return null;
        return stackArray[currentPosition - 1];
    }

    /**
     * Проверка наличия элементов в стеке
     *
     * @return true если стек пуст
     */
    public boolean isEmpty() {
        return currentPosition == 0;
    }
}
