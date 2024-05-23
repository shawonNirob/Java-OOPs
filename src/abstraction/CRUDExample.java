package abstraction;

import java.sql.*;

public class CRUDExample {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // Connect to the MySQL database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create a new record
            createRecord("John", 30);

            // Read all records
            readRecords();

            // Update a record
            updateRecord(1, "UpdatedName", 40);

            // Delete a record
            deleteRecord(2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection, statement, and result set
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Create operation
    private static void createRecord(String name, int age) throws SQLException {
        statement = connection.createStatement();
        String sql = "INSERT INTO users (name, age) VALUES ('" + name + "', " + age + ")";
        statement.executeUpdate(sql);
        System.out.println("Record created successfully.");
    }

    // Read operation
    private static void readRecords() throws SQLException {
        statement = connection.createStatement();
        String sql = "SELECT * FROM users";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Name: " + resultSet.getString("name") +
                    ", Age: " + resultSet.getInt("age"));
        }
    }

    // Update operation
    private static void updateRecord(int id, String name, int age) throws SQLException {
        statement = connection.createStatement();
        String sql = "UPDATE users SET name='" + name + "', age=" + age + " WHERE id=" + id;
        statement.executeUpdate(sql);
        System.out.println("Record updated successfully.");
    }

    // Delete operation
    private static void deleteRecord(int id) throws SQLException {
        statement = connection.createStatement();
        String sql = "DELETE FROM users WHERE id=" + id;
        statement.executeUpdate(sql);
        System.out.println("Record deleted successfully.");
    }
}

