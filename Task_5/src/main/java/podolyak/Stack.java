package podolyak;


public class Stack {
    private final Object[] arrayStack;
    private int pointer;
    private final int maxSize;

    public Stack(int maxSize) {
        this.arrayStack = new Object[maxSize];
        this.pointer = -1;
        this.maxSize = maxSize;
    }

    /**
     * Метод вставляет элемент сверху стека
     *
     * @param element - элемент для вставки
     * @throws Exception - если стек заполнен
     */
    public void push(Object element) throws Exception {
        if (pointer < maxSize) {
            pointer++;
            arrayStack[pointer] = element;
        } else {
            throw new Exception("Стек переполнен!");
        }
    }

    /**
     * Метод проверяет, пуст ли стек
     *
     * @return boolean true - стек пуст, false - стек непустой.
     */
    public boolean isEmpty() {
        return pointer == -1;
    }

    /**
     * Метод удаляет верхний элемент в стеке и возвращает его значение
     *
     * @return возвращает Object - удаленный элемент
     * @throws Exception - если стек пуст
     */
    public Object pop() throws Exception {
        Object object;
        if (isEmpty()) {
            throw new Exception("Стек пуст.");
        } else {
            object = arrayStack[pointer];
            arrayStack[pointer] = null;
            pointer--;
            return object;
        }
    }

    /**
     * Метод возвращает верхний элемент стека
     *
     * @return Object
     * @throws Exception - если стек пуст
     */
    public Object top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Стек пуст.");
        } else {
            return arrayStack[pointer];
        }
    }
}
