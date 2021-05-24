package pelipenko;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Global {
    public static final int N = 100;
    public static final int M = 1000;
    public static final BigDecimal MaxAmount = BigDecimal.valueOf(100000);

    public static List<Account> Accounts;
    public static Lock ConsoleLock = new ReentrantLock();
}
