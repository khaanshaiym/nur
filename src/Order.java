public class Order extends BaseEntity {

    private MenuItem menuItem;
    private int quantity;

    public Order(int id, MenuItem menuItem, int quantity) {
        super(id);
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    public void printOrder() {
        System.out.println("Order ID: " + id);
        menuItem.printInfo();
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + calculateTotal());
    }

    @Override
    public String toString() {
        return "Order{id=" + id +
                ", item=" + menuItem.getName() +
                ", quantity=" + quantity +
                ", total=" + calculateTotal() + '}';
    }
}
