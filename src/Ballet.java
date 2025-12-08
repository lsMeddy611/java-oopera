import java.util.ArrayList;

public class Ballet extends MusicalShow {
    private Choreographer choreographer;


    public Ballet(String title, int duration, Director director, ArrayList<Actor> listOfActors, MusicAuthor musicAuthor
            , String librettoText, Choreographer choreographer) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Ballet(MusicalShow musicalShow, Choreographer choreographer) {
        super(musicalShow.getTitle(), musicalShow.getDuration(), musicalShow.getDirector()
                , musicalShow.getListOfActors(), musicalShow.getMusicAuthor(), musicalShow.getLibrettoText());
        this.choreographer = choreographer;
    }

    public Choreographer getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(Choreographer choreographer) {
        this.choreographer = choreographer;
    }
}
