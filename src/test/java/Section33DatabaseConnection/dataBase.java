package Section33DatabaseConnection;

import org.testng.annotations.Test;

import java.sql.*;

public class dataBase {
    @Test
    public void dataBaseJdbc() throws SQLException {
        //1 Connection Setup
        /*This method is used to establish a connection to the specified database.
         */
        Connection con = DriverManager.getConnection("jdbc:mysql://+host+:+port+databaseName", "root", "root");

        //2 Creating a Statement - path
        /*Statement: This object is created from the connection and is used to execute SQL queries.
        It's an interface provided by JDBC to send SQL commands to the database.
         */
        Statement statement = con.createStatement();

        //3 Executing a Query
        /*executeQuery: This method sends an SQL statement to the database, which is expected to return a ResultSet object containing the data produced by the query.
         */
        ResultSet rs = statement.executeQuery("");

        //4 Processing the ResultSet
        /*
        ResultSet: This object contains the data produced by the SQL query.
        rs.next(): This method moves the cursor to the next row of the result set, returning false when there are no more rows.
        rs.getInt("") and rs.getString(""): These methods retrieve column values from the current row of the result set.
         */
        while (rs.next()) {
            System.out.println(rs.getInt(""));
            System.out.println(rs.getString(""));
        }
    }
/*
Close Resources:
Always close the Connection, Statement, and ResultSet objects in a finally block or
use a try-with-resources statement to ensure resources are released properly, preventing memory leaks.

Handle Exceptions:
This code should include proper exception handling for SQL exceptions (like using a try-catch block or declaring specific exceptions).
*/

    @Test
    public void dataBaseJdbcImproved() {
        String url = "jdbc:mysql://localhost:3306/myDatabase"; // Replace with your database URL
        String username = "root"; // Replace with your database username
        String password = "root"; // Replace with your database password

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM myTable")) { // Replace with your SQL query

            while (rs.next()) {
                System.out.println(rs.getInt("id")); // Replace with actual column name or index
                System.out.println(rs.getString("name")); // Replace with actual column name or index
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
