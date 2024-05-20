package ru.otus.java.transport;

import ru.otus.java.TypeOfGround;

public class Bike extends Transport {

    public Bike() { // пустой конструктор, т.к. велосипед может использоваться без ограничений
    }

    @Override
    protected boolean ride(int distance, TypeOfGround type) {
        if (type == TypeOfGround.swamp) {
            return false;
        }
        return true;
    }
}
