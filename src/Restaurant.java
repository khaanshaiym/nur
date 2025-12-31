import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {

    private String name;
    private String address;
    private List<Order> orders = new ArrayList<>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    // 🔍 FILTER
    public List<Order> getExpensiveOrders(double minTotal) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.calculateTotal() > minTotal) {
                result.add(o);
            }
        }
        return result;
    }

    // 🔎 SEARCH
    public Order findOrderById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    // 🔃 SORT
    public void sortOrdersByTotal() {
        orders.sort(Comparator.comparingDouble(Order::calculateTotal));
    }

    public void printAllOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
