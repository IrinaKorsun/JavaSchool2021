package khoroshev.abstractfactory.model;

import khoroshev.abstractfactory.type.Civil;
import khoroshev.abstractfactory.type.Handyman;
import khoroshev.abstractfactory.type.Law;

public abstract class Community {
    public abstract Civil createCivil(int age, String mission);
    public abstract Handyman createHandyman(int age, String mission);
    public abstract Law createLaw(int age, String mission);
}
