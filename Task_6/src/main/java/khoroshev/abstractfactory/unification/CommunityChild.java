package khoroshev.abstractfactory.unification;

import khoroshev.abstractfactory.model.Community;
import khoroshev.abstractfactory.type.Civil;
import khoroshev.abstractfactory.type.Handyman;
import khoroshev.abstractfactory.type.Law;

public class CommunityChild extends Community {
    private static final String GENDER = "ребёнок";
    @Override
    public Civil createCivil(int age, String mission) {
        return new Civil(GENDER, age, mission);
    }

    @Override
    public Handyman createHandyman(int age, String mission) {
        return new Handyman(GENDER, age, mission);
    }

    @Override
    public Law createLaw(int age, String mission) {
        return new Law(GENDER, age, mission);
    }
}
