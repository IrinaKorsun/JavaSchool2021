package bakunov;

public class Task4 {
    public static void main(String[] args) {
        Vektor vektor1 = new Vektor(3, 5, 6);
        Vektor vektor2 = new Vektor(1, 7, 9);

        System.out.println("Длинна вектора1 = " + vektor1.getLength());
        System.out.println("Длинна вектора2 = " + vektor2.getLength());
        System.out.println("Скалярное произведение векторов = " + vektor1.getInnerProduct(vektor2));
        System.out.println("Векторное произедение векторов = " + vektor1.getCrossProduct(vektor2).toString());
        System.out.println("Косинус угла между векторами = " + vektor1.getCos(vektor2));
        System.out.println("Сумма векторов = " + vektor1.getSum(vektor2).toString());
        System.out.println("Разница векторов = " + vektor1.getDiff(vektor2).toString());
        for (Vektor vektor : Vektor.getMassVector(10)){
            System.out.println("Рандомный вектор: " + vektor.toString());
        }


    }
}
