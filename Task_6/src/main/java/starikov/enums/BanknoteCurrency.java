package starikov.enums;

/**
 * Класс перечислений валют
 */
public enum BanknoteCurrency {
    ROUBLE("Российский рубль"),
    DOLLAR("Американский доллар"),
    EURO("Европейский евро");


    private final String title;

    BanknoteCurrency(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
