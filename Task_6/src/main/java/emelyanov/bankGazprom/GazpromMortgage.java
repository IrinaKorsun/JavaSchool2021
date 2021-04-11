package emelyanov.bankGazprom;

import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Класс GazpromMortgage реализующий интерфейс Mortgage
 * В классе присутствует метод для создания ипотеки
 * @autor emelyanov 10.04.2021
 */
public class GazpromMortgage implements Mortgage {
    public GazpromMortgage() {
        System.out.println("Create GazpromMortgage");
    }
}
