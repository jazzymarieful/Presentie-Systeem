package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Lokaal;
import sr.unasat.jdbc.crud.entities.Presentie;
import sr.unasat.jdbc.crud.entities.Studenten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresentieRepository {
    private Connection connection;

    public PresentieRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("De driver is geregistreerd");

            String URL = "jdbc:mysql://localhost:3306/presentie_systeem?autoReconnect=true&useSSL=false";
            String USER = "root";
            String PASS = "";

            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Presentie> findAllRecords() {
        List<Presentie> presentielijst = new ArrayList<Presentie>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select Presentie_id, Inlog_Time, studenten.Studenten_id, studenten.Voornaam, studenten.Achternaam, studenten.Email_adres, Lokaal.Lokaal_id, Lokaal.Lokaal, Lokaal.Vak " +
                    " from presentie" +
                    " join studenten" +
                    " on studenten.studenten_id = presentie.studenten_id " +
                    " join lokaal on lokaal.lokaal_id = presentie.lokaal_id";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            while (rs.next()) {
                int presentie_id = rs.getInt("Presentie_id");
                String inlog_time = rs.getString("Inlog_Time");

                int studenten_id = rs.getInt("Studenten_id");
                String voornaam = rs.getString("Voornaam");
                String achternaam = rs.getString("Achternaam");
                String email_adres = rs.getString("Email_adres");

                int lokaal_id = rs.getInt("Lokaal_id");
                String lokaal = rs.getString("Lokaal");
                String vak = rs.getString("Vak");

                Studenten studenten = new Studenten(studenten_id, voornaam, achternaam, email_adres);
                Lokaal lokalen = new Lokaal(lokaal_id, lokaal, vak);

                System.out.print("Presentie_id: " + presentie_id);
                System.out.print(" Inlog_Time: " + inlog_time);
                System.out.print(" Studenten_id: " + studenten_id);
                System.out.print(" Voornaam: " + voornaam );
                System.out.print(" Achternaam: " + achternaam);
                System.out.print(" Email_adres: " + email_adres);
                System.out.print(" Lokaal_id: " + lokaal_id);
                System.out.print(" Lokaal: " + lokaal);
                System.out.println(" Vak: " + vak);

                presentielijst.add(new Presentie(presentie_id, inlog_time, studenten, lokalen));
            }
            rs.close();

        } catch (SQLException e) {

        } finally {

        }
        return presentielijst;
    }

    public int updateOneRecord(Presentie presentie) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update presentie set Studenten_id = ? , Lokaal_id = ? where Presentie_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, presentie.getStudenten().getStudenten_id());
            stmt.setInt(2, presentie.getLokaal().getLokaal_id());
            stmt.setInt(3, presentie.getPresentie_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Presentie presentie){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM presentie WHERE Presentie_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, presentie.getPresentie_id());
            result = stmt.executeUpdate();
            System.out.println("deleted: " + presentie.getPresentie_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int insertOneRecord(Presentie presentie) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into presentie (Presentie_id, Inlog_Time, Studenten_id, Lokaal_id) " +
                    "values(?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, presentie.getPresentie_id());
            stmt.setString(2, presentie.getInlogtime());
            stmt.setInt(3, presentie.getStudenten().getStudenten_id());
            stmt.setInt(4, presentie.getLokaal().getLokaal_id() );
            result = stmt.executeUpdate();
            System.out.println("inserted: " + presentie.getPresentie_id());

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

        }
        return result;
    }
}
