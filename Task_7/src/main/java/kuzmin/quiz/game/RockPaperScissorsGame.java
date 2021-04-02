package kuzmin.quiz.game;

public class RockPaperScissorsGame {
    private Gamer[] gamers;

    public RockPaperScissorsGame(Gamer[] gamers) {
        this.gamers = gamers;
    }

    /**
     * Начинает раунд игры
     * Возвращает победителя, null если ничья
     */
    public Gamer startRound() {
        System.out.println("Start");
        for (Gamer gamer : gamers) {
            Move move = gamer.getMove();
            if (best(move)) {
                return gamer;
            }
        }

        return null;
    }

    private boolean best(Move move) {
        return move == Move.ROCK;
    }

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame(new Gamer[]{new RandomGamer("Vasya"), new RandomGamer("Petya")});
        Gamer winner = game.startRound();
        System.out.println("winner " + winner);
    }

}

