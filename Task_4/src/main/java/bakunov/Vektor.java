package bakunov;

public class Vektor {
    private final int x;
    private final int y;
    private final int z;

    public Vektor(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    static Vektor[] getMassVector(int count) {
        Vektor[] vectors = new Vektor[count];
        for (int i = 0; i < count; i++) {
            vectors[i] = new Vektor((int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10));
        }
        return vectors;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getInnerProduct(Vektor vektor) { //скалярное произведение
        return x * vektor.getX() + y * vektor.y + z * vektor.getZ();
    }

    public Vektor getCrossProduct(Vektor vektor) { //векторное произведение
        return new Vektor(y * vektor.getZ() - z * vektor.getY(), z * vektor.x - x * vektor.getZ(), x * vektor.getY() - y * vektor.getX());
    }

    public Double getCos(Vektor vektor) {
        return getInnerProduct(vektor) / Math.abs(getLength() * vektor.getLength());

    }

    public Vektor getSum(Vektor vektor) {
        return new Vektor(x + vektor.x, y + vektor.y, z + vektor.z);
    }

    public Vektor getDiff(Vektor vektor) {
        return new Vektor(x - vektor.x, y - vektor.y, z - vektor.z);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "X: " + x + " Y: " + y + " Z: " + z;
    }
}
