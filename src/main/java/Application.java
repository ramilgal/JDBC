import java.sql.*;
public class Application {
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "123654";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id=(2)")) {
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("ID сотрудника: " + idOfEmployee);

                String nameOfEmployee = resultSet.getString("first_name");
                String surenameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");


                System.out.println("Имя, Фамилия: " + nameOfEmployee + " " + surenameOfEmployee);
                System.out.println("Пол сотрудника: " + genderOfEmployee);
                System.out.println("Возраст сотрудника: " + ageOfEmployee);

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

}
