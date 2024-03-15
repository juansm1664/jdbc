package org.juandavid.java.jdbc;

import org.juandavid.java.jdbc.modelo.Producto;
import org.juandavid.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juandavid.java.jdbc.repositorio.Repositorio;
import org.juandavid.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(p-> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

