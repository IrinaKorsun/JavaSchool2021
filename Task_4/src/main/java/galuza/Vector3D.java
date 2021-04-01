package galuza;

import java.util.Arrays;
import java.util.Objects;

public class Vector3D {
    private final double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double absValue() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProd(Vector3D vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    public Vector3D vectorProd(Vector3D vector) {
        return new Vector3D(
                this.y * vector.z - this.z * vector.y,
                this.z * vector.x - this.x * vector.z,
                this.x * vector.y - this.y * vector.x
        );
    }

    public double angle(Vector3D vector, String typeOfResult) {
        double result = 0;
        double ang = Math.acos(scalarProd(vector) / (this.absValue() * vector.absValue()));

        if (typeOfResult.equals("rad"))
            result = ang;
        else if (typeOfResult.equals("grad"))
            result = ang * 180 / Math.PI;
        else {
            System.out.println("Wrong type of result.");
        }
        return result;
    }

    public Vector3D sum(Vector3D vector) {
        return new Vector3D(
                this.x + vector.x,
                this.y + vector.y,
                this.z + vector.z
        );
    }

    public Vector3D diff(Vector3D vector) {
        return new Vector3D(
                this.x - vector.x,
                this.y - vector.y,
                this.z - vector.z
        );
    }

    public Vector3D[] randomVectors(int quantity) {
        Vector3D[] result = new Vector3D[quantity];

        for (int i = 0; i < result.length; i++) {
            result[i] = new Vector3D(Math.random(), Math.random(), Math.random());;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(new double[] { x, y ,z });
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Double.compare(vector3D.x, x) == 0 && Double.compare(vector3D.y, y) == 0 && Double.compare(vector3D.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
