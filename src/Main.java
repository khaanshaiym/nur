public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Java Cafe", "Astana");
        restaurant.printInfo();
        System.out.println();

        MenuItem pizza = new MenuItem(1, "Pizza", 2500);
        MenuItem burger = new MenuItem(2, "Burger", 1800);
        MenuItem drink = new MenuItem(3, "Drink", 1500);


        Order order1 = new Order(101, pizza, 2);
        Order order2 = new Order(102, burger, 3);
        Order order3 = new Order(103, drink, 4);

        order1.printOrder();
        System.out.println();
        order2.printOrder();
        System.out.println();
        order3.printOrder();
        System.out.println();


        if (order1.calculateTotal() > order2.calculateTotal() && order1.calculateTotal() > order3.calculateTotal()) {
            System.out.println("Order 1 is more expensive");
        } else if (order2.calculateTotal() > order1.calculateTotal() && order2.calculateTotal() > order3.calculateTotal()){
            System.out.println("Order 2 is more expensive");
        } else if (order3.calculateTotal() > order1.calculateTotal() && order3.calculateTotal() > order2.calculateTotal()){
            System.out.println("Order 3 is more expensive");
        } else {
            System.out.println("There is a tie in prices.");
        }
    }
}