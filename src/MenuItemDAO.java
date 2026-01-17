import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDAO {

    // CREATE
    public void save(MenuItem item) {
        String sql = "INSERT INTO menu_item(name, price) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setInt(2, item.getPrice());
            ps.executeUpdate();

            System.out.println("MenuItem saved");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<MenuItem> findAll() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT id, name, price FROM menu_item";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("=== MENU ITEMS ===");

            while (rs.next()) {
                MenuItem item = new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                );
                items.add(item);
                System.out.println(item.getId() + " | " + item.getName() + " | " + item.getPrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    // UPDATE
    public void updatePrice(int id, int newPrice) {
        String sql = "UPDATE menu_item SET price = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newPrice);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Price updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM menu_item WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int deleted = ps.executeUpdate();

            if (deleted > 0) {
                System.out.println("MenuItem deleted");
            } else {
                System.out.println("MenuItem not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
