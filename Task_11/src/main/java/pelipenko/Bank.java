package pelipenko;

/*Есть банк. В нем N счетов и M клиентов.
Клиент может переводить деньги с одного счёта на другой.
Необходимо создать демона наблюдателя, который будет следить, что всё ок - что денежная масса в системе постоянна -- нет утечек).
Денежный пул создаётся при запуске программы, он фиксирован и указывается через проперти файл

В программе должно работать одновременно >= 30 потоков. Количество M и N также задаются через проперти.
Подсказки:
Не используйте для синхронизации один общий глобальный объект (в таком слкчае когда демон будет сверять счета то банк остановится)
Кроме того, проверьте что обработаны следующие ситуации:
Проблема синхронизации:
Клиент снял со счёта 1 сумму X, с целью положить его на счёт 2.
Демон проверил сумму на счёте 1.
Демон проверил сумму на счёте 2.
Клиент положил сумму X на счёт 2.
Таким образом демон недосчитался X. Эту ситуацию нужно обработать.
Если клиент хочет сделать перевод медлу счетами, то он сначала должен убедиться что требуемая сумма действительно есть на счёте.
Если нет - то клиент может либо попытаться перевести сумму поменьше попробовать в следующий раз.
Демон должен чекать суммы, актуально лежащие на счетах. можно сделать и дополнительные внутренние проверки
Тесты:
1. Положительный сценарий:
Запускаем N клиентов (не менее 70). Все ок.
2. Негативный сценарий:
Даем какому-нибудь клиенту слишком большую сумму (больше общего amount). запускаем N клиентов (не менее 70). Ожидаем, что будет исключение от демона.
3. Положительный сценарий.
Запускаем N клиентов (не менее 70), которые работают только с двумя счетами. Все ок.*/

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static pelipenko.Global.Accounts;
import static pelipenko.Global.ConsoleLock;
import static pelipenko.RandomHelper.getRandomNumberUsingNextInt;

public class Bank {
    public static void main(String[] args) {
        Accounts = new ArrayList<>(Global.M);

        for (int i = 0; i < Global.M; i++) {
            Accounts.add(new Account(i, Global.MaxAmount));
        }

        Thread DeamonThread = new Thread(() -> {
            while (true) {
                try {
                    BigDecimal sumAmount = BigDecimal.valueOf(0);
                    for (Account account : Accounts) {
                        sumAmount = sumAmount.add(account.getAmount());
                    }
                    ConsoleLock.lock();
                    System.out.println();
                    System.out.printf("Sum of amounts = %s", sumAmount);
                    System.out.println();
                    ConsoleLock.unlock();
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        DeamonThread.setDaemon(true);
        DeamonThread.start();

        for (int i = 0; i < Global.N; i++) {
            int fromAccountID = getRandomNumberUsingNextInt(0, Global.M);

            Thread clientThread = new Thread(new ClientRunnable(fromAccountID));

            clientThread.start();
        }
    }
}
