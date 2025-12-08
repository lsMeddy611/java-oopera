import java.util.ArrayList;

public class Show {
    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void setListOfActors(ArrayList<Actor> listOfActors) {
        this.listOfActors = listOfActors;
    }

    public void printDirectorInfo() {
        System.out.println(director);
    }

    public void printListOfActors() {
        if (listOfActors == null || listOfActors.isEmpty()) {
            System.out.println("В данном спектакле нет актеров");
            return;
        }

        for (Actor actor : listOfActors) {
            System.out.println(actor);
        }
    }

    public void addActor(Actor newActor) {
        boolean isAdded = false;

        if (newActor == null) return;

        if (newActor.getName() == null) {
            System.out.println("Нельзя добавить актера без имени");
            return;
        }

        if (newActor.getSurname() == null) {
            System.out.println("Нельзя добавить актера без фамилии");
            return;
        }

        if (newActor.getGender() == null) {
            System.out.println("Нельзя добавить актера без пола");
            return;
        }

        if (newActor.getHeight() == 0) {
            System.out.println("Рост Актера должен быть больше 0 см");
            return;
        }

        for (Actor actor : listOfActors) {
            if (actor.equals(newActor)) {
                System.out.println("Такой актер уже есть в списке");
                return;
            }
        }

        listOfActors.add(newActor);
        isAdded = true;
        if (isAdded) System.out.println("Актер был добавлен в список");
    }

    public void replaceActors(Actor newActor, String oldActorSurname) {
        if (newActor == null || oldActorSurname == null ||oldActorSurname.isEmpty()) {
            System.out.println("Оба поля должны быть заполнены");
            return;
        }

        boolean found = false;

        for (int i = 0; i < listOfActors.size(); i++) {
            Actor currentActor = listOfActors.get(i);

            if (currentActor.getSurname() != null &&
                    currentActor.getSurname().equalsIgnoreCase(oldActorSurname.trim())) {
                Actor oldActor = listOfActors.get(i);
                listOfActors.set(i, newActor);
                System.out.println("Заменили актера " + oldActor + " на " + newActor);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Актер с фамилией '" + oldActorSurname + "' не найден в списке.");
        }
    }
}
