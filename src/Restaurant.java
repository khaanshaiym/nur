public class Restaurant {

    private String name;
    private String address;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void printInfo() {
        System.out.println("Restaurant: " + name);
        System.out.println("Address: " + address);
    }
}
