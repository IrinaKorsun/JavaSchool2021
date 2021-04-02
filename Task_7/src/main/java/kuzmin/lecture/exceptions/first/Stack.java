package kuzmin.lecture.exceptions.first;

public class Stack {
    private static final int MAX_SIZE = 1;
    private final Object[] array;
    private int position;

    public Stack(int size) {
        if (size < 0) {

        }

        if (size > MAX_SIZE) {
            throw new IllegalArgumentException("Размер больше максимального");
        }
        this.array = new Object[size];
    }

    public void push(Object object) {
        if (position >= array.length) {
            if (position >= MAX_SIZE) {
                throw new RuntimeException("Превышен лимит стека! " + position);
            }

            // Нарастить стек и скопировать данные
        }

        position = position + 1;
        array[position] = object;

        try {
            writeToFile();
        } catch (Exception e) {
            // попробуем записать в другой файл

        }
    }

    private void writeToFile() {

    }

}
