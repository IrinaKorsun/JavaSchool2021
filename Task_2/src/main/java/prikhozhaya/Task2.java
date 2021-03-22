package prikhozhaya;
/**На лекции мы изучали классы и их методы, поэтому данное задние я решила выполнить так, надеюсь, правильно**/
public class HelloWorld {
    public static void main(String[] args) {

        double[] array = new double[7];
        for (int i = 0; i < array.length ; i++){
            array[i] = Math.random();
        }

        ArrayNum a = new ArrayNum();
        a.setArrayNum(array);

        System.out.print("array = {");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length-1)
                System.out.print(", ");
        }
        System.out.print("}");
        System.out.println();
        System.out.println("max = " + a.max());
        System.out.println("min = " + a.min());
        System.out.println("avg = " + a.avg());


    }
}
