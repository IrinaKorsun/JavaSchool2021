package mozzherin;

public class Client implements Runnable {
    Bank bank;
    int amount;
    int srcAccountIndex;
    int dstAccountIndex;

    public Client(Bank bank, int amount, int srcAccountIndex, int dstAccountIndex) {
        this.bank = bank;
        this.amount = amount;
        this.srcAccountIndex = srcAccountIndex;
        this.dstAccountIndex = dstAccountIndex;
    }

    @Override
    public void run() {
        if (srcAccountIndex != dstAccountIndex) {
            bank.transferMoney(amount, srcAccountIndex, dstAccountIndex);
        }
    }
}
