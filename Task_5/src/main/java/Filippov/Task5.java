package Filippov;

import javax.sound.midi.Soundbank;
import java.lang.instrument.Instrumentation;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.temporal.ChronoUnit;

public class Task5 {

    public static void main(String[] args) {
        long startMemoryUse = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println("Всего памяти (kb): " + Runtime.getRuntime().totalMemory()/1000 + "  Свободной памяти (kb): " + Runtime.getRuntime().freeMemory()/1000 + " Используется (kb): " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000);

        Stack stack = new Stack();

        double arrFiller = 999_999_999;
        System.out.println("Заполняем...");
        for (int i = 0; i < 1_000_00; i++) {
            stack.enqueue(arrFiller - 1);
        }
        System.out.println("Всего памяти (kb): " + Runtime.getRuntime().totalMemory()/1000 + "  Свободной памяти (kb): " + Runtime.getRuntime().freeMemory()/1000 + " Используется (kb): " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - startMemoryUse)/1000);
        System.out.println("Длина массива: " + stack.arr.length);
        System.out.println("Верхее значение: " + stack.top());
        System.out.println("Удаляем...");

        long m = System.nanoTime();


//        for (int i = 0; i<100_000; i++) {
//            stack.arr[i] = null;
//        }
        for (int i = 0; i<100_000; i++) {
            stack.dequeue();
        }

        System.out.println("Время удаления (ms): " +  (System.nanoTime()-m)/1000);

        System.out.println("Удалили.");
        Runtime.getRuntime().gc();
 //       System.out.println("Верхее значение: " + stack.top());
        System.out.println("Длина массива: " + stack.arr.length);
        System.out.println("Всего памяти (kb): " + Runtime.getRuntime().totalMemory()/1000 + "  Свободной памяти (kb): " + Runtime.getRuntime().freeMemory()/1000 + " Используется (kb): " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - startMemoryUse)/1000);



//        stack.enqueue ("A");
//        stack.enqueue ("B");
//        stack.enqueue ("C");
//
//        for (int i = 0; i < stack.arr.length; i++) {
//            System.out.println(i + " - " + stack.arr[i]);
//        }
//        System.out.println(stack.isEmpty());
//        System.out.println("Верхний элемент: " + stack.top());
//        stack.dequeue();
//        stack.dequeue();
//        stack.dequeue();
//        System.out.println(stack.isEmpty());
//        System.out.println("Верхний элемент: " + stack.top());
//
//        for (int i = 0; i < stack.arr.length; i++) {
//            System.out.println(i + " - " + stack.arr[i]);
//        }
    }
}
