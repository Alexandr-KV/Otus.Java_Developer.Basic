package ru.otus.java.transport;

import ru.otus.java.TypeOfGround;


public class Human {
    final private String name;
    private Transport currentTransport;
    protected int stamina; // выносливость человека, у другого транспорта такая переменная будет означать количество бензина или сил
    final private int staminaConsumption; // сколько человек тратит выносливости на преодоление условной единицы расстояния

    public Human(String name, int stamina, int staminaConsumption) {
        this.name = name;
        this.stamina = stamina;
        this.staminaConsumption = staminaConsumption;
        currentTransport = null;
    }

    public void getOnTransport(Transport transport) {
        if (currentTransport != null) {
            System.out.println("Для начала мне нужно встать с текущего транспорта");
        } else {
            currentTransport = transport;
        }
    }

    public void getOutOfTransport() {
        currentTransport = null;
    }

    public boolean ride(int distance, TypeOfGround type) {
        if (currentTransport == null) {
            if (staminaConsumption * distance > stamina || type == TypeOfGround.swamp) {
                return false;
            }
            stamina -= staminaConsumption * distance;
            return true;
        }
        return currentTransport.ride(distance, type);
    }


}
