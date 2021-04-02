package kuzmin.lecture.exceptions.multiple;

public class Main {
    public static void main(String[] args) {
        try {
            Stack stack = new Stack(1);
            stack.push(1);
            stack.push(1);
        } catch (IllegalArgumentException illegal) {
            System.out.println("Что то не так с передаваемыми параметрами " + illegal.getMessage());

        } catch (Exception e) {
            System.out.println("Ошибка при попытке вставки элемента в стек " + e.getMessage());
            e.printStackTrace();
        } finally {
            sayGoodbye();
        }
    }

    public static void sayGoodbye() {
        System.out.println("good bye!");
    }

    public static void askParametersAgain() {

    }
}
