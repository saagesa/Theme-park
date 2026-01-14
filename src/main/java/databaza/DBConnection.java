package databaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {





    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER = "system"; // vendos username
    private static final String PASS = "Sagesa1967*"; // vendos password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // regjistron driver-in
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Testimi i lidhjes
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Lidhja me databazën u realizua me sukses!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}