package galuza;

public class RandomList extends Thread {
    private ListFiller filler;

    public RandomList(ListFiller filler) {
        this.filler = filler;
    }

    @Override
    public void run() {
        filler.addToList();
    }
}
