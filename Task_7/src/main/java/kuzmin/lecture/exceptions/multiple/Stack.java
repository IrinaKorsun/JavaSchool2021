package kuzmin.lecture.exceptions.multiple;

public class Stack {
    private static final int MAX_SIZE = 1;
    private final Object[] array;
    private int position;

    public Stack(int size) {
        if (size > MAX_SIZE) {
            throw new IllegalArgumentException("size must be less then " + MAX_SIZE);
        }
        this.array = new Object[size];
    }

    public void push(Object object) throws Exception {
        if (position >= array.length) {
            if (position >= MAX_SIZE) {
                throw new Exception("Превышен лимит стека! " + position);
            }

            // Нарастить стек и скопировать данные
        }

        position = position + 1;
//        array[position] = object;
    }

}
