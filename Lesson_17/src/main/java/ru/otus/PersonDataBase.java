package ru.otus;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {

    Map<Long, Person> dataBase = new HashMap<>();

    public void add(Person person) {
        dataBase.put(person.getId(), person);
    }

    public Person findById(Long id) {
        return dataBase.get(id);
    }

    public boolean isManager(Person person) {
        Position position = person.getPosition();
        return position == Position.MANAGER || position == Position.DIRECTOR || position == Position.BRANCH_DIRECTOR ||
                position == Position.SENIOR_MANAGER;
    }

    public boolean isEmployee(Long id) {
        return !isManager(findById(id));
    }


}
