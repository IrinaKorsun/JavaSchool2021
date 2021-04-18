package khoroshev.abstractfactory.unification;

import khoroshev.abstractfactory.type.Civil;
import khoroshev.abstractfactory.type.Handyman;
import khoroshev.abstractfactory.type.Law;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunityWomanTest {
    CommunityWoman communityWoman = new CommunityWoman();
    @Test
    void createCivilTest () {
        Civil civil = communityWoman.createCivil( 23,
                "Меня вызвали почистить канализацию, прямо напротив ЦУМ'а. Удобно, вечером куплю айфон");
        String message = "Мой гендер: " + civil.getGender() + "\nМой возраст: " + civil.getAge() + "\n" + civil.getMission();
        assertEquals(message, civil.work());
    }

    @Test
    void createHandymanChildTest () {
        Handyman handyman = communityWoman.createHandyman(56,
                "Настроила швейную машинку, сейчас свяжу платье.");
        String message = "Мой гендер: " + handyman.getGender() + "\nМой возраст: " + handyman.getAge() + "\n" +
                handyman.getMission();
        assertEquals(message, handyman.work());
    }

    @Test
    void createHandymanLawTest () {
        Law law = communityWoman.createLaw(19, "Сегодня меня повысили до лейтенанта!");
        String message = "Мой гендер: " + law.getGender() + "\nМой возраст: " + law.getAge() + "\n" +
                law.getMission();
        assertEquals(message, law.work());
    }
}
