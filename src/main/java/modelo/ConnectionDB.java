package modelo;

import java.sql.*;

public class ConnectionDB {

    public static Connection connectDB() {
        Connection connection = null;

        String url = "jdbc:postgresql://localhost:5432/tssm_local";
        String user = "postgres";
        String pwd = "bd0000";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    } 
}
