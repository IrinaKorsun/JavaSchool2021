package emelyanov;

public class ThreadForDemo extends Thread {
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        threadNew();
        threadRunnable();
        threadWaiting();
        threadTimedWaiting();
        threadBlocked();
        threadTerminated();
    }

    //Состояние потока NEW, поток создан но не запущен
    private static void threadNew() {
        Thread thread = new Thread();
        System.out.println(thread.getState() + ": flow state NEW");
    }

    //Состояние потока RUNNABLE, поток готов к выполнению
    private static void threadRunnable() {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getState() + ": flow state RUNNABLE");
    }

    //Состояние потока WAITING, поток ждет окончания работы другого потока;
    private static void threadWaiting() throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        sleep(2000);
        System.out.println(threadA.getState() + ": flow state WAITING");

        new Thread(() -> {
            synchronized (object) {
                object.notify();
            }
        }).start();
    }

    //Состояние потока TIMED_WAITING, поток некоторое время ждет окончания другого потока
    private static void threadTimedWaiting() {
        Thread threadA = new Thread(() -> {
            synchronized (object) {
                try {
                    sleep(2000);
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread threadB = new Thread(() -> {
            synchronized (object) {
                object.notify();
            }
        });
        threadB.start();
        System.out.println(threadA.getState() + ": flow state TIMED_WAITING");
    }

    //Состояние потока BLOCKED, поток блокирован
    private static void threadBlocked() {
        Thread threadA = new Thread(ThreadForDemo::threadHelper);
        threadA.start();
        Thread threadB = new Thread(ThreadForDemo::threadHelper);
        threadB.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadB.getState() + ": flow state BLOCKED");
    }

    //Состояние потока TERMINATED, поток завершен
    private static void threadTerminated() {
        Thread thread = new Thread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState() + ": flow state TERMINATED");
    }

    //Вспомогательный метод
    private static void threadHelper() {
        synchronized (object) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
