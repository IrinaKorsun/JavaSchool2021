package shkabrov.fruits.apples;

import shkabrov.fruits.Color;
import shkabrov.fruits.Fruit;
import shkabrov.fruits.Taste;

/**
 * Яблоко
 */
public abstract class Apple extends Fruit {
    // В данной реализации выделять этот класс нет особого смысла, но в теории у яблок
    // есть отличительные черты, которые веделяют их на фоне других фрутов.
    protected Apple(Color color, Taste taste) {
        super(color, taste);
    }
}
