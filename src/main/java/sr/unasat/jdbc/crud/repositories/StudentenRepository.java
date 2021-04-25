package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Studenten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentenRepository {
    private Connection connection;

    public StudentenRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

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

    public List<Studenten> findAllRecords() {
        List<Studenten> studentenLijst = new ArrayList<Studenten>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from studenten";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int Studenten_id = rs.getInt("Studenten_id");
                String Voornaam = rs.getString("Voornaam");
                String Achternaam = rs.getString("Achternaam");
                String Email_adres = rs.getString("Email_adres");
                //Display values
                System.out.print("Studenten_id: " + Studenten_id);
                System.out.print(", Voornaam: " + Voornaam);
                System.out.print(", Achternaam: " + Achternaam);
                System.out.println(", Email_adres: " + Email_adres);

                studentenLijst.add(new Studenten(Studenten_id, Voornaam, Achternaam, Email_adres));
                //  studentenLijst.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return studentenLijst;
    }

    public int insertOneRecord(Studenten studenten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into studenten (studenten_id, voornaam, achternaam, email_adres) " +
                    "values(?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, studenten.getStudenten_id());
            stmt.setString(2, studenten.getVoornaam());
            stmt.setString(3, studenten.getAchternaam());
            stmt.setString(4, studenten.getEmail_adres());
            result = stmt.executeUpdate();
            System.out.println("inserted: " + studenten.getStudenten_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Studenten studenten){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM studenten WHERE Studenten_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, studenten.getStudenten_id());
            result = stmt.executeUpdate();
            System.out.println("deleted: " + studenten.getStudenten_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
