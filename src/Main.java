import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 8080 портында серверді іске қосу
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Сұраныс жолы: http://localhost:8080/api/menu
        server.createContext("/api/menu", (exchange) -> {
            MenuItemDAO dao = new MenuItemDAO();
            List<MenuItem> items = dao.getAll(); // Базадан тізімді алу

            // Тізімді JSON-ға айналдыру
            StringBuilder jsonResponse = new StringBuilder("[");
            for (int i = 0; i < items.size(); i++) {
                jsonResponse.append(items.get(i).toJson());
                if (i < items.size() - 1) jsonResponse.append(",");
            }
            jsonResponse.append("]");

            String response = jsonResponse.toString();

            // Жауап жіберу
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Сервер қосылды! Мына сілтемені аш: http://localhost:8080/api/menu");
    }
}