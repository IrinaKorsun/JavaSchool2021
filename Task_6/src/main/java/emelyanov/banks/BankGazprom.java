package emelyanov.banks;

import emelyanov.BankFactory;
import emelyanov.bankGazprom.GazpromCard;
import emelyanov.bankGazprom.GazpromCredit;
import emelyanov.bankGazprom.GazpromDeposit;
import emelyanov.bankGazprom.GazpromMortgage;
import emelyanov.interfaceBankingProducts.Card;
import emelyanov.interfaceBankingProducts.Credit;
import emelyanov.interfaceBankingProducts.Deposit;
import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Класс BankGazprom реализующий интерфейс BankFactory
 * В классе реализованы методы по созданию кард, кредитов, вкладов, ипотек
 * @autor emelyanov 10.04.2021
 */
public class BankGazprom implements BankFactory {
    @Override
    public Card createCard() {
        return new GazpromCard();
    }

    @Override
    public Credit createCredit() {
        return new GazpromCredit();
    }

    @Override
    public Deposit createDeposit() {
        return new GazpromDeposit();
    }

    @Override
    public Mortgage createMortgage() {
        return new GazpromMortgage();
    }
}
