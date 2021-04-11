package emelyanov.bankGazprom;

import emelyanov.interfaceBankingProducts.Credit;

/*
 * Класс GazpromCredit реализующий интерфейс Credit
 * В классе присутствует метод для создания кредита
 * @autor emelyanov 10.04.2021
 */
public class GazpromCredit implements Credit {
    public GazpromCredit() {
        System.out.println("Create GazpromCredit");
    }
}
