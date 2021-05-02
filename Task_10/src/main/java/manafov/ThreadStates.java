package manafov;

public class ThreadStates {
    private static Thread thread1, thread2;

    public static void newThread() {
        System.out.println(new Thread().getState());
    }

    public static void runnableThread() {
        new Thread(() -> System.out.println(Thread.currentThread().getState())).start();
    }

    public static void blockedThread() throws InterruptedException {
        thread1 = new Thread(ThreadStates::toDo);
        thread2 = new Thread(ThreadStates::toDo);
        thread1.start();
        thread2.start();
        Thread.sleep(500);
        System.out.println(thread2.getState());
    }

    public static void waitingThread() throws InterruptedException {
        thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(500);
        System.out.println(thread2.getState());
    }

    public static void timedWaitingThread() throws InterruptedException {
        thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(500);
        System.out.println(thread1.getState());
    }

    public static void terminatedThread() throws InterruptedException {
        thread1 = new Thread();
        thread1.start();
        Thread.sleep(500);
        System.out.println(thread1.getState());
    }

    public static void main(String[] args) throws InterruptedException {
        newThread();
        runnableThread();
        blockedThread();
        waitingThread();
        timedWaitingThread();
        terminatedThread();
    }

    private static synchronized void toDo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
