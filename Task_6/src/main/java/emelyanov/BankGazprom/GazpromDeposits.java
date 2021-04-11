package emelyanov.BankGazprom;

import emelyanov.InterfaceBankingProducts.Deposits;

/*
 * Класс VTBDeposits реализующий интерфейс Deposits
 * @autor emelyanov 10.04.2021
 */
public class GazpromDeposits implements Deposits {
    public GazpromDeposits() {
        System.out.println("Create GazpromDeposits");
    }
}
