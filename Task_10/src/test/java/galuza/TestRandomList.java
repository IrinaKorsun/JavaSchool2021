package galuza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRandomList {
    private RandomList randomList = new RandomList(new ListFiller());

    @Test
    void testNewThread() {
        assertEquals(Thread.State.NEW, randomList.getState());
    }

    @Test
    void testRunnableThread() {
        randomList.start();
        assertEquals(Thread.State.RUNNABLE, randomList.getState());
    }

    @Test
    void testBlockedThread() throws InterruptedException {
        try {
            randomList.wait(100);
            assertEquals(Thread.State.BLOCKED, randomList.getState());
        } catch (IllegalMonitorStateException e) {}
    }

    @Test
    void testWaitingThread() throws InterruptedException {
        try {
            randomList.notify();
            Thread.sleep(1000);
            assertEquals(Thread.State.WAITING, randomList.getState());
        } catch (IllegalMonitorStateException e) {}
    }

    @Test
    void testTimedWaitingThread() throws InterruptedException {
        try {
            randomList.notify();
            Thread.sleep(1000);
            assertEquals(Thread.State.TIMED_WAITING, randomList.getState());
        } catch (IllegalMonitorStateException e) {}
    }

    @Test
    void testTerminatedThread() throws InterruptedException {
        try {
            randomList.notify();
            randomList.join();
            assertEquals(Thread.State.TERMINATED, randomList.getState());
        } catch (IllegalMonitorStateException e) {}
    }
}
