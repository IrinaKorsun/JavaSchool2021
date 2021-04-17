package starikov.models;

import java.util.UUID;

/**
 * Модель банкноты
 */
public abstract class Banknote {
    private final UUID serialNumber;

    public Banknote() {
        this.serialNumber = UUID.randomUUID();
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }
}
