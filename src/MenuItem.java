public class MenuItem {
    private int id;
    private String name;
    private double price;

    // Конструкторлар
    public MenuItem() {}

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // JSON форматында қайтару әдісі
    public String toJson() {
        return "{" +
                "\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"price\": " + price +
                "}";
    }

    // Геттерлер мен Сеттерлер (Бұларсыз DAO-да қате шығады)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}