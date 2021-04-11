package emelyanov.bankVTB;

import emelyanov.interfaceBankingProducts.Card;

/*
 * Класс VTBCard реализующий интерфейс Card
 * В классе присутствует метод для создания карты
 * @autor emelyanov 10.04.2021
 */
public class VTBCard implements Card {
    public VTBCard() {
        System.out.println("Create VTBCard");
    }
}
