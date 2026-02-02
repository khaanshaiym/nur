public class Order {
    private int restaurantId;
    private String orderDate;

    public Order(int restaurantId, String orderDate) {
        this.restaurantId = restaurantId;
        this.orderDate = orderDate;
    }

    public int getRestaurantId() { return restaurantId; }
    public String getOrderDate() { return orderDate; }
}