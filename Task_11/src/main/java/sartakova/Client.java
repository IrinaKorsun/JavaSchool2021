package sartakova;

/**
 * Информация о клиенте: активные счета; совершенные переводы.
 */
public class Client implements Runnable  {
    Money money;
    int amount;
    int srcAccountIndex;
    int dstAccountIndex;

    public Client(Money money, int amount, int srcAccountIndex, int dstAccountIndex) {
        this.money = money;
        this.amount = amount;
        this.srcAccountIndex = srcAccountIndex;
        this.dstAccountIndex = dstAccountIndex;
    }

    @Override
    public void run() {
        if (srcAccountIndex != dstAccountIndex) {
            money.transferMoney(amount, srcAccountIndex, dstAccountIndex);
        }
    }
}

