package starikov;

public class ThreadStates {

    public static void main(String[] args) {
        ThreadStates ts = new ThreadStates();
        System.out.println(ts.newThread().getState());
        System.out.println(ts.runnableThread().getState());
        System.out.println(ts.waitingThread().getState());
        System.out.println(ts.timedWaitingThread().getState());
        System.out.println(ts.blockedThread().getState());
        System.out.println(ts.terminatedThread().getState());
    }

    public Thread newThread() {
        return new Thread(() -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public Thread runnableThread() {
        Thread thread = newThread();
        thread.start();
        return thread;
    }

    public Thread waitingThread() {
        Thread thread1 = runnableThread();
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return thread2;
    }

    public Thread timedWaitingThread() {
        Thread thread = runnableThread();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return thread;
    }

    public Thread blockedThread() {
        Thread thread1 = new Thread(this::timeToSleep);
        thread1.start();
        Thread thread2 = new Thread(this::timeToSleep);
        thread2.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return thread2;
    }

    public Thread terminatedThread() {
        Thread thread = runnableThread();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return thread;
    }

    private synchronized void timeToSleep() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
