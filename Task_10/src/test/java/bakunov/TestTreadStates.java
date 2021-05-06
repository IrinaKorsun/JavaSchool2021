package bakunov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.State.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTreadStates {
    private static final int SLEEP_VALUE = 500;
    private static ThreadStates thread;
    private static Object obj;

    @BeforeEach
    void setUp() {
        obj = new Object();
        thread = new ThreadStates(obj);
    }

    @Test
    void testNewThread() {
        assertEquals(NEW, thread.getState());
    }

    @Test
    void testRunnable() {
        thread.start();
        assertEquals(RUNNABLE, thread.getState());
    }

    @Test
    void testBlocked() throws InterruptedException {
        ThreadStates thread2 = new ThreadStates(obj);
        thread.start();
        thread2.start();
        Thread.sleep(SLEEP_VALUE);
        assertEquals(BLOCKED, thread2.getState());
    }

    @Test
    void testWaiting() throws InterruptedException {
        thread.start();
        Thread.sleep(2000);
        assertEquals(WAITING, thread.getState());
    }

    @Test
    void testTimedWaiting() throws InterruptedException {
        thread.start();
        Thread.sleep(SLEEP_VALUE);
        assertEquals(TIMED_WAITING, thread.getState());
    }

    @Test
    void testTerminated() throws InterruptedException {
        thread.start();
        Thread.sleep(SLEEP_VALUE);
        synchronized (obj) {
            obj.notifyAll();
        }
        thread.join();
        assertEquals(TERMINATED, thread.getState());
    }
}
