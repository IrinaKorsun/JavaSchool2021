package galuza;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListFiller {
    private List<Integer> integerList = new ArrayList<>();

    public void addToList() {
        Random random = new Random(1000);
        try {
            Thread.sleep(10);
            for (int i = 0; i < 1000; i++) {
                integerList.add(random.nextInt());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
