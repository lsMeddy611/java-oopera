package main.persons;

public class Choreographer extends Person {

    public Choreographer(String name, String surname, GENDER gender) {
        super(name, surname, gender);
    }

    public Choreographer(Person person) {
        super(person.getName(), person.getSurname(), person.getGender());
    }

    @Override
    public String toString() {
        return "Хориограф: " + super.toString();
    }
}
