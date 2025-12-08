public class MusicAuthor extends Person{

    public MusicAuthor(String name, String surname, GENDER gender) {
        super(name, surname, gender);
    }

    public MusicAuthor(Person person) {
        super(person.getName(), person.getSurname(), person.getGender());
    }

    @Override
    public String toString() {
        return "Автор музыки: " + getName() + " " + getSurname();
    }
}
