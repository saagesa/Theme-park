package databaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER = "system";
    private static final String PASS = "Sagesa1967*";

    private static Connection connection; // Singleton connection

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(URL, USER, PASS);
        }
        return connection;
    }
}
