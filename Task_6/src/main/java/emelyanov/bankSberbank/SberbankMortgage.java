package emelyanov.bankSberbank;

import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Класс SberbankMortgage реализующий интерфейс Mortgage
 * В классе присутствует метод для создания ипотеки
 * @autor emelyanov 10.04.2021
 */
public class SberbankMortgage implements Mortgage {
    public SberbankMortgage() {
        System.out.println("Create SberbankMortgage");
    }
}
