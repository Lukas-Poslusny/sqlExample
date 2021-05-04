package cz.educanet;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/c3zoo", "root", "");

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT Z.id, Z.jmeno, D.nazev \n" +
                "FROM Zvirata AS Z JOIN Druhy AS D ON (Z.druh = D.id)\n" +
                "GROUP BY Z.id\n" +
                "LIMIT 15");

        String zvireId;
        String zvireJmeno;
        String druhNazev;
        while(result.next()) {
            zvireId = result.getString("id");
            zvireJmeno = result.getString("jmeno");
            druhNazev = result.getString("nazev");
            System.out.println("Id: " + zvireId + ", Jmeno: " + zvireJmeno + ", Druh: " + druhNazev);
        }

        connection.close();
    }
}
