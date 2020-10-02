package controller;

import java.sql.*;

public class Connect {

    private final String url = "jdbc:postgresql://localhost:5432/tkrgo";
    private final String user = "admintkrgo";
    private final String password = "11";

    public Connection connect() throws Exception {
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("No conectado");
        }

        return connection;
    } 
}
