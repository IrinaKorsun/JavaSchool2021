package khoroshev.factory.model;

import khoroshev.factory.WorkerType;

public abstract class Worker {
    private WorkerType workerType;
    private int age;
    private int motivation;

    public Worker(WorkerType workerType, int age, int motivation) {
        setWorkerType(workerType);
        setAge(age);
        setMotivation(motivation);
    }

    public WorkerType getWorkerType() {
        return workerType;
    }

    public void setWorkerType(WorkerType workerType) {
        this.workerType = workerType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMotivation() {
        return motivation;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    public String work() {
        return "Мой возраст: " + getAge() + "\nМоя мотивация работать: "
                + getMotivation() + "/10\nСейчас работаю " + getWorkerType().getMessage() + ".";
    }

}
