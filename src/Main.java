public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Java Cafe", "Astana");
        restaurant.printInfo();
        System.out.println();

        MenuItem pizza = new MenuItem(1, "Pizza", 2500);
        MenuItem burger = new MenuItem(2, "Burger", 1800);

        Order order1 = new Order(101, pizza, 2);
        Order order2 = new Order(102, burger, 3);

        order1.printOrder();
        System.out.println();
        order2.printOrder();
        System.out.println();

        if (order1.calculateTotal() > order2.calculateTotal()) {
            System.out.println("Order 1 is more expensive");
        } else {
            System.out.println("Order 2 is more expensive");
        }
    }
}
