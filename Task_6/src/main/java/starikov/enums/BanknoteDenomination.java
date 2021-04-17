package starikov.enums;

/**
 * Класс перечислений номиналов
 */
public enum BanknoteDenomination {
    TEN("Номинал 10"),
    FIFTY("Номинал 50"),
    ONEHANDRED("Номинал 100");

    private final String title;

    BanknoteDenomination(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
