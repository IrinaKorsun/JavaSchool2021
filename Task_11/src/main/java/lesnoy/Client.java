package lesnoy;

import java.math.BigDecimal;

public class Client implements Runnable {
    Bank bank;
    BigDecimal sum;
    int fromBillIndex;
    int toBillIndex;

    public Client(Bank bank, BigDecimal sum, int fromBillIndex, int toBillIndex) {
        this.bank = bank;
        this.sum = sum;
        this.fromBillIndex = fromBillIndex;
        this.toBillIndex = toBillIndex;
    }

    @Override
    public void run() {
        if (fromBillIndex != toBillIndex) {
            bank.transferMoney(sum, fromBillIndex, toBillIndex);
        }
    }
}

