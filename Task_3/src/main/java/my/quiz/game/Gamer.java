package my.quiz.game;

public abstract class Gamer {
    private final String name;

    public Gamer(String name) {
        this.name = name;
    }

    public abstract Move getMove();

    @Override
    public String toString() {
        return "I am " + name;
    }
}
