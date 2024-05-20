package ru.otus.java.transport;

import ru.otus.java.TypeOfGround;

public class Car extends Transport {

    public Car(int stamina, int staminaConsumption) {
        this.stamina = stamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    protected boolean ride(int distance, TypeOfGround type) {
        if (staminaConsumption * distance > stamina || type == TypeOfGround.swamp || type == TypeOfGround.forest) {
            return false;
        }
        stamina -= staminaConsumption * distance;
        return true;
    }
}
