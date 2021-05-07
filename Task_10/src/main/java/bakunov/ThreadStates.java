package bakunov;

public class ThreadStates extends Thread {
    Object obj;

    public ThreadStates(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                Thread.sleep(1000);
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
