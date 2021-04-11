package emelyanov.bankSberbank;

import emelyanov.interfaceBankingProducts.Deposit;

/*
 * Класс SberbankDeposit реализующий интерфейс Deposit
 * В классе присутствует метод для создания вклада
 * @autor emelyanov 10.04.2021
 */
public class SberbankDeposit implements Deposit {
    public SberbankDeposit() {
        System.out.println("Create SberbankDeposit");
    }
}
