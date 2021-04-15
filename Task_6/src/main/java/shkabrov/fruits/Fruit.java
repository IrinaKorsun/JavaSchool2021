package shkabrov.fruits;

/**
 * Фрукт
 */
public abstract class Fruit {
    protected final Color color;
    protected final Taste taste;

    protected Fruit(Color color, Taste taste) {
        this.color = color;
        this.taste = taste;
    }

    public Color getColor() {
        return color;
    }

    public Taste getTaste() {
        return taste;
    }
}
