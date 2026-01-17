public class Order {
    private int id;
    private MenuItem menuItem;
    private int quantity;

    public Order(int id, MenuItem menuItem, int quantity) {
        this.id = id;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Order{id=" + id +
                ", item=" + menuItem.getName() +
                ", quantity=" + quantity +
                ", total=" + calculateTotal() +
                "}";
    }
}

