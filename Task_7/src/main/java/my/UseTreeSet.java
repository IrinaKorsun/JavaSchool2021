package my;

import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {

    public static void main(String[] args) {
        trackContainsExample();
    }

    public static void trackExample() {
        Set<Track> treeSet = new TreeSet<>();
        treeSet.add(new Track("banybanacy"));
        treeSet.add(new Track("lumen goret"));
        treeSet.add(new Track("kirkorov fire and water"));
        treeSet.add(new Track("dblock&stefan vodka"));

        for (Track track : treeSet) {
            System.out.println(track);
        }
    }

    public static void trackContainsExample() {
        Set<Track> treeSet = new TreeSet<>();
        treeSet.add(new Track("banybanacy"));
        treeSet.add(new Track("lumen goret"));
        treeSet.add(new Track("kirkorov fire and water"));
        treeSet.add(new Track("dblock&stefan vodka"));

        System.out.println(treeSet.contains(new Track("banybanacy")));
    }
}
