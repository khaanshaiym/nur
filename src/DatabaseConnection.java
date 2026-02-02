import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Mamapapa2007" ; // ОСЫ ЖЕРГЕ ПАРОЛЬ ЖАЗЫҢЫЗ

        return DriverManager.getConnection(url, user, password);
    }
}