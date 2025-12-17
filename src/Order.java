public class Order {

    private int orderId;
    private MenuItem menuItem;
    private int quantity;

    public Order(int orderId, MenuItem menuItem, int quantity) {
        this.orderId = orderId;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        menuItem.printInfo();
        System.out.println("Quantity: " + quantity);
        System.out.println("Total price: " + calculateTotal());
    }
}
