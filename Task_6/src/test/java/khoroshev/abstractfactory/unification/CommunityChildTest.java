package khoroshev.abstractfactory.unification;

import khoroshev.abstractfactory.type.Civil;
import khoroshev.abstractfactory.type.Handyman;
import khoroshev.abstractfactory.type.Law;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommunityChildTest {
    CommunityChild communityChild = new CommunityChild();
    @Test
    void createCivilTest () {
        Civil civil = communityChild.createCivil(4, "Хочу работать на благо общества!");
        String message = "Мой гендер: " + civil.getGender() + "\nМой возраст: " + civil.getAge() + "\n" + civil.getMission();
        assertEquals(message, civil.work());
    }

    @Test
    void createHandymanChildTest () {
        Handyman handyman = communityChild.createHandyman(5, "Когда вырасту, буду шахтёром!");
        String message = "Мой гендер: " + handyman.getGender() + "\nМой возраст: " + handyman.getAge() + "\n" +
                handyman.getMission();
        assertEquals(message, handyman.work());
    }

    @Test
    void createHandymanLawTest () {
        Law law = communityChild.createLaw(16,
                "В следующем году заканчиваю колледж и буду бороться с преступностью!");
        String message = "Мой гендер: " + law.getGender() + "\nМой возраст: " + law.getAge() + "\n" +
                law.getMission();
        assertEquals(message, law.work());
    }

}
