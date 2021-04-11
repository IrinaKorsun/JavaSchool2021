package emelyanov.banks;

import emelyanov.BankFactory;
import emelyanov.bankVTB.VTBCard;
import emelyanov.bankVTB.VTBCredit;
import emelyanov.bankVTB.VTBDeposit;
import emelyanov.bankVTB.VTBMortgage;
import emelyanov.interfaceBankingProducts.Card;
import emelyanov.interfaceBankingProducts.Credit;
import emelyanov.interfaceBankingProducts.Deposit;
import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Класс BankVTB реализующий интерфейс BankFactory
 * В классе реализованы методы по созданию кард, кредитов, вкладов, ипотек
 * @autor emelyanov 10.04.2021
 */
public class BankVTB implements BankFactory {
    @Override
    public Card createCard() {
        return new VTBCard();
    }

    @Override
    public Credit createCredit() {
        return new VTBCredit();
    }

    @Override
    public Deposit createDeposit() {
        return new VTBDeposit();
    }

    @Override
    public Mortgage createMortgage() {
        return new VTBMortgage();
    }
}
