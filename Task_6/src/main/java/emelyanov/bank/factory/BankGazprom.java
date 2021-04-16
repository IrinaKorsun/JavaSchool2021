package emelyanov.bank.factory;

import emelyanov.bank.model.gazprom.GazpromCard;
import emelyanov.bank.model.gazprom.GazpromCredit;
import emelyanov.bank.model.gazprom.GazpromDeposit;
import emelyanov.bank.model.gazprom.GazpromMortgage;
import emelyanov.bank.model.Card;
import emelyanov.bank.model.Credit;
import emelyanov.bank.model.Deposit;
import emelyanov.bank.model.Mortgage;

/*
 * Класс gazprom реализующий интерфейс BankFactory
 * @autor emelyanov 10.04.2021
 */
public class BankGazprom implements BankFactory {
    /*
     *Создает новый объект класса GazpromCard
     */
    @Override
    public Card createCard() {
        return new GazpromCard();
    }

    /*
     *Создает новый объект класса GazpromCredit
     */
    @Override
    public Credit createCredit() {
        return new GazpromCredit();
    }

    /*
     *Создает новый объект класса GazpromDeposit
     */
    @Override
    public Deposit createDeposit() {
        return new GazpromDeposit();
    }

    /*
     *Создает новый объект класса GazpromMortgage
     */
    @Override
    public Mortgage createMortgage() {
        return new GazpromMortgage();
    }
}
