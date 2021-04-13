package cz.educanet;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT Z.jmeno, D.nazev \n" +
                "FROM Zvirata as Z join Druhy as D ON (Z.druh = D.id)\n" +
                "LIMIT 15");

        String zvireJmeno;
        String druhNazev;
        while(result.next()) {
            zvireJmeno = result.getString("jmeno");
            druhNazev = result.getString("nazev");
            System.out.println("Jmeno: " + zvireJmeno + ", Druh: " + druhNazev);
        }

        connection.close();
    }
}
