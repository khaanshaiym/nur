public class Restaurant {

    private int id;
    private String name;
    private String city;

    public Restaurant(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
