package khoroshev.factory;

import khoroshev.factory.model.Worker;
import khoroshev.factory.exception.WorkerException;
import khoroshev.factory.model.Child;
import khoroshev.factory.model.Man;
import khoroshev.factory.model.Woman;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerFactoryTest {

    @Test
    void createWorkerTestClass() {
        assertAll(
                () -> assertEquals(Child.class, WorkerFactory.createWorker(WorkerType.CHILD_BUILDER).getClass()),
                () -> assertEquals(Child.class, WorkerFactory.createWorker(WorkerType.CHILD_DOCTOR).getClass()),
                () -> assertEquals(Child.class, WorkerFactory.createWorker(WorkerType.CHILD_MINER).getClass()),
                () -> assertEquals(Child.class, WorkerFactory.createWorker(WorkerType.CHILD_POLICE).getClass()),
                () -> assertEquals(Child.class, WorkerFactory.createWorker(WorkerType.CHILD_ROBBER).getClass()),
                () -> assertEquals(Child.class, WorkerFactory.createWorker(WorkerType.CHILD_TEACHER).getClass()),
                () -> assertEquals(Man.class, WorkerFactory.createWorker(WorkerType.MAN_BUILDER).getClass()),
                () -> assertEquals(Man.class, WorkerFactory.createWorker(WorkerType.MAN_DOCTOR).getClass()),
                () -> assertEquals(Man.class, WorkerFactory.createWorker(WorkerType.MAN_MINER).getClass()),
                () -> assertEquals(Man.class, WorkerFactory.createWorker(WorkerType.MAN_POLICE).getClass()),
                () -> assertEquals(Man.class, WorkerFactory.createWorker(WorkerType.MAN_ROBBER).getClass()),
                () -> assertEquals(Man.class, WorkerFactory.createWorker(WorkerType.MAN_TEACHER).getClass()),
                () -> assertEquals(Woman.class, WorkerFactory.createWorker(WorkerType.WOMAN_BUILDER).getClass()),
                () -> assertEquals(Woman.class, WorkerFactory.createWorker(WorkerType.WOMAN_DOCTOR).getClass()),
                () -> assertEquals(Woman.class, WorkerFactory.createWorker(WorkerType.WOMAN_MINER).getClass()),
                () -> assertEquals(Woman.class, WorkerFactory.createWorker(WorkerType.WOMAN_POLICE).getClass()),
                () -> assertEquals(Woman.class, WorkerFactory.createWorker(WorkerType.WOMAN_ROBBER).getClass()),
                () -> assertEquals(Woman.class, WorkerFactory.createWorker(WorkerType.WOMAN_TEACHER).getClass())
        );
    }

    @Test
    void createWorkerTestWork() throws WorkerException {
        String message;
        List<Worker> workers = new ArrayList<>();
        workers.add(WorkerFactory.createWorker(WorkerType.CHILD_BUILDER));
        workers.add(WorkerFactory.createWorker(WorkerType.CHILD_TEACHER));
        workers.add(WorkerFactory.createWorker(WorkerType.CHILD_ROBBER));
        workers.add(WorkerFactory.createWorker(WorkerType.CHILD_POLICE));
        workers.add(WorkerFactory.createWorker(WorkerType.CHILD_MINER));
        workers.add(WorkerFactory.createWorker(WorkerType.CHILD_DOCTOR));
        workers.add(WorkerFactory.createWorker(WorkerType.MAN_TEACHER));
        workers.add(WorkerFactory.createWorker(WorkerType.MAN_BUILDER));
        workers.add(WorkerFactory.createWorker(WorkerType.MAN_TEACHER));
        workers.add(WorkerFactory.createWorker(WorkerType.MAN_POLICE));
        workers.add(WorkerFactory.createWorker(WorkerType.MAN_DOCTOR));
        workers.add(WorkerFactory.createWorker(WorkerType.MAN_MINER));
        workers.add(WorkerFactory.createWorker(WorkerType.WOMAN_TEACHER));
        workers.add(WorkerFactory.createWorker(WorkerType.WOMAN_ROBBER));
        workers.add(WorkerFactory.createWorker(WorkerType.WOMAN_POLICE));
        workers.add(WorkerFactory.createWorker(WorkerType.WOMAN_MINER));
        workers.add(WorkerFactory.createWorker(WorkerType.WOMAN_DOCTOR));
        workers.add(WorkerFactory.createWorker(WorkerType.WOMAN_BUILDER));

        for (Worker worker : workers) {
            if (worker instanceof Child) {
                message = "Мой возраст: " + worker.getAge() + "\nМоя мотивация работать: "
                        + worker.getMotivation() + "/10\nКогда вырасту, то буду " + worker.getWorkerType().getMessage() + ".";
            } else {
                message = "Мой возраст: " + worker.getAge() + "\nМоя мотивация работать: "
                        + worker.getMotivation() + "/10\nСейчас работаю " + worker.getWorkerType().getMessage() + ".";
            }
            assertEquals(message, worker.work());
        }
    }
}
