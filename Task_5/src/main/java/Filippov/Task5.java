package Filippov;

public class Task5 {

    public static void main(String[] args) {
        long startMemoryUse = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println("Всего памяти (kb): " + Runtime.getRuntime().totalMemory()/1000 + "  Свободной памяти (kb): " + Runtime.getRuntime().freeMemory()/1000 + " Используется (kb): " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000);

        Stack stack = new Stack();

        double arrFiller = 999_999_999;
        System.out.println("Заполняем...");
        for (int i = 0; i < 100_000; i++) {
            stack.enqueue(arrFiller - 1);
        }
        System.out.println("Всего памяти (kb): " + Runtime.getRuntime().totalMemory()/1000 + "  Свободной памяти (kb): " + Runtime.getRuntime().freeMemory()/1000 + " Используется (kb): " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - startMemoryUse)/1000);
        System.out.println("Длина массива: " + stack.arr.length);
        System.out.println("Удаляем...");

        long m = System.nanoTime();


//  ***** Удаляем через присвоение null позиции массива без уменьшения размера массива
//        for (int i = 0; i<100_000; i++) {
//            stack.arr[i] = null;
//        }

//  ***** Удаляем через перезапись всего массива сокращая его размер на единицу
        for (int i = 0; i<100_000; i++) {
            stack.dequeue();
        }

        System.out.println("Время удаления (ms): " +  (System.nanoTime()-m)/1000);

        System.out.println("Удалили.");
        Runtime.getRuntime().gc();
        System.out.println("Длина массива: " + stack.arr.length);
        System.out.println("Всего памяти (kb): " + Runtime.getRuntime().totalMemory()/1000 + "  Свободной памяти (kb): " + Runtime.getRuntime().freeMemory()/1000 + " Используется (kb): " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - startMemoryUse)/1000);

    }
}
