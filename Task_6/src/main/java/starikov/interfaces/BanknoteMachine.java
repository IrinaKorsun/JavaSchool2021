package starikov.interfaces;

import starikov.models.Banknote;

/**
 * Интерфейс станков для печатания денег
 * Станки должны печать банкноты номиналом 10, 50 и 100
 */
public interface BanknoteMachine {

    Banknote emitDenomination10();

    Banknote emitDenomination50();

    Banknote emitDenomination100();

    /**
     * Метод для получения наименования валюты, с которой работает станок
     */
    String printCurrency();
}
