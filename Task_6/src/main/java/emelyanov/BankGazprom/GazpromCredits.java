package emelyanov.BankGazprom;

import emelyanov.InterfaceBankingProducts.Credits;

/*
 * Класс VTBCredits реализующий интерфейс Credits
 * @autor emelyanov 10.04.2021
 */
public class GazpromCredits implements Credits {
    public GazpromCredits() {
        System.out.println("Create GazpromCredits");
    }
}
