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
        return person.getPosition() == Position.MANAGER || person.getPosition() == Position.DIRECTOR ||
                person.getPosition() == Position.BRANCH_DIRECTOR || person.getPosition() == Position.SENIOR_MANAGER;
    }

    public boolean isEmployee(Long id) {
        return findById(id).getPosition() != Position.MANAGER || findById(id).getPosition() != Position.DIRECTOR ||
                findById(id).getPosition() != Position.BRANCH_DIRECTOR || findById(id).getPosition() != Position.SENIOR_MANAGER;
    }


}
