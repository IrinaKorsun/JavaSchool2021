package my;

public class Track implements Comparable<Track> {
    private String name;

    public Track(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Track o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                '}';
    }
}
