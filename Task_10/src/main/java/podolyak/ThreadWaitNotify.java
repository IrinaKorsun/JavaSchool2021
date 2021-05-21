package podolyak;


public class ThreadWaitNotify extends Thread{

    private  final Object object = new Object();

    public void objectNotify(){
        synchronized (object){
            object.notify();
        }
    }
    public void objectWait(){
        synchronized (object){
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadWaitNotify threadWaitNotify = new ThreadWaitNotify();
        System.out.println(threadWaitNotify.getState());
        threadWaitNotify.start();
        System.out.println(threadWaitNotify.getState());
        threadWaitNotify.objectWait();
        System.out.println(threadWaitNotify.getState());
        threadWaitNotify.objectNotify();
        System.out.println(threadWaitNotify.getState());
        sleep(100);
        System.out.println(threadWaitNotify.getState());
        threadWaitNotify.join();
        System.out.println(threadWaitNotify.getState());
    }
}
