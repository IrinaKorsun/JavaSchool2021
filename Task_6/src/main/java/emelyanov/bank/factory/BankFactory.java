package emelyanov.bank.factory;

import emelyanov.bank.model.Card;
import emelyanov.bank.model.Credit;
import emelyanov.bank.model.Deposit;
import emelyanov.bank.model.Mortgage;

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