package khoroshev.factory;

public enum  WorkerType {
    MAN_MINER("шахтёром"),
    WOMAN_MINER("шахтёром"),
    CHILD_MINER("шахтёром"),
    MAN_BUILDER("строителем"),
    WOMAN_BUILDER("строителем"),
    CHILD_BUILDER("строителем"),
    MAN_POLICE("полицейским"),
    WOMAN_POLICE("полицейским"),
    CHILD_POLICE("полицейским"),
    MAN_TEACHER("учителем"),
    WOMAN_TEACHER("учителем"),
    CHILD_TEACHER("учителем"),
    MAN_ROBBER("грабителем"),
    WOMAN_ROBBER("грабителем"),
    CHILD_ROBBER("грабителем"),
    MAN_DOCTOR("доктором"),
    WOMAN_DOCTOR("мед. сестрой"),
    CHILD_DOCTOR("доктором");

    private final String message;

    WorkerType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
