package khoroshev;

public class ThreadStates {
    private static Thread thread1, thread2;

    public static void createNewThread() {
        System.out.println(getNewThread().getState().toString());
    }

    public static Thread getNewThread() {
        return new Thread(){};
    }

    public static void makeThreadRunnable() {
        thread1 = getNewThread();
        thread1.start();
        System.out.println(thread1.getState().toString());
    }

    public static void stopThread() throws InterruptedException {
        thread1 = getNewThread();
        thread1.start();
        thread1.interrupt();
        Thread.sleep(1000);
        System.out.println(thread1.getState().toString());
    }

    public static void threadWait() throws InterruptedException {
        thread1 = new Thread(() -> {
            thread2.start();
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(10);
        System.out.println(thread1.getState().toString());
    }

    public static void threadTimedWaiting() throws InterruptedException {
        thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(100);
        System.out.println(thread1.getState().toString());
    }

    public static void blockedThread() throws InterruptedException {
        thread1 = new Thread(() -> {
            try {
                doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2 = new Thread(() -> {
            try {
                doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(10);
        System.out.println(thread2.getState().toString());
    }

    public static void main(String[] args) throws InterruptedException {
        createNewThread();
        makeThreadRunnable();
        stopThread();
        threadWait();
        threadTimedWaiting();
        blockedThread();
    }

    public synchronized static void doSomething() throws InterruptedException {
            Thread.sleep(1000);
    }
}
