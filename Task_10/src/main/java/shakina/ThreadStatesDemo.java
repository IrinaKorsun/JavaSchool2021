package shakina;

/**
 * Класс для демонстрации состояний потоков
 */
public class ThreadStatesDemo {
    static final Object accessPoint = new Object();

    public static void main(String[] args) throws InterruptedException {
        stateNew();
        stateRunnable();
        stateWaiting();
        stateTimedWaiting();
        stateBlocked();
        stateTerminated();
    }

    /**
     * Демонстрация состояния потока NEW
     */
    private static void stateNew() {
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }

    /**
     * Демонстрация состояния потока RUNNABLE
     */
    private static void stateRunnable() {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getState());
    }

    /**
     * Демонстрация состояния потока WAITING
     *
     * @throws InterruptedException - если поток, на котором вызывается метод, был прерван
     */
    private static void stateWaiting() throws InterruptedException {
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
        Thread.sleep(100);
        System.out.println(thread.getState());
        synchronized (accessPoint) {
            accessPoint.notify();
        }
    }

    /**
     * Демонстрация состояния потока TIMED_WAITING
     */
    private static void stateTimedWaiting() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        Thread thread1 = new Thread(() -> {
            System.out.println(thread.getState());
        });
        thread.start();
        thread1.start();
    }

    /**
     * Демонстрация состояния потока BLOCKED
     *
     * @throws InterruptedException - если поток, на котором вызывается метод, был прерван
     */
    private static void stateBlocked() throws InterruptedException {
        Thread thread = new MyThread();
        Thread thread1 = new MyThread();
        thread.start();
        thread1.start();
        Thread.sleep(100);
        System.out.println(thread1.getState());
    }

    /**
     * Демонстрация состояния потока TERMINATED
     *
     * @throws InterruptedException - если поток, на котором вызывается метод, был прерван
     */
    private static void stateTerminated() throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getState());
    }


    /**
     * Вспомогательный класс для демонстрации состояния потока BLOCKED
     */
    static class MyThread extends Thread {
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