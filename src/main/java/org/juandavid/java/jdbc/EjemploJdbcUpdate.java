package org.juandavid.java.jdbc;

import org.juandavid.java.jdbc.modelo.Producto;
import org.juandavid.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juandavid.java.jdbc.repositorio.Repositorio;
import org.juandavid.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("===========Listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("===========Obtener Por id===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("===========Editar Producto===========");
            Producto producto = new Producto();
            producto.setId(3L);
            producto.setNombre("Teclado Razer Mecanico");
            producto.setPrecio(740);
            repositorio.guardar(producto);

            System.out.println("Producto Editado con exito");
            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

