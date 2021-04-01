package kuzmin.quiz.game;

import java.util.Random;

public class RandomGamer extends Gamer {
    private Random random = new Random();

    public RandomGamer(String name) {
        super(name);
    }

    @Override
    public Move getMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }
}
