package bakunov;

import java.util.Objects;

public class QueueStackException extends Throwable {
    private ErrorCode exceptionCode;

    public QueueStackException(ErrorCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public ErrorCode getErrorCode() {
        return this.exceptionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueStackException that = (QueueStackException) o;
        return exceptionCode == that.exceptionCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exceptionCode);
    }
}
