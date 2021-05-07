package filippov;

public class ThreadOperations extends Thread {

    final static Object monitor = new Object();

    public void printStatus() {
        System.out.println(this.getState());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOperations thread = new ThreadOperations();
        synchronized (monitor) {
            //NEW
            thread.printStatus();
            thread.start();
            //RUNNABLE
            thread.printStatus();
            //WAITING & TIME_WAITING
            for (int i = 0; i < 2; i++) {
                monitor.notify();
                monitor.wait();
                thread.printStatus();
            }
            monitor.notify();
            //BLOCKED
            thread.printStatus();
        }
        sleep(1);
        //TERMINATED
        thread.printStatus();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            //WAITING
            try {
                monitor.notify();
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TIMED_WAITING
            try {
                monitor.notify();
                monitor.wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
