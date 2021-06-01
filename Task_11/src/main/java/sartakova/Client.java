package sartakova;
import  java.util.Random;

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

        Random random = new Random();
        while (true) {
            int srcAccountIndex = random.nextInt(2);
            int dstAccountIndex = random.nextInt(2);
            if (srcAccountIndex != dstAccountIndex){
                System.out.println("Сумма перевода " + amount);
                money.transferMoney(amount, srcAccountIndex, dstAccountIndex);
                  try {
                    Thread.sleep(5);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                continue;
            }
            break;
        }
    }
}

