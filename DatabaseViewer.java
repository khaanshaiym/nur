import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseViewer {

    // Метод для получения списка таблиц в базе данных
    public static void listTables() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Получаем метаданные базы данных
            DatabaseMetaData metaData = connection.getMetaData();

            // Получаем все таблицы в схеме public
            ResultSet resultSet = metaData.getTables(null, "public", "%", new String[]{"TABLE"});

            System.out.println("Список таблиц в базе данных:");
            while (resultSet.next()) {
                // Выводим имя таблицы
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Главный метод для запуска программы
    public static void main(String[] args) {
        listTables(); // Вызов метода для отображения таблиц
    }
}
