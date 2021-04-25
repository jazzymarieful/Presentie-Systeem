package sr.unasat.jdbc.crud.entities;

public class Presentie {
    private int presentie_id;
    private String inlogtime;
    private Studenten studenten;
    private Lokaal lokaal;

    public Presentie(int presentie_id, String inlogtime, Studenten studenten, Lokaal lokaal) {
        this.presentie_id = presentie_id;
        this.inlogtime = inlogtime;
        this.studenten = studenten;
        this.lokaal = lokaal;
    }

    public Presentie(int presentie_id) {
        this.presentie_id = presentie_id;
    }

    public int getPresentie_id() {
        return presentie_id;
    }

    public String getInlogtime() {
        return inlogtime;
    }

    public Studenten getStudenten() {
        return studenten;
    }

    public Lokaal getLokaal() {
        return lokaal;
    }

}
