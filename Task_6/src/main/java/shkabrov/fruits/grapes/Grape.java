package shkabrov.fruits.grapes;

import shkabrov.fruits.Color;
import shkabrov.fruits.Fruit;
import shkabrov.fruits.Taste;

/**
 * Виноград
 */
public abstract class Grape extends Fruit {
    // В данной реализации выделять этот класс нет особого смысла, но в теории у винограда
    // есть отличительные черты, которые веделяют его на фоне других фрутов.
    protected Grape(Color color, Taste taste) {
        super(color, taste);
    }
}
