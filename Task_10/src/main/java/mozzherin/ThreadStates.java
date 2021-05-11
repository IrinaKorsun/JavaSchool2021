package mozzherin;

public class ThreadStates {
    public static Thread thread, thread1;

    public static void main(String[] args) {
        threadNew();
        threadRunnable();
        threadBlocked();
        threadWaiting();
        threadTimedWaiting();
        threadTerminated();
    }

    private static void threadNew() {
        thread = new Thread();
        System.out.println(thread.getState());
    }

    private static void threadRunnable() {
        thread.start();
        System.out.println(thread.getState());
    }

    private static void threadBlocked() {
        thread = new Thread(ThreadStates::sleepMethod);
        thread1 = new Thread(ThreadStates::sleepMethod);
        thread.start();
        thread1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }

    private static synchronized void sleepMethod() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void threadWaiting() {
        thread1 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }

    private static void threadTimedWaiting() {
        thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }

    public static void threadTerminated() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }

}
