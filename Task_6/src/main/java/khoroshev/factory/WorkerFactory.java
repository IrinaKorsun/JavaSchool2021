package khoroshev.factory;

import khoroshev.factory.exception.WorkerException;
import khoroshev.factory.model.Child;
import khoroshev.factory.model.Man;
import khoroshev.factory.model.Woman;
import khoroshev.factory.model.Worker;

public class WorkerFactory {
    /**
     * Возвращает определённый объект, в зависимости от workerType.
     * @param workerType тип работника.
     * @return Man, Woman или Child с их профессией.
     * @throws WorkerException если переданный workerType не существует.
     */
    public static Worker createWorker(WorkerType workerType) throws WorkerException {
        switch (workerType) {
            case MAN_MINER:
                return new Man(workerType, 30, 5);
            case WOMAN_MINER:
                return new Woman(workerType, 34, 2);
            case CHILD_MINER:
                return new Child(workerType, 8, 10);
            case MAN_BUILDER:
                return new Man(workerType, 25, 6);
            case WOMAN_BUILDER:
                return new Woman(workerType,50, 8);
            case CHILD_BUILDER:
                return new Child(workerType,9,9);
            case MAN_POLICE:
                return new Man(workerType,23, 9);
            case WOMAN_POLICE:
                return new Woman(workerType,35, 6);
            case CHILD_POLICE:
                return new Child(workerType,11,10);
            case MAN_TEACHER:
                return new Man(workerType,28,1);
            case WOMAN_TEACHER:
                return new Woman(workerType,64,0);
            case CHILD_TEACHER:
                return new Child(workerType,4,1);
            case MAN_ROBBER:
                return new Man(workerType,40,10);
            case WOMAN_ROBBER:
                return new Woman(workerType,19,8);
            case CHILD_ROBBER:
                return new Child(workerType,16,10);
            case MAN_DOCTOR:
                return new Man(workerType,56,9);
            case WOMAN_DOCTOR:
                return new Woman(workerType,21, 5);
            case CHILD_DOCTOR:
                return new Child(workerType,6, 4);
            default:
                throw new WorkerException("Unknown worker type:" + workerType);
        }
    }
}