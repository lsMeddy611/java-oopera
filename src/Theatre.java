import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {

    public static void main(String[] args) {
        Director director1 = new Director("Анатолий", "Одинец", Person.GENDER.MALE, 4);
        Director director2 = new Director("Юлия", "Мастыко", Person.GENDER.FEMALE, 6);
        Actor actor1 = new Actor("Петр", "Иванов", Person.GENDER.MALE, 186);
        Actor actor2 = new Actor("Анастасия", "Смирнова", Person.GENDER.FEMALE, 167);
        Actor actor3 = new Actor("Дмитрий", "Лебедев", Person.GENDER.MALE, 175);
        Choreographer choreographer = new Choreographer("Святослав", "Левченко", Person.GENDER.MALE);
        MusicAuthor musicAuthor = new MusicAuthor("Анастасия", "Кузнецова", Person.GENDER.FEMALE);

        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);

        ArrayList<Actor> showActors = new ArrayList<>();
        ArrayList<Actor> operaActors = new ArrayList<>();
        ArrayList<Actor> balletActors = new ArrayList<>();

        Show show = new Show("Спектакль обычный", 120, director1, showActors);
        Opera opera = new Opera("Спектакль оперный", 150, director2, operaActors, musicAuthor
                , "Текст Либретто", 6);
        Ballet ballet = new Ballet("Спектакль балет", 105, director1, balletActors, musicAuthor
                , "Текст Либретто", choreographer);

        ArrayList<Show> shows = new ArrayList<>();
        shows.add(show);
        shows.add(opera);
        shows.add(ballet);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.next();
            switch (command) {
                case "1":
                    printLebretto(shows, scanner);
                    break;
                case "2":
                    printShowDirector(shows, scanner);
                    break;
                case "3":
                    printAllShowActors(shows, scanner);
                    break;
                case "4":
                    addNewActorInShow(shows ,actors, scanner);
                    break;
                case "5":
                    changeActorsBySurname(shows, actors, scanner);
                    break;
                case "6":
                    addNewActorInActors(actors, scanner);
                    break;
                case "0":

                    return;
                default:
                    System.out.println("Ошибка, такого пункта в меню не существует");
            }
        }

    }

    private static void printMenu() {
        System.out.println();
        System.out.println("-".repeat(20));
        System.out.println();
        System.out.println("Выберите пункт меню:");
        System.out.println("1 - Распечатать текст либретто");
        System.out.println("2 - Распечатать информацию о режиссёре спектакля");
        System.out.println("3 - Распечатать список всех актёров, участвующих в спектакле");
        System.out.println("4 - Добавить нового актёра в спектакль");
        System.out.println("5 - Заменить одного актёра в спектакле на другого по фамилии");
        System.out.println("6 - Добавить нового актёра в общий список актеров");
        System.out.println("0 - завершить программу");
    }

    private static void printLebretto(ArrayList<Show> shows, Scanner scanner) {
        ArrayList<MusicalShow> musicalShowsList = new ArrayList<>();
        int counter = 0;

        System.out.println("Выберите номер нужной пьесы:");
        for (int i = 0; i < shows.size(); i++) {
            Show currentShow = shows.get(i);
            if (currentShow.getClass() == Opera.class || currentShow.getClass() == Ballet.class) {
                musicalShowsList.add((MusicalShow)currentShow);
                System.out.println(++counter + " - " +currentShow.getTitle());
            }
        }
        int musicalShowNubmer = scanner.nextInt();
        if (musicalShowNubmer < 1 || musicalShowNubmer > musicalShowsList.size()) {
            System.out.println("Такого номера нет в списке");
            return;
        }
        System.out.println(musicalShowsList.get(musicalShowNubmer - 1).getLibrettoText());;
    }

    private static void printShowDirector(ArrayList<Show> shows, Scanner scanner) {
        int showNumber = choiceShow(shows, scanner);
        if (showNumber != -1) {
            shows.get(showNumber).printDirectorInfo();
        }
    }

    private static void printAllShowActors(ArrayList<Show> shows, Scanner scanner) {
        int showNumber = choiceShow(shows, scanner);
        if (showNumber != -1) {
            shows.get(showNumber).printListOfActors();
        }
    }

    private static void addNewActorInShow (ArrayList<Show> shows, ArrayList<Actor> actors, Scanner scanner) {
        int showNumber = choiceShow(shows, scanner);
        Actor newActor = choiceActor(actors, scanner);
        shows.get(showNumber).addActor(newActor);
    }

    private static void changeActorsBySurname(ArrayList<Show> shows,ArrayList<Actor> actors,Scanner scanner) {
        int showNumber = choiceShow(shows, scanner);
        Actor newActor = choiceActor(actors, scanner);
        System.out.println("Введите фамилию актера, которого вы хотите заменить");
        String oldActorSurname = scanner.next();
        shows.get(showNumber).replaceActors(newActor, oldActorSurname);
    }
    
    private static int choiceShow(ArrayList<Show> shows, Scanner scanner) {
        int counter = 0;

        System.out.println("Выберите номер нужного спектакля:");
        for (Show show : shows) {
            System.out.println(++counter + " - " + show.getTitle());
        }
        int showNumber = scanner.nextInt();
        if (showNumber < 1 || showNumber > shows.size()) {
            System.out.println("Такого номера нет в списке");
            return -1;
        }
        return showNumber - 1;
    }

    private static Actor choiceActor(ArrayList<Actor> actors, Scanner scanner) {
        int counter = 0;

        System.out.println("Выберите номер актера, которого хотите добавить:");
        for (Actor actor : actors) {
            System.out.println(++counter + " - " + actor.getName() + " " + actor.getSurname());
        }
        int actorNumber = scanner.nextInt();
        if (actorNumber < 1 || actorNumber > actors.size()) {
            System.out.println("Такого номера нет в списке");
            return null;
        }
        return actors.get(actorNumber - 1);
    }

    private static void addNewActorInActors(ArrayList<Actor> actors,Scanner scanner) {
        System.out.println("Введите Имя:");
        String newActorName = scanner.next().trim();
        if (newActorName == null || newActorName.isEmpty()) {
            System.out.println("Имя не может быть пустым значением");
            return;
        }
        System.out.println("Введите Фамилию:");
        String newActorSurname = scanner.next().trim();
        if (newActorSurname == null || newActorSurname.isEmpty()) {
            System.out.println("Фамилия не может быть пустым значением");
            return;
        }
        System.out.println("Введите пол м/ж:");
        String newActorGenderInput = scanner.next().trim();
        Person.GENDER newActorGender;
        if (newActorGenderInput.equalsIgnoreCase("м")) {
            newActorGender = Person.GENDER.MALE;
        } else if (newActorGenderInput.equalsIgnoreCase("ж")) {
            newActorGender = Person.GENDER.FEMALE;
        } else {
            System.out.println("Вы ввели неверное значение");
            return;
        };
        System.out.println("Введите рост в см");
        int newActorHeight = scanner.nextInt();
        if (newActorHeight <= 0) {
            System.out.println("Роста должен быть больше нуля");
            return;
        }
        Actor newActor = new Actor(newActorName, newActorSurname, newActorGender, newActorHeight);
        for (Actor actor : actors) {
            if (actor.equals(newActor)) {
                System.out.println("Такой актер уже есть в списке");
                return;
            }
        }
        actors.add(new Actor(newActorName, newActorSurname, newActorGender, newActorHeight));
        System.out.println("Актер был добавлен в список");
    }
}
