package shakina.exception;

public enum ErrorCode {
    FULL_QUEUE("Очередь заполнена"),
    EMPTY_QUEUE("Очередь пустая"),
    FULL_STACK("Стек заполнен"),
    EMPTY_STACK("Стек пустой");


    private final String errorString;

    ErrorCode (String message) {
        errorString = message;
    }

    public String getErrorString(){
        return errorString;
    }

}
