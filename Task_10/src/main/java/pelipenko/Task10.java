package pelipenko;

public class Task10 {
    public static Thread thread1, thread2;

    public static void newThread() {
        System.out.println(new Thread().getState());
    }

    public static void runningThread() {
        new Thread(() -> System.out.println(Thread.currentThread().getState())).start();
    }

    public static void blockedThreads() throws InterruptedException {
        thread1 = new Thread(Task10::wait1);
        thread2 = new Thread(Task10::wait1);
        thread1.start();
        thread2.start();
        Thread.sleep(100);
        //System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }

    public static void timedWaitingThreads() throws InterruptedException{
        thread1 = new Thread(()-> {
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
        Thread.sleep(1000);
        System.out.println(thread2.getState());
    }

    public static void terminated() throws InterruptedException {
        thread1 = new Thread();
        thread1.start();
        Thread.sleep(100);
        System.out.println(thread1.getState());
    }

    public static synchronized void wait1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        newThread();
        runningThread();
        blockedThreads();
        timedWaitingThreads();
        waitingThread();
        terminated();
    }
}
