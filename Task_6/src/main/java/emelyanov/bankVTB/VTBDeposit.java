package emelyanov.bankVTB;

import emelyanov.interfaceBankingProducts.Deposit;

/*
 * Класс VTBDeposit реализующий интерфейс Deposit
 * В классе присутствует метод для создания вклада
 * @autor emelyanov 10.04.2021
 */
public class VTBDeposit implements Deposit {
    public VTBDeposit() {
        System.out.println("Create VTBDeposit");
    }
}
