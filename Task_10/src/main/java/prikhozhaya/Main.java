package prikhozhaya;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NewThread testThread = new NewThread();
        System.out.println(testThread.getState());
        testThread.start();
        System.out.println(testThread.getState());
        testThread.methodWaiting();
        System.out.println(testThread.getState());
        testThread.methodBlocked();
        System.out.println(testThread.getState());
        Thread.sleep(500);
        System.out.println(testThread.getState());
        testThread.join();
        System.out.println(testThread.getState());
    }
}
