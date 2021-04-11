package emelyanov.bankGazprom;

import emelyanov.interfaceBankingProducts.Deposit;

/*
 * Класс GazpromDeposit реализующий интерфейс Deposit
 * В классе присутствует метод для создания вклада
 * @autor emelyanov 10.04.2021
 */
public class GazpromDeposit implements Deposit {
    public GazpromDeposit() {
        System.out.println("Create GazpromDeposit");
    }
}
