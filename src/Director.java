public class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surname, GENDER gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    public Director(Person person, int numberOfShows) {
        super(person.getName(), person.getSurname(), person.getGender());
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return "Режиссёр спектакля: " + getName() + " " + getSurname();
    }
}
