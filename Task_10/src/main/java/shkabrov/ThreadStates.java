package shkabrov;

public class ThreadStates {
    static final Object lock = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        getThreadStateNew();
        getThreadStateRunnable();
        getThreadStateWaiting();
        getThreadStateTimedWaiting();
        getThreadStateTerminated();
        getThreadStateBlocked();
    }

    /**
     * Отображает состояние потока New
     */
    public static void getThreadStateNew() {
        Thread thread = new Thread();
        System.out.println("Method:getThreadStateNew\n" + thread.getState());
    }

    /**
     * Отображает состояние потока Runnable
     */
    public static void getThreadStateRunnable() {
        Thread thread = new Thread(() -> System.out.println("Method:getThreadStateRunnable\n"
                + Thread.currentThread().getState()));
        thread.start();
    }

    /**
     * Отображает состояние потока Waiting
     */
    public static void getThreadStateWaiting() {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method:getThreadStateWaiting\n" + thread.getState());
        synchronized (lock) {
            lock.notify();
        }
    }

    /**
     * Отображает состояние потока TimedWaiting
     */
    public static void getThreadStateTimedWaiting() {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method:getThreadStateTimedWaiting\n" + thread.getState());
    }

    /**
     * Отображает состояние потока Terminated
     */
    public static void getThreadStateTerminated() {
        Thread thread = new Thread();
        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method:getThreadStateTerminated\n" + thread.getState());
    }

    /**
     * Создает Deadlock, для отображения состояния Blocked на втором потоке
     */
    public static void getThreadStateBlocked() {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                synchronized (lock2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(200);
                    synchronized (lock) {
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method:getThreadStateBlocked\n" + thread2.getState());
    }
}
