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
        return gamers[0];
    }

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame(new Gamer[]{new RandomGamer("Vasya"), new RandomGamer("Petya")});
        Gamer winner = game.startRound();
        System.out.println("winner " + winner);
    }

}

