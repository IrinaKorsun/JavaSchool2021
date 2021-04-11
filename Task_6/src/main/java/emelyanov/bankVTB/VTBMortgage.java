package emelyanov.bankVTB;

import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Класс VTBMortgage реализующий интерфейс Mortgage
 * В классе присутствует метод для создания ипотеки
 * @autor emelyanov 10.04.2021
 */
public class VTBMortgage implements Mortgage {
    public VTBMortgage() {
        System.out.println("Create VTBMortgage");
    }
}
