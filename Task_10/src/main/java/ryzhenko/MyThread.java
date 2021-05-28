package ryzhenko;

public class MyThread {

    private static final Object obj = new Object();

    /**
     * Состояние потока NEW
     */
    public static void newThread() {
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }

    /**
     * Состояние потока RUNNABLE
     */
    public static void runnable() {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getState());
    }

    /**
     * Состояние потока WAITING
     *
     * @throws InterruptedException
     */
    public static void waiting() throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getState());
        synchronized (obj) {
            obj.notify();
        }
    }

    /**
     * Состояние потока TIMED_WAITING
     *
     * @throws InterruptedException
     */
    public static void timed_waiting() throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait(500);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getState());
        synchronized (obj) {
            obj.notify();
        }
    }

    /**
     * Состояние потока BLOCKED
     *
     * @throws InterruptedException
     */
    public static void blocked() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(100);
        System.out.println(thread2.getState());
    }

    /**
     * Состояние потока TERMINATED
     *
     * @throws InterruptedException
     */
    public static void terminated() throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getState());
    }

    /**
     * Последовательно запускаем все методы
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        newThread();
        runnable();
        waiting();
        timed_waiting();
        blocked();
        terminated();
    }
}
