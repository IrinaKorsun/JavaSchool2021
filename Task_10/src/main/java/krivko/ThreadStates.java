package krivko;

/**
 * Задание 10
 * <br> Демонстрация состояния потоков выполнения Thread.State
 */
public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        newThread();
        runnableThread();
        timedWaitingThread();
        waitingThread();
        blockedThread();
        terminatedThread();
    }

    static void newThread() {
        Thread thread = new Thread();
        System.out.println(thread.getName() + " " + thread.getState());
    }

    static void runnableThread() {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getName() + " " + thread.getState());
    }

    static void timedWaitingThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(10);
        System.out.println(thread.getName() + " " + thread.getState());
    }

    static void waitingThread() throws InterruptedException {
        Object lock = new Object();
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
        Thread.sleep(10);
        System.out.println(thread.getName() + " " + thread.getState());
        synchronized (lock) {
            lock.notify();
        }
    }

    static void blockedThread() throws InterruptedException {
        Object lock = new Object();
        Runnable runnable = () -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        (new Thread(runnable)).start();
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(10);
        System.out.println(thread.getName() + " " + thread.getState());
    }

    static void terminatedThread() throws InterruptedException  {
        Thread thread = new Thread();
        thread.start();
        thread.join();
        System.out.println(thread.getName() + " " + thread.getState());
    }
}