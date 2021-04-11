package emelyanov.bankSberbank;

import emelyanov.interfaceBankingProducts.Credit;

/*
 * Класс SberbankCredit реализующий интерфейс Credit
 * В классе присутствует метод для создания кредита
 * @autor emelyanov 10.04.2021
 */
public class SberbankCredit implements Credit {
    public SberbankCredit() {
        System.out.println("Create SberbankCredit");
    }
}
