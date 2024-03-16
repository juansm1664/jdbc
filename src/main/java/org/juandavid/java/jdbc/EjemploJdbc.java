package org.juandavid.java.jdbc;

import org.juandavid.java.jdbc.modelo.Categoria;
import org.juandavid.java.jdbc.modelo.Producto;
import org.juandavid.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juandavid.java.jdbc.repositorio.Repositorio;
import org.juandavid.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("===========Listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("===========Obtener Por id===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("===========Insertar Nuevo Producto===========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Mecanico");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);

            System.out.println("Producto Guardado con exito");
            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

