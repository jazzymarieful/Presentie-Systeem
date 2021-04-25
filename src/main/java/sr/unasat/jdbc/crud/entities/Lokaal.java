package sr.unasat.jdbc.crud.entities;

public class Lokaal {

    private int lokaal_id;
    private String lokaal;
    private String vak;

    public Lokaal(int lokaal_id, String lokaal, String vak){
        this.lokaal_id = lokaal_id;
        this.lokaal = lokaal;
        this.vak = vak;
    }

    public Lokaal(int lokaal_id) {
        this.lokaal_id = lokaal_id;
    }

    public int getLokaal_id() {
        return lokaal_id;
    }

    public String getLokaal() {
        return lokaal;
    }

    public String getVak() { return vak; }

}
