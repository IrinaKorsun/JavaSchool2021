package krivko;

import org.junit.jupiter.api.Test;

class BankTest {
    @Test
    public void testDefault() throws InterruptedException {
        String[] args = {};
        System.out.println("START testDefault");
        Bank.main(args);
        Thread.sleep(500);
        System.out.println("END testDefault\n");
    }

    @Test
    public void testHacking() throws InterruptedException {
        String[] args = {"hacking"};
        System.out.println("START testHacking");
        Bank.main(args);
        System.out.println("END testHacking\n");
    }

    @Test
    public void testTwoAccounts() throws InterruptedException {
        String[] args = {"two_accounts"};
        System.out.println("START testTwoAccounts");
        Bank.main(args);
        System.out.println("END testTwoAccounts\n");
    }
}