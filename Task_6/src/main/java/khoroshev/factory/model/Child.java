package khoroshev.factory.model;

import khoroshev.factory.WorkerType;

public class Child extends Worker {
    public Child(WorkerType workerType, int age, int motivation) {
        super(workerType, age, motivation);
    }

    @Override
    public String work() {
        return "Мой возраст: " + getAge() + "\nМоя мотивация работать: "
                + getMotivation() + "/10\nКогда вырасту, то буду " + getWorkerType().getMessage() + ".";
    }

}
