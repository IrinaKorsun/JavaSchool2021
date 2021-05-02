package zatsepin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Thread.State.*;

class ThreadLifeCycleTest {
    private Object mutex;
    private ThreadLifeCycle thread;

    @BeforeEach
    void setUp() {
        mutex = new Object();
        thread = new ThreadLifeCycle(mutex);
    }

    @AfterEach
    void tearDown() {
        mutex = null;
        thread = null;
    }

    @Test
    void threadNew() {
        assertEquals(NEW, thread.getState());
    }

    @Test
    void threadRunnable() {
        thread.start();
        assertEquals(RUNNABLE, thread.getState());
    }

    @Test
    void threadBlocked() throws InterruptedException {
        ThreadLifeCycle thread2 = new ThreadLifeCycle(mutex);
        thread.start();
        thread2.start();
        Thread.sleep(100);
        assertEquals(BLOCKED, thread2.getState());
    }

    @Test
    void threadWaiting() throws InterruptedException {
        thread.start();
        Thread.sleep(2000);
        assertEquals(WAITING, thread.getState());
    }

    @Test
    void threadTimedWaiting() throws InterruptedException {
        thread.start();
        Thread.sleep(10);
        assertEquals(TIMED_WAITING, thread.getState());
    }

    @Test
    void threadTerminated() throws InterruptedException {
        thread.start();
        Thread.sleep(2000);
        synchronized (mutex) {
            mutex.notifyAll();
        }
        thread.join();
        assertEquals(TERMINATED, thread.getState());
    }
}