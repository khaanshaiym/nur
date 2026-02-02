import java.sql.*;

public class OrderDAO {
    public void save(Order order) {
        String sql = "INSERT INTO orders (restaurant_id, order_date) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getRestaurantId());
            ps.setString(2, order.getOrderDate());
            ps.executeUpdate();
            System.out.println("Тапсырыс базаға сақталды!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}