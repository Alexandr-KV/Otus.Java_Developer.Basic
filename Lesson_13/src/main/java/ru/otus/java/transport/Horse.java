package ru.otus.java.transport;

import ru.otus.java.TypeOfGround;

public class Horse extends Transport {

    public Horse(int stamina, int staminaConsumption) {
        this.stamina = stamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    protected boolean ride(int distance, TypeOfGround type) {
        if (staminaConsumption * distance > stamina || type == TypeOfGround.SWAMP) {
            return false;
        }
        stamina -= staminaConsumption * distance;
        return true;
    }
}
