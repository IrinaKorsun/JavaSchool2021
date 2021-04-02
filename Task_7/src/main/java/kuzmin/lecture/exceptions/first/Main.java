package kuzmin.lecture.exceptions.first;

public class Main {
    public static void main(String[] args) {
        try {
            Stack stack = new Stack(10);
            stack.push(1);
            stack.push(1);
        } catch (Exception e) {
            System.out.println("Ошибка при попытке вставки элемента в стек " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            sayGoodbye();
        }
    }

    public static void sayGoodbye() {
        System.out.println("good bye!");
    }
}
