package emelyanov.bankSberbank;

import emelyanov.interfaceBankingProducts.Card;

/*
 * Класс SberbankCard реализующий интерфейс Card
 * В классе присутствует метод для создания карты
 * @autor emelyanov 10.04.2021
 */
public class SberbankCard implements Card {
    public SberbankCard() {
        System.out.println("Create SberbankCard");
    }
}
