package shakina;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestApplication {

    /**
     * Позитивный тест: 50 счетов и 200 клиентов
     * @throws Exception при ошибке обработки файла .properties
     */
    @Test
    public void positiveTestWith50BillsAnd200Clients() throws Exception {
        String path = "src/test/resources/shakina/application.properties";
        Application.main(new String[]{path});
    }


    /**
     * Позитивный тест: 2 счета и 100 клиентов
     * @throws Exception при ошибке обработки файла .properties
     */
    @Test
    public void positiveTestWith2BillsAnd100Clients() throws Exception {
        String path = "src/test/resources/shakina/application1.properties";
        Application.main(new String[]{path});
    }


    /**
     * Негативный тест, моделирующий ситуацию, когда на счетах изначально лежит больше, чем общая заданная сумма
     * @throws Exception при ошибке обработки файла .properties
     */
    @Test
    public void negativeTestWithWrongTotalAmount() throws Exception {
        String path = "src/test/resources/shakina/application2.properties";
        Bank bank = Bank.getInstance();

        Thread thread = new Thread(() -> {
            try {
                Application.main(new String[]{path});
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        thread.start();
        Thread.sleep(100);
        bank.setTotalAmountMoney(new BigDecimal(80000));
        thread.join();
    }
}