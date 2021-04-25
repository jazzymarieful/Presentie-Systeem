package sr.unasat.jdbc.crud.entities;

public class Studenten {
    private int studenten_id;
    private String voornaam;
    private String achternaam;
    private String email_adres;

    public Studenten(int studenten_id, String voornaam, String achternaam, String email_adres) {
        this.studenten_id = studenten_id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email_adres = email_adres;
    }

    public Studenten(int studenten_id) {
        this.studenten_id = studenten_id;
    }

    public int getStudenten_id() {
        return studenten_id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getEmail_adres() {
        return email_adres;
    }

}
