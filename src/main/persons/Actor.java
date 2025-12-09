package main.persons;

import java.util.Objects;

public class Actor extends Person {
    private double height;

    public Actor(String name, String surname, GENDER gender, double height) {
        super(name, surname, gender);
        this.height = height;
    }

    public Actor(Person person, double height) {
        super(person.getName(), person.getSurname(), person.getGender());
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getName(), actor.getName()) &&
                Objects.equals(getSurname(), actor.getSurname()) &&
                Objects.equals(getHeight(), actor.getHeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), height);
    }

    @Override
    public String toString() {
        return super.toString() + " (" + getHeight() + ")";
    }
}


