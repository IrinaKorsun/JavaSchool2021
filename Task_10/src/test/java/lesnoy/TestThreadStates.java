package lesnoy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.State.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestThreadStates {
    private static ThreadStates mainThread;
    private static Object syncObj;
    private static final int TIME = 1000;

    @BeforeEach
    void setUp() {
        syncObj = new Object();
        mainThread = new ThreadStates(syncObj);
    }

    @Test
    void testRunnable() {
        mainThread.start();
        assertEquals(RUNNABLE, mainThread.getState());
    }

    @Test
    void testNewThread() {
        assertEquals(NEW, mainThread.getState());
    }

    @Test
    void testWaiting() throws InterruptedException {
        mainThread.start();
        Thread.sleep(7000);
        assertEquals(WAITING, mainThread.getState());
    }

    @Test
    void testTimedWaiting() throws InterruptedException {
        mainThread.start();
        Thread.sleep(100);
        assertEquals(TIMED_WAITING, mainThread.getState());
    }

    @Test
    void testTerminated() throws InterruptedException {
        mainThread.start();
        Thread.sleep(TIME);
        synchronized (syncObj) {
            syncObj.notifyAll();
        }
        mainThread.join();
        assertEquals(TERMINATED, mainThread.getState());
    }

    @Test
    void testBlocked() throws InterruptedException {
        ThreadStates thread = new ThreadStates(syncObj);
        mainThread.start();
        thread.start();
        Thread.sleep(TIME);
        assertEquals(BLOCKED, thread.getState());
    }

}
