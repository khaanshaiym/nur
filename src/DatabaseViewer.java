import java.sql.*;

public class DatabaseViewer {
    public static void listTables() {
        String sql = "SELECT * FROM menu_item";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("menu_item_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                System.out.printf("ID: %d | Name: %-10s | Price: %.2f%n", id, name, price);
            }
        } catch (SQLException e) {
            System.out.println("Кестені оқу қатесі:");
            e.printStackTrace();
        }
    }
}