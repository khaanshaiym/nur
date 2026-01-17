public class Main {
    public static void main(String[] args) {

        MenuItemDAO dao = new MenuItemDAO();

        dao.save(new MenuItem("Pizza", 2500));
        dao.findAll();
        dao.updatePrice(1, 3000);
        dao.delete(1);
    }
}
