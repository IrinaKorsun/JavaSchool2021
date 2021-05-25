package starikov;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.concurrent.Executors;

/**
 * Класс тестов
 */
class BankTest {

    @Test
    void positive1() {
        System.out.println("Тест-положительный1: начало");
        startTest("positive1.properties");
        System.out.println("Тест-положительный1: конец");
    }

    @Test
    void positive2() {
        System.out.println("Тест-положительный2: начало");
        startTest("positive2.properties");
        System.out.println("Тест-положительный2: конец");
    }

    @Test
    void negative() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Тест-отрицательный: начало");
        PropertyToMap ptm = new PropertyToMap("positive1.properties");
        Bank bank = createBankFromPropertyToMap(ptm);
        bank.startTransfers();
        //по умолчанию чекер запускается через каждые 80 транзакций
        //для теста устанавливаем значение 2000, чтобы не сработал пока мы ему не скажем
        bank.getChecker().setLaunchFrequency(2000);

        int localCountOfTransaction = 0;
        int propTransactionCount = Integer.parseInt(ptm.getProperty("transactionCount"));

        while (localCountOfTransaction < propTransactionCount) {
            localCountOfTransaction = bank.getTransactionCount().get();

            Field bankTotalAmount = bank.getClass().getDeclaredField("totalAmount");
            bankTotalAmount.setAccessible(true);
            bankTotalAmount.set(bank, 1000);

            if (localCountOfTransaction > 100) {
                try {
                    Executors.callable(bank.getChecker()).call();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        System.out.println("Тест-отрицательный: конец");
    }

    private Bank createBankFromPropertyToMap(PropertyToMap ptm) {
        int numberOfAccounts = Integer.parseInt(ptm.getProperty("accountsNumber"));
        long totalAmount = Integer.parseInt(ptm.getProperty("totalAmount"));
        int numberOfClients = Integer.parseInt(ptm.getProperty("clientsNumber"));
        return new Bank(numberOfAccounts, totalAmount, numberOfClients);
    }

    private void startTest(String propertyFileName) {
        PropertyToMap ptm = new PropertyToMap(propertyFileName);
        Bank bank = createBankFromPropertyToMap(ptm);
        bank.startChecker();
        bank.startTransfers();

        int countOfTransaction = 0;
        int transactionCount = Integer.parseInt(ptm.getProperty("transactionCount"));

        while (countOfTransaction < transactionCount) {
            countOfTransaction = bank.getTransactionCount().get();
        }
        bank.stopTransfers();
        System.out.println("Достигли ограничения по количеству транзакций.");
    }
}

