package komissarov;

public class ThreadStates {
    private static Thread thread1, thread2;

    public static void newThread() {
        thread1 = new Thread("thread1");
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());
    }

    public static void terminatedThread() throws InterruptedException {
        thread2 = new Thread("thread2");
        thread2.start();
        thread2.join();
        System.out.println(thread2.getState());
    }

    public static void waitThread() throws InterruptedException {
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
        System.out.println(thread1.getState());

    }

    public static void timeWaitingThread() throws InterruptedException {
        thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(100);
        System.out.println(thread1.getState());
    }

    public static void blockedThread() throws InterruptedException {
        thread1 = new Thread(ThreadStates::synch);
        thread2 = new Thread(ThreadStates::synch);
        thread1.start();
        thread2.start();
        Thread.sleep(100);
        System.out.println(thread2.getState());
    }

    public static synchronized void synch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        newThread();
        terminatedThread();
        waitThread();
        timeWaitingThread();
        blockedThread();
    }

}
