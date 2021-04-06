package bakunov.exception;

public class CarExceprion  extends Throwable {
    private CarExceptionCode exceptionCode;

    public CarExceprion(CarExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public CarExceptionCode getErrorCode() {
        return this.exceptionCode;
    }
}
