package ru.otus;

import java.util.*;

public class PersonDataBase {
    private static final Set<Position> DIRECTORS_POSITIONS = Set.of(
            Position.DIRECTOR, Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER, Position.MANAGER);

    Map<Long, Person> dataBase = new HashMap<>();

    public void add(Person person) {
        dataBase.put(person.getId(), person);
    }

    public Person findById(Long id) {
        return dataBase.get(id);
    }

    public boolean isManager(Person person) {
        Position position = person.getPosition();
        return DIRECTORS_POSITIONS.contains(position);
    }

    public boolean isEmployee(Long id) {
        return !isManager(findById(id));
    }

}
