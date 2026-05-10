package br.edu.ifpa.laboratorio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL =
            "jdbc:mysql://localhost:3306/controle_laboratorio";

    private static final String USER = "root";

    private static final String PASSWORD = "Ayd@2310";

    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}