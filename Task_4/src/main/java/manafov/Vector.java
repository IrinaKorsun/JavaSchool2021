package manafov;

import java.util.Arrays;

public final class Vector {
    private final Double x;
    private final Double y;
    private final Double z;

    public Vector(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public Double scalar(Vector other) {
        return (this.x * other.x + this.y * other.y + this.z * other.z);
    }

    public Vector cross(Vector other) {
        return new Vector(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x);
    }

    public Double angleBetween(Vector other) {
        return Math.toDegrees(Math.acos(this.scalar(other) / (this.magnitude() * other.magnitude())));
    }

    public Vector addition(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector subtraction(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public static Vector[] arrayOfVectors(int N) {
        Vector[] array = new Vector[N];
        for (int i = 0; i < N; i++) {
            array[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return array;
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(1.0, 2.0, 5.0);
        Vector v2 = new Vector(2.0, 4.0, 1.0);
        System.out.println(v1.magnitude());
        System.out.println(v1.scalar(v2));
        System.out.println(v1.cross(v2));
        System.out.println(v1.angleBetween(v2));
        System.out.println(v1.addition(v2));
        System.out.println(v1.subtraction(v2));
        System.out.println(Arrays.toString(arrayOfVectors(3)));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
