package database;

import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/sistema_curadoria?useSSL=false&serverTimezone=UTC";
            String usuario = "root";
            String senha = "30072007";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado: " + ex.getMessage());
            return null;
        }
    }
}
