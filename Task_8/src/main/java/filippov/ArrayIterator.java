package filippov;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int posX = -1;
    private int posY;
    private final T[][] matrix;

    public ArrayIterator(T[][] matrix) {
        this.matrix = matrix;
    }


    /**
     * Переопределяем hasNext
     *
     * @return false во всех случаях, кроме наличия следующего элементы двумерного массива
     * catch пустой, чтобы вернуть false в случае exception
     */
    @Override
    public boolean hasNext() {
        boolean returnedData = false;
        try {
            returnedData = ((posX < matrix[posY].length - 1) | ((posX == matrix[posY].length - 1) & (posY < matrix.length - 1)));
        } catch (Exception e) {
        }
        return returnedData;
    }

    /**
     * Переопределеям next
     *
     * @return возвращает следующий элемент двумерного массива, получаем exception во всех прочих случаях
     */
    @Override
    public T next() {
        if ((posX == matrix[posY].length - 1) & (posY < matrix.length)) {
            posX = 0;
            posY++;
        } else if (posX < matrix[posY].length) {
            posX++;
        }
        return matrix[posY][posX];
    }
}