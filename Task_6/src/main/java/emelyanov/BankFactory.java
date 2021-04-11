package emelyanov;

import emelyanov.interfaceBankingProducts.Card;
import emelyanov.interfaceBankingProducts.Credit;
import emelyanov.interfaceBankingProducts.Deposit;
import emelyanov.interfaceBankingProducts.Mortgage;

/*
 * Общий интерфейс с банковскими продуктами BankFactory
 * Банки должны создавать карты, кредиты, вклады, ипотеки
 * @autor emelyanov 10.04.2021
 */
public interface BankFactory {

    Card createCard();

    Credit createCredit();

    Deposit createDeposit();

    Mortgage createMortgage();
}
