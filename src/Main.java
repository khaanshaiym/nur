public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Java Cafe", "Astana");

        MenuItem pizza = new MenuItem(1, "Pizza", 2500);
        MenuItem burger = new MenuItem(2, "Burger", 1800);
        MenuItem drink = new MenuItem(3, "Drink", 1500);

        Order order1 = new Order(101, pizza, 2);
        Order order2 = new Order(102, burger, 3);
        Order order3 = new Order(103, drink, 4);

        restaurant.addOrder(order1);
        restaurant.addOrder(order2);
        restaurant.addOrder(order3);

        System.out.println("ALL ORDERS:");
        restaurant.printAllOrders();

        System.out.println("\nEXPENSIVE ORDERS (>5000):");
        for (Order o : restaurant.getExpensiveOrders(5000)) {
            System.out.println(o);
        }

        System.out.println("\nSORTED ORDERS:");
        restaurant.sortOrdersByTotal();
        restaurant.printAllOrders();
    }
}
