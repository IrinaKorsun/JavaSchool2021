package khoroshev.abstractfactory.unification;

import khoroshev.abstractfactory.type.Civil;
import khoroshev.abstractfactory.type.Handyman;
import khoroshev.abstractfactory.type.Law;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunityManTest {
    CommunityMan communityMan = new CommunityMan();
    @Test
    void createCivilTest () {
        Civil civil = communityMan.createCivil( 34, "Выхожу на работу, работаю доктором.");
        String message = "Мой гендер: " + civil.getGender() + "\nМой возраст: " + civil.getAge() + "\n" + civil.getMission();
        assertEquals(message, civil.work());
    }

    @Test
    void createHandymanChildTest () {
        Handyman handyman = communityMan.createHandyman(44,
                "Еду к своей любимой стройке, чтоб её.");
        String message = "Мой гендер: " + handyman.getGender() + "\nМой возраст: " + handyman.getAge() + "\n" +
                handyman.getMission();
        assertEquals(message, handyman.work());
    }

    @Test
    void createHandymanLawTest () {
        Law law = communityMan.createLaw( 23, "Сегодня планирую ограбить пару банков.");
        String message = "Мой гендер: " + law.getGender() + "\nМой возраст: " + law.getAge() + "\n" +
                law.getMission();
        assertEquals(message, law.work());
    }
}
