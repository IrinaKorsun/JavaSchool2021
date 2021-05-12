package lesnoy;

public class ThreadStates extends Thread{
    Object syncObj;

    public ThreadStates(Object mutex) {
        this.syncObj = mutex;
    }

    @Override
    public void run() {
        synchronized (syncObj) {
            try {
                Thread.sleep(5000);
                syncObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
