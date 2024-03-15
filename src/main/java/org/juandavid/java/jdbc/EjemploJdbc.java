package org.juandavid.java.jdbc;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/java_practica?serverTimeZone=UTC";
        String username = "root";
        String password = "12345";
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM  productos");

            while (result.next()){
                System.out.println(result.getString("nombre"));
            }
            result.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
