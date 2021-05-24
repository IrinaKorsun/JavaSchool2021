package filippov;

import java.util.Date;

/**
 * Класс для измерения времени работы
 *
 */

public class MeasuringTime {

    private long startTime;
    private final Date date;

    public MeasuringTime() {
        date = new Date();
    }

    /**
     * Запускает отсчет времени
     */
    public void start() {
        startTime = date.getTime();
    }

    /**
     *
     * @return возвращает время работы
     */
    public double stop() {
        Date date = new Date();
        return (date.getTime() - startTime) * 0.001;
    }


}
