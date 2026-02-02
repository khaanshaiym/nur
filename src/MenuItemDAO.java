import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDAO {

    // WRITE (Создание записи)
    public void save(MenuItem item) {
        String sql = "INSERT INTO menuitem (name, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.executeUpdate();
            System.out.println("Saved: " + item.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (Чтение данных)
    public List<MenuItem> getAll() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menuitem";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MenuItem item = new MenuItem();
                item.setId(rs.getInt(1));    // ID (1-я колонка)
                item.setName(rs.getString(2)); // Name (2-я колонка)
                item.setPrice(rs.getDouble(3)); // Price (3-я колонка)
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // UPDATE (Обновление)
    public void update(int id, String newName, double newPrice) {
        String sql = "UPDATE menuitem SET name = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setDouble(2, newPrice);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Updated ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE (Удаление)
    public void delete(int id) {
        String sql = "DELETE FROM menuitem WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}