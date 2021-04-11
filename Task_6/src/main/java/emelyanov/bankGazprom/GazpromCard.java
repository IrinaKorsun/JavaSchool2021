package emelyanov.bankGazprom;

import emelyanov.interfaceBankingProducts.Card;

/*
 * Класс GazpromCard реализующий интерфейс Card
 * В классе присутствует метод для создания карты
 * @autor emelyanov 10.04.2021
 */
public class GazpromCard implements Card {
    public GazpromCard() {
        System.out.println("Create GazpromCard");
    }
}
