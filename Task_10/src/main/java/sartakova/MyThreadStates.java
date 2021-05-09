package sartakova;

public class MyThreadStates {
    static final Object accessPoint = new Object();

    public static void main(String[] args) throws InterruptedException {
        stateThreadNew();
        stateThreadRunnable();
        stateThreadWaiting();
        stateThreadTimedWaiting();
        stateThreadBlocked();
        stateThreadTerminated();
    }

    /**
     * Состояние потока NEW
     */
    private static void stateThreadNew() {
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }

    /**
     * Состояние потока RUNNABLE
     */
    private static void stateThreadRunnable() {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getState());
    }
        /**
     * Состояние потока WAITING
     *
     * @throws InterruptedException - прерывание потока при вызове метода
     */
    private static void stateThreadWaiting() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (accessPoint) {
                try {
                    accessPoint.wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(150);
        System.out.println(thread.getState());
        synchronized (accessPoint) {
            accessPoint.notify();
        }
    }

    /**
     * Состояние потока TIMED_WAITING
     */
    private static void stateThreadTimedWaiting() {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(thread1.getState());
        });
        thread1.start();
        thread2.start();
    }

    /**
     * Состояние потока BLOCKED
     *
     * @throws InterruptedException - прерывание потока при вызове метода
     */
    private static void stateThreadBlocked() throws InterruptedException {
        Thread thread1 = new MyThreadBlock();
        Thread thread2 = new MyThreadBlock();
        thread1.start();
        thread2.start();
        Thread.sleep(150);
        System.out.println(thread2.getState());
    }
        /**
     * Состояние потока TERMINATED
     *
     * @throws InterruptedException - прерывание потока при вызове метода
     */
    private static void stateThreadTerminated() throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        Thread.sleep(200);
        System.out.println(thread.getState());
    }


    /**
     * Вспомогательный класс для показа состояния потока BLOCKED
     */
    static class MyThreadBlock extends Thread {
        @Override
        public void run() {
            synchronized (accessPoint) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
