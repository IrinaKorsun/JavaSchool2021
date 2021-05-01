package zhmaylo;

import static java.lang.Thread.State.TIMED_WAITING;

public class ThreadCondition extends Thread {
    static final Object monitor = new Object();

    @Override
    public void run() {
        synchronized (monitor) {

            try {
                monitor.notify();
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCondition thread1 = new ThreadCondition();
        System.out.println(thread1.getState()); //new
        thread1.start();
        System.out.println(thread1.getState()); //runnable
        synchronized (monitor) {
            monitor.wait();
            System.out.println(thread1.getState()); //waiting
            monitor.notify();
            System.out.println(thread1.getState()); //blocked
        }
        /*
        while- оптимальный способ, что бы дождаться устойчивого "засыпания" потока, yield и прочии sleep
        работают не устойчиво, надежнее проверять до момента пока не уснет,
        да я понимаю что это потенциальный риск повесить всё, но текущую задачу решает, и лучше ничего не придумал.
         */
        while (thread1.getState() != TIMED_WAITING) ;
        System.out.println(thread1.getState());
        thread1.join(); //ждем когда завершится thread1 и только потом проверяем его статус
        System.out.println(thread1.getState());//terminate
    }
}
