package prikhozhaya;

public class NewThread extends Thread {
    private final Object object = new Object();

    public void methodWaiting() {
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodBlocked() {
        synchronized (object) {
            object.notify();
        }
    }

    @Override
    public void run() {
        synchronized (object) {
            object.notify();
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
