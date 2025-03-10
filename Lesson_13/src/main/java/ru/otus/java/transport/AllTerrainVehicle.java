package ru.otus.java.transport;

import ru.otus.java.TypeOfGround;

public class AllTerrainVehicle extends Transport {

    public AllTerrainVehicle(int stamina, int staminaConsumption) {
        this.stamina = stamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    protected boolean ride(int distance, TypeOfGround type) {
        if (staminaConsumption * distance <= stamina) {
            stamina -= staminaConsumption * distance;
            return true;
        }
        return false;
    }
}
