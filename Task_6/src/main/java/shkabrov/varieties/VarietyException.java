package shkabrov.varieties;

public class VarietyException extends Exception {
    private VarietyErrorCode varietyErrorCode;

    public VarietyException(VarietyErrorCode varietyErrorCode) {
        this.varietyErrorCode = varietyErrorCode;
    }

    /**
     * @return код ошибки
     */
    public VarietyErrorCode getErrorCode() {
        return varietyErrorCode;
    }
}
