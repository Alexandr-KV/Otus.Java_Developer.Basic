package ru.otus;

public class Person {
    private final String name;
    private Position position;
    private Long id;


    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", id=" + id +
                '}';
    }


}
