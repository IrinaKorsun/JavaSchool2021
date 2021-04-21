package emelyanov.bank.factory;

import emelyanov.bank.model.vtb.VTBCard;
import emelyanov.bank.model.vtb.VTBCredit;
import emelyanov.bank.model.vtb.VTBDeposit;
import emelyanov.bank.model.vtb.VTBMortgage;
import emelyanov.bank.model.Card;
import emelyanov.bank.model.Credit;
import emelyanov.bank.model.Deposit;
import emelyanov.bank.model.Mortgage;

/*
 * Класс vtb реализующий интерфейс BankFactory
 * @autor emelyanov 10.04.2021
 */
public class BankVTB implements BankFactory {
    /*
     *Создает новый объект класса GazpromCard
     */
    @Override
    public Card createCard() {
        return new VTBCard();
    }

    /*
     *Создает новый объект класса GazpromCard
     */
    @Override
    public Credit createCredit() {
        return new VTBCredit();
    }

    /*
     *Создает новый объект класса GazpromCard
     */
    @Override
    public Deposit createDeposit() {
        return new VTBDeposit();
    }

    /*
     *Создает новый объект класса GazpromCard
     */
    @Override
    public Mortgage createMortgage() {
        return new VTBMortgage();
    }
}
