package zatsepin;

/**
 * The class used to test the Thread life cycle.
 */
public class ThreadLifeCycle extends Thread {
    private Object mutex;

    public ThreadLifeCycle(Object mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        synchronized (mutex) {
            try {
                Thread.sleep(1000);
                mutex.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
