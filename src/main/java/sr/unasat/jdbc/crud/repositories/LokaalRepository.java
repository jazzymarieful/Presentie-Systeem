package sr.unasat.jdbc.crud.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LokaalRepository {

    private Connection connection;
    public LokaalRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/presentie_systeem";
            String USER = "root";
            String PASS = "slonorovbe11";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

