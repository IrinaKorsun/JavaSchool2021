package emelyanov.banks;

import emelyanov.BankFactory;

import emelyanov.bankSberbank.SberbankCard;
import emelyanov.bankSberbank.SberbankCredit;
import emelyanov.bankSberbank.SberbankDeposit;
import emelyanov.bankSberbank.SberbankMortgage;
import emelyanov.interfaceBankingProducts.Card;
import emelyanov.interfaceBankingProducts.Credit;
import emelyanov.interfaceBankingProducts.Deposit;
import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Класс BankSberbank реализующий интерфейс BankFactory
 * В классе реализованы методы по созданию кард, кредитов, вкладов, ипотек
 * @autor emelyanov 10.04.2021
 */
public class BankSberbank implements BankFactory {
    @Override
    public Card createCard() {
        return new SberbankCard();
    }

    @Override
    public Credit createCredit() {
        return new SberbankCredit();
    }

    @Override
    public Deposit createDeposit() {
        return new SberbankDeposit();
    }

    @Override
    public Mortgage createMortgage() {
        return new SberbankMortgage();
    }
}
