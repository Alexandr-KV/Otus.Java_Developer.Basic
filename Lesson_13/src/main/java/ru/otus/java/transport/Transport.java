package ru.otus.java.transport;

import ru.otus.java.TypeOfGround;

public abstract class Transport {
    protected int stamina;
    protected int staminaConsumption;

    protected abstract boolean ride(int distance, TypeOfGround type);
}
