package shakina;


import java.math.BigDecimal;

/**
 * Клиент
 */
public class Client implements Runnable {
    private final TransactionManager transactionManager = new TransactionManager();
    private final int billFromId;
    private final int billToId;
    private final BigDecimal sum;
    private final Bank bank = Bank.getInstance();

    public Client(int billFromId, int billToId, BigDecimal sum) {
        this.billFromId = billFromId;
        this.billToId = billToId;
        this.sum = sum;
    }

    @Override
    public void run() {
        while (true) {
            if (sum.compareTo(bank.getBills().get(billFromId).getAmount()) > 0) {
                System.out.println("Don't have enough money. On the bill " + billFromId);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                continue;
            }
            transactionManager.transfer(billFromId, billToId, sum);
            break;
        }
    }
}