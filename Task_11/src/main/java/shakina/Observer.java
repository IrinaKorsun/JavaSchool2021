package shakina;


import shakina.exception.ObserverException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Наблюдатель для проверки за сохранностью общей денежной массы
 */
public class Observer implements Runnable {
    private final Bank bank;

    public Observer() {
        bank = Bank.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            List<Bill> bills = copyBills(bank.getBills(), new ArrayList<>(), 0);
            BigDecimal amount = bills.stream().map(Bill::getAmount).reduce(BigDecimal::add).orElseThrow(RuntimeException::new);
            if (amount.compareTo(bank.getTotalAmountMoney()) == 0) {
                System.out.println("Verification completed successfully");
            } else {
                throw new ObserverException("Money leak detected");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    private List<Bill> copyBills(List<Bill> source, List<Bill> target, int position) {
        if (position < source.size()) {
            synchronized (source.get(position)) {
                target.add(new Bill(source.get(position)));
                return copyBills(source, target, ++position);
            }
        } else {
            return target;
        }
    }
}