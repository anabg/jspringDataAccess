import java.sql.*;

/**
 * create schema abgtest

 CREATE TABLE abgtest.Persons (
 PersonID int,
 LastName varchar(255),
 FirstName varchar(255),
 Address varchar(255),
 City varchar(255)
 );
 */
public class JdbcPlainTest {

    private String DB_URL = "jdbc:mysql://localhost:3306/abgtest";
    private final String USER_NAME = "root";
    private final String PASSWORD = "perinola123";

    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (
                ClassNotFoundException e)

        {
            e.printStackTrace();
        } catch (
                SQLException e)

        {
            e.printStackTrace();
        }
        return conn;
    }

    private void query() {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = createConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Persons");
            while (rs.next())
                System.out.println(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        JdbcPlainTest t = new JdbcPlainTest();
        t.query();
    }
}
