import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2EmbeddedExample {

    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:~/h2/test";
        String username = "sa";
        String password = "";

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Connected to H2 embedded database.");

        String sql = "Create table if not exists students (ID int primary key, name varchar(50))";

        Statement statement = connection.createStatement();

        statement.execute(sql);

        System.out.println("Created table students.");

        sql = "Insert into students (ID, name) values (5, 'Ajay')";

        int rows = statement.executeUpdate(sql);

        if (rows > 0) {
            System.out.println("Inserted a new row.");
        }

        sql = "SELECT * FROM students";

        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        while (resultSet.next()) {
            count++;

            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println("Student #" + count + ": " + ID + ", " + name);
        }
        connection.close();
    }
}