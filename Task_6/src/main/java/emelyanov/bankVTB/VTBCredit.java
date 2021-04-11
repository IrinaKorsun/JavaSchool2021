package emelyanov.bankVTB;

import emelyanov.interfaceBankingProducts.Credit;

/*
 * Класс VTBCredit реализующий интерфейс Credit
 * В классе присутствует метод для создания кредита
 * @autor emelyanov 10.04.2021
 */
public class VTBCredit implements Credit {
    public VTBCredit() {
        System.out.println("Create VTBCredit");
    }
}
